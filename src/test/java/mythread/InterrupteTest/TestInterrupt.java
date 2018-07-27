package mythread.InterrupteTest;

/**
 * Created by Administrator on 2018/5/15.
 */
public class TestInterrupt {


    public static void main(String[] args){


        for(int i=0;i<1000;i++){

            System.out.println(i);
            if(i==5){
                Thread.currentThread().interrupt();
            }

        }

        while (Thread.currentThread().isInterrupted()){
            System.out.println("=======isInterrupted");
        }



    }

}
