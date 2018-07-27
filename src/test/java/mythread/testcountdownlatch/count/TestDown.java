package mythread.testcountdownlatch.count;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/2/26.
 */
public class TestDown {

    CountDownLatch startLatch = new CountDownLatch(1);

    CountDownLatch countDownLatch = new CountDownLatch(5);

    public void testTask(){

        for(int i=0;i<5;i++){
            new Thread(){
                @Override
                public void run() {

                    System.out.println(countDownLatch.getCount());
                    try {
                        startLatch.await();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println(countDownLatch.getCount());
                }
            }.start();
        }

//        System.out.println("执行完毕");

        try {
            startLatch.countDown();
            countDownLatch.await();
            System.out.println("执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        TestDown testDown = new TestDown();
        testDown.testTask();

    }

}
