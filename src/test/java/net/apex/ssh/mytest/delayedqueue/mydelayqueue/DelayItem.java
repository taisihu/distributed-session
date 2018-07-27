package net.apex.ssh.mytest.delayedqueue.mydelayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/17.
 */
public class DelayItem implements Delayed {

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

}
