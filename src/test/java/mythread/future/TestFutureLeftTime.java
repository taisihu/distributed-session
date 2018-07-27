package mythread.future;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/4/8.
 */
public class TestFutureLeftTime {

    public void calcNumber(){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,3000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),new FutureRejectedExecutionHandler());

        Future<Integer> numberFuture = executor.submit(new CalcNumberTask());

        try {
            Integer number =  numberFuture.get(2, TimeUnit.SECONDS);
            System.out.print(number);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (TimeoutException e) {
            numberFuture.cancel(true);//此处终止了任务执行,不在打印任务中的提示性语句
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        TestFutureLeftTime testFutureLeftTime = new TestFutureLeftTime();
        testFutureLeftTime.calcNumber();

    }

}
