package util;

import com.riku.study.singleton.lazy.LazyDoubleCheckSingleton;
import com.riku.study.singleton.register.ContainerSingleton;
import com.riku.study.singleton.register.ContainerThreadSafeSingleton;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/28
 */
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        Object instance = ContainerThreadSafeSingleton.getInstance("constant.Pojo");
        System.out.println(Thread.currentThread().getName() + ": " + instance);
    }
}
