package net.apex.ssh.mytest;

/**
 * Created by Administrator on 2017/2/6.
 */
public class RoleSum {

    private int sum(int i){
        if(i==1)
            return 1;
        else
            return sum(i) + sum(--i);
    }


    public static void main(String[] args){

        RoleSum rs = new RoleSum();
        rs.sum(10);

    }

}
