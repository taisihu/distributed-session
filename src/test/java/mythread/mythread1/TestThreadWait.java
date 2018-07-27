package mythread.mythread1;

/**
 * Created by Administrator on 2017/2/14.
 */
public class TestThreadWait {

    public static void main(String[] args){

        ThreadWait threadWait = new ThreadWait();

        threadWait.waitThreadA();
        threadWait.notifyThreadA();

    }

}
