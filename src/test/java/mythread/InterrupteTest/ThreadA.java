package mythread.InterrupteTest;

/**
 * Created by Administrator on 2018/5/15.
 */
public class ThreadA extends Thread {
    int count=0;
    public void run(){
        System.out.println(getName()+"将要运行...");
        while(!this.isInterrupted()){
            System.out.println(getName()+"运行中"+count++);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){//和ThreadB的区别在这里，捕获到异常之后，interrupt的状态就被置为false
                System.out.println(getName()+"从阻塞中退出...");
                System.out.println("this.isInterrupted()="+this.isInterrupted());
                this.interrupt();//在这里再次将interrupt的状态设置为true，程序检测到中断便退出
            }
        }
        System.out.println(getName()+"已经终止!");
    }
}