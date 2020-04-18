package singleton;

import util.ExecutorThread;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/28
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());

        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
