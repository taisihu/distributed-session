package mythread;

/**
 * Created by Administrator on 2017/3/20.
 */
public class TestSynchronized {

    public static void main(String[] args){

        Access access = new Access();

        access.syncMethod(0);
        access.syncMethod(1);
        access.syncMethod(2);
        access.syncMethod(3);

//        for(int i=0;i<2;i++){
//            access.syncMethod(i);
//            access.normalMethod(i);
//        }



    }

}

class Access{

    public void syncMethod(int order){

        System.out.println("--------i am syncMethod--------"+order);
        if (order==0){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void normalMethod(int order){

        System.out.println("--------i am normalMethod--------"+order);

    }

}
