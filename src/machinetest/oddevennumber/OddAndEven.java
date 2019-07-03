package machinetest.oddevennumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印奇数和偶数
 * @author skyxt
 * Created 2019-07-03 11:24
 * Email skyxt.yang@gmail.com
 */
public class OddAndEven {


    private static class MyThread {
        volatile int count = 0;
        int limit = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public MyThread(int count, int limit) {
            this.count = count;
            this.limit = limit;
        }

        void synchronizedPrint() {
            while (count < limit) {
                synchronized (OddAndEven.class) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + "   --number:" + count++);
                    try {
                        OddAndEven.class.notifyAll();
                        if (count < limit) {
                            OddAndEven.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void lockPrint() {

        }
    }


//  /**第一种:采用监听器实现*/
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread(0, 100);
//        Thread thread1 = new Thread(null, myThread::synchronizedPrint, "Thread1");
//        Thread thread2 = new Thread(null, myThread::synchronizedPrint, "Thread2");
//        try {
//            thread1.start();
//            thread2.start();
//            thread1.join();
//            thread2.join();
//            System.out.println("xxx");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread(0, 100);
        Thread thread1 = new Thread(null, myThread::synchronizedPrint, "Thread1");
        Thread thread2 = new Thread(null, myThread::synchronizedPrint, "Thread2");
        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("xxx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
