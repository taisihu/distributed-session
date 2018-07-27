package mythread.batchexec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/7/3.
 */
//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
public class BatchExec{

    public static final int THREAD_NUM = 100;

    CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

    @Test
    public void testBatchMark(){
        Thread[] threads =  new Thread[THREAD_NUM];
        for(int i=0;i<THREAD_NUM;i++){
            Thread thread = new Thread(new ThreadUser());
            thread.setName("joy"+"--"+i);
            threads[i] = thread;
            thread.start();//TODO ???
            System.out.println("创建第"+i+"个线程");
            countDownLatch.countDown();
        }

        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadUser implements Runnable {

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==="+Thread.currentThread().getName());
        }


    }


}


