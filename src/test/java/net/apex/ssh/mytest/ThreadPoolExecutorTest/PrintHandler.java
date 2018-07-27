package net.apex.ssh.mytest.ThreadPoolExecutorTest;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/2/15.
 */
public class PrintHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        System.out.println("------- i am PrintHandler ---------");

    }
}
