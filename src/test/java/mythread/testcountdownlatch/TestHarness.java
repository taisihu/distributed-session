package mythread.testcountdownlatch;

import com.sun.javafx.tk.Toolkit;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/11/8.
 */
public class TestHarness {

    public long testTask(int nThreads,final Runnable task) throws InterruptedException {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i=0;i<nThreads;i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        startGate.await();//等待到0再往下执行
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        endGate.countDown();
                        System.out.println(endGate.getCount());
                    }
                }
            };

            t.start();

        }


        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();//等待到0再往下执行
        long end = System.currentTimeMillis();
        System.out.println(start-end);
        return start-end;
    }

    public static void main(String[] args){

        TestHarness testHarness = new TestHarness();

        class LocalTask implements Runnable{
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=====i am thread===");
            }
        }

        try {
            long time = testHarness.testTask(5,new LocalTask());
            System.out.println("-----"+time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
