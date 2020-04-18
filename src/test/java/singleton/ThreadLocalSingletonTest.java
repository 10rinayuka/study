package singleton;

import com.riku.study.singleton.threadlocal.ThreadLocalSingleton;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/26
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
    }
}
