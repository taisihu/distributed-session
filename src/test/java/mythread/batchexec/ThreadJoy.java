package mythread.batchexec;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/7/3.
 */
public class ThreadJoy{

    CountDownLatch countDownLatch = new CountDownLatch(20);

    @Test
    public void testStart(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("aaaaaaaaa");
            }
        }).start();

        for(int i=0;i<20;i++){
            System.out.println("-----"+countDownLatch.getCount());
            countDownLatch.countDown();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
