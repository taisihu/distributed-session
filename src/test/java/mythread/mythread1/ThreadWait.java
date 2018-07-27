package mythread.mythread1;

/**
 * Created by Administrator on 2017/2/14.
 */
public class ThreadWait {

    private Object object = new Object();

    public void waitThreadA(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    try {
                        System.out.println("=======开始wait()========");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("-------wait() end------");
                }
            }
        }){};
        thread.start();
    }


    public void notifyThreadA(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("........notify()............");
//                    object.notify();
                }

            }
        });
        thread.start();
    }




}
