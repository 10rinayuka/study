package singleton;

import com.riku.study.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/26
 */
public class ReflectTest {
    public static void main(String[] args) {

        try {
            // 反射破坏单例
            Class<?> clzz = LazyStaticInnerClassSingleton.class;
            Constructor c = clzz.getDeclaredConstructor(null);
            c.setAccessible(true);

            Object o1 = c.newInstance();
            Object o2 = c.newInstance();

            System.out.println(o1);
            System.out.println(o2);
        } catch (Exception e) {
            //

        }
    }
}
