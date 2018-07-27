package net.apex.ssh.mytest.basictest;

/**
 * Created by Administrator on 2017/3/1.
 */
public class TestBreak {


    public static void main(String[] args){

        for(int i=0;i<10;i++){

            System.out.println("=======i="+i);

            for(int j=0;j<5;j++){

                System.out.println("---j="+j);
                if(j==2)
                    break;
            }

        }

    }


}
