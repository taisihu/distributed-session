package net.apex.ssh.mytest.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/15.
 */
public class BlockingQueueTest1 {

    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);


    public static void main(String[] args){
        BlockingQueueTest1 blockingQueueTest = new BlockingQueueTest1();
        blockingQueueTest.productData();
        blockingQueueTest.consumeData();
    }


    public void productData(){
        Thread p = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(2000);
                    System.out.println("--------放入数据:s");
                    queue.offer("s",2, TimeUnit.SECONDS);
                    System.out.println("--------queue长度"+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        p.start();
    }

    public void consumeData(){
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("=====取数据：" + queue.poll(3,TimeUnit.SECONDS));//超时不会抛异常
                    System.out.println("--------queue长度"+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        c.start();

    }


}
