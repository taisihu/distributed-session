package culeusermatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
public class SubListTest {

    public static void main(String[] args){

        List<String> list = new ArrayList<String>();

        for(int i=0;i<20;i++){

            list.add("string_"+i);

        }

        System.out.println(list.get(10));


    }


}
