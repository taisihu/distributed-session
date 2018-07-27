package testthread.execute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/3/6.
 */
public class TaskExecution1 {

    private static final Executor EXEC =Executors.newSingleThreadExecutor();

    public static void main(String[] args){

        List list = new ArrayList();
        Iterator iterator = list.iterator();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("i am Runnable.run()");
            }
        };

        EXEC.execute(task);

    }


}
