package net.apex.ssh.mytest.basictest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/1.
 */
public class TestSet {

    public static void main(String[] args){

        Set<String> set = new HashSet<String>();

        boolean f = set.add("s");
        boolean f1 = set.add("s");


        System.out.println(f);
        System.out.println(f1);


    }

}
