package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author skyxt
 * Created 2019-06-27 14:03
 * Email skyxt.yang@gmail.com
 */
public class TestSemaphore {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 最多10个线程同时访问
        final Semaphore semaphore = new Semaphore(10);
        // 20个线程同时启动
        for (int i = 1; i <= 20; i++) {
            final int index = i;
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可
                        semaphore.acquire();
                        // 调用资源
                        callRomote(index);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // 访问完后，释放
                        //semaphore.release();
                        //availablePermits()指的是当前库中有多少个许可可以被使用
                        System.out.println("availablePermits => " + semaphore.availablePermits() + " the index: " + index);
                    }
                }
            });
        }
        // 退出线程池
        exec.shutdown();
    }

    /**
     * 被调用资源
     *
     * @param arg
     */
    public static void callRomote(int arg) {
        System.out.println("arg: " + arg);
        try {
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
