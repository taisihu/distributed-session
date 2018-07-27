package mythread.synccontainers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
public class SyncClasses {

    public static void main(String[] args){

        List<Integer> numberList = new ArrayList<Integer>();

        Iterator<Integer> numberListItator = numberList.iterator();
        if(numberListItator.hasNext()){
            numberListItator.remove();
        }

        Collections.synchronizedList(new ArrayList<Object>());

    }

}
