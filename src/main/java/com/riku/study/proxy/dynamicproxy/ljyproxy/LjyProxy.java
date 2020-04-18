package com.riku.study.proxy.dynamicproxy.ljyproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class LjyProxy {

    private static final String PACKAGE_NM = LjyProxy.class.getPackage().getName();
    private static final String SEMICOLON = ";";
    private static final String LN = "\r\n";

    public static Object newProxyInstance(LjyClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          LjyInvocationHandler h) {

        try {

            // 1. 动态生成源代码 .java文件
            String src = generateSrc(interfaces);
//            System.out.println(src);

            // 2. Java文件输出到磁盘，保存为 ¥Proxy0.java
            String filePath = LjyProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();

            // 3. 编译成class文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4. class文件加载到jvm中
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            Constructor<?> constructor = proxyClass.getConstructor(LjyInvocationHandler.class);
            // 加载完以后，删除生成的文件
            file.delete();

            // 5. 返回新的代理对象
            return constructor.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder src = new StringBuilder();

        // package
        src.append("package " + PACKAGE_NM + SEMICOLON + LN);
        // import interface
        for (Class<?> anInterface : interfaces) {
            src.append("import " + anInterface.getName() + SEMICOLON + LN);
        }
        src.append("import java.lang.reflect.*;" + LN);
        src.append("public final class $Proxy0 implements " + interfaces[0].getName() + "{" + LN);

        //
        src.append("LjyInvocationHandler h;" + LN);
        src.append("public $Proxy0(LjyInvocationHandler h) {" + LN);
        {
            src.append("this.h = h;" + LN);
        }
        src.append("}" + LN);

        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();
            Parameter[] parameters = m.getParameters();

            StringBuilder pNames = new StringBuilder();
            StringBuilder pClasses = new StringBuilder();
            StringBuilder pValues = new StringBuilder();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                Parameter value = parameters[i];
                if (i > 0) {
                    pClasses.append(", ");
                    pValues.append(", ");
                    pNames.append(", ");
                }
                pClasses.append(clazz.getName() + ".class");
                pValues.append(value.getName());
                pNames.append(value.toString());
            }

            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "( ");
            src.append(pNames);
            src.append(" ) {" + LN);
            {
                src.append("try {" + LN);
                {
                    src.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{ ");
                    src.append(pClasses);
                    src.append(" });" + LN);

                    src.append("this.h.invoke(this, m, new Object[]{ ");
                    src.append(pValues);
                    src.append(" });" + LN);

                    src.append("return;" + LN);
                }
                src.append("} catch (Error _ex) { }" + LN);
                src.append("catch (Throwable throwable) { throw new UndeclaredThrowableException(throwable); }" + LN);
            }
            src.append("}" + LN);
        }
        src.append("}");
        return src.toString();
    }
}
