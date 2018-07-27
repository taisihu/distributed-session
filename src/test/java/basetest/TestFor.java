package basetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2017/3/30.
 */
public class TestFor {

    private final static Logger logger = LoggerFactory.getLogger(TestFor.class);

    public static void main(String[] args){

        logger.error("aaaaaaaaaaaaaa");

//        CopyOnWriteArrayList

        int num = 500;

        for(int i=0;i<num;i++){

            if(i/20==0){
                System.out.println("----"+i);
                continue;
            }

        }

    }


}
