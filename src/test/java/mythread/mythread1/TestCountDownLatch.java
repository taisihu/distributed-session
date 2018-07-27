package mythread.mythread1;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/4/6.
 */
public class TestCountDownLatch {

    public static void main(String[] args){


        CountDownLatch countDownLatch = new CountDownLatch(2);

        Worker worker1 = new Worker("zhangsan",countDownLatch);
        Worker worker2 = new Worker("lisi",countDownLatch);
        worker1.start();
        worker2.start();

        try {
            countDownLatch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        CountDownLatch countDownLatch1 = new CountDownLatch(2);
//
//        Worker worker3 = new Worker("wanger",countDownLatch1);
//        Worker worker4 = new Worker("mazi",countDownLatch1);
//        worker3.start();
//        worker4.start();

        System.out.println("all work is done");

    }


}

class Worker extends Thread{

    String workerName;
    CountDownLatch latch;

    public Worker(String workerName,CountDownLatch latch){
        this.workerName=workerName;
        this.latch=latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(workerName+" is done work");

    }
}
