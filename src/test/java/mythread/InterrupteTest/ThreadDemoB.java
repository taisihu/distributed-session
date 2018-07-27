package mythread.InterrupteTest;

/**
 * Created by Administrator on 2018/5/15.
 */
public class ThreadDemoB {

    public static void main(String argv[])throws InterruptedException{
        ThreadB tb=new ThreadB();
        tb.setName("ThreadA");
        tb.start();
        Thread.sleep(5000);
        System.out.println(tb.getName()+"正在被中断...");
        tb.interrupt();
        System.out.println("ta.isInterrupted()="+tb.isInterrupted());
    }

}
