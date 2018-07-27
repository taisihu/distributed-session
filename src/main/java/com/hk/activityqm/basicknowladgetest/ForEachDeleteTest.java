package com.hk.activityqm.basicknowladgetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public class ForEachDeleteTest {

    public static void main(String[] args){

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }

    }

}
