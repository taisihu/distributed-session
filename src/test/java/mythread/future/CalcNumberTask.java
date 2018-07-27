package mythread.future;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2018/4/8.
 */
public class CalcNumberTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        long sleepStart = System.currentTimeMillis();

        System.out.println("睡眠开始时间:"+sleepStart);

        Thread.sleep(5000);

        System.out.println("睡眠时间:"+(System.currentTimeMillis()-sleepStart));

        return 1;
    }
}
