package mythread;

/**
 * Created by Administrator on 2017/3/24.
 *
 *
 * 此程序说明同
 */
public class TwoThreadStart {

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run() {

                for(int i=0;i<10;i++){
                    System.out.println("-------- i am first thread "+Thread.currentThread().getId()+" ----------");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("-------- i am second thread "+Thread.currentThread().getId()+" ----------");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }


}
