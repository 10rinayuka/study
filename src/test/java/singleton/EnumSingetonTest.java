package singleton;

import com.riku.study.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/26
 */
public class EnumSingetonTest {

    public static void main(String[] args) {
        EnumSingleton instance =  EnumSingleton.getInstance();
        instance.setData("01");

        try {

            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);

            c.setAccessible(true);

            EnumSingleton o2 = (EnumSingleton) c.newInstance();

            System.out.println(o2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
