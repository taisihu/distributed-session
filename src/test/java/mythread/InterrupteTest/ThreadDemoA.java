package mythread.InterrupteTest;

/**
 * Created by Administrator on 2018/5/15.
 */
public class ThreadDemoA {

    public static void main(String argv[])throws InterruptedException{
        ThreadA ta=new ThreadA();
        ta.setName("ThreadA");
        ta.start();
        Thread.sleep(5000);
        System.out.println(ta.getName()+"正在被中断...");
        ta.interrupt();
        System.out.println("ta.isInterrupted()="+ta.isInterrupted());
    }

}
