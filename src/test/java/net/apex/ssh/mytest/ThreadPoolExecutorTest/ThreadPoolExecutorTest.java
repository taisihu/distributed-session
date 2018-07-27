package net.apex.ssh.mytest.ThreadPoolExecutorTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/15.
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args){

//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,3,2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(2),
                new PrintHandler());

        //当提交的任务数>maxmumPoolSize+workQueue,执行RejectedExecutionHandler
        for(int i=0;i<10;i++){
            threadPoolExecutor.execute(new PrintThread());
        }

    }

}
