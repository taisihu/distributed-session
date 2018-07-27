package mythread.future;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/5/30.
 */
public class TestFutureCancel {

    public void timedRun(Runnable r,ThreadPoolExecutor executor,long timeout,TimeUnit unit) throws InterruptedException{

        Future<Boolean> task = (Future<Boolean>) executor.submit(r);

        try {
            Boolean result = task.get(timeout,unit);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
//            e.printStackTrace();
//            Thread.interrupted();
//            Thread.sleep(2000);
        }finally {
            task.cancel(true);//true：如果任务正在运行，将被中断
        }


    }

    public static void main(String[] args){

        TestFutureCancel futureCancel = new TestFutureCancel();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        CancelTask cancelTask = new CancelTask();
        try {
            futureCancel.timedRun(cancelTask,executor,2,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("=========main catch exception==========");
        }


    }

}

class CancelTask implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("==========sleep 1 seconds==========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("========CancelTask do nothing=========");
    }

}
