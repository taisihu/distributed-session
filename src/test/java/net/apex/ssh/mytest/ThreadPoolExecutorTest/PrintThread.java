package net.apex.ssh.mytest.ThreadPoolExecutorTest;

/**
 * Created by Administrator on 2017/2/15.
 */
public class PrintThread implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("======= i am PrintThread ========");

    }
}
