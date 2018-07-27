package mythread.testfuturetask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2018/2/27.
 */
public class PreLoader {

    /**
     * 创建一个FutureTask
     */
    FutureTask<String> futureTask = new FutureTask<String>(
            new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("sleep 2 seconds...");
                    Thread.sleep(2000);
                    return "i am Callable";
                }
            }
    );

    /**
     * 将任务提交个线程
     */
    Thread taskThread = new Thread(futureTask);

    public void startThread(){
        taskThread.start();
    }

    public String getTaskResult(){
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
//            e.getCause();
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){

        PreLoader preLoader = new PreLoader();
        preLoader.startThread();
        String result = preLoader.getTaskResult();
        System.out.println(result);

    }

}
