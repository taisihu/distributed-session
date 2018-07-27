package net.apex.ssh.mytest.basictest;

/**
 * Created by Administrator on 2017/2/28.
 */
public class TestRolling {

    public static void main(String[] args){

        int k = 0;

        for(int i=0;i<9;i++){
            k++;
            if(k>10)
                break;
            System.out.println("-----------i="+i);
            for(int j=i*2;j<i*2+2;j++){
                if(j>10){
                    i=0;
                    continue;
                }
                System.out.println("--j="+j);
            }

        }

    }

}
