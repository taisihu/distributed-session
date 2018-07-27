package mythread.ThreadPoolExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/6/26.
 */
public class SimplePool {

    Executor executor = Executors.newCachedThreadPool();

}
