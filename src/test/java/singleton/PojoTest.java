package singleton;

import util.ExecutorThread;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/26
 */
public class PojoTest {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ExecutorThread());
            thread.start();
        }

    }
}
