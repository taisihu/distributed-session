package mythread.trackingexec;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/6/1.
 */
public class TrackingExecutor extends AbstractExecutorService {

    private final ExecutorService executorService;

    private final Set<Runnable> tasksCancelledAtShutDown = Collections.synchronizedSet(new HashSet<Runnable>());

    public TrackingExecutor(ExecutorService executorService){
        this.executorService = executorService;
    }

    public List<Runnable> getCanncelldTasks(){
        if(!executorService.isTerminated())
            throw new IllegalStateException("");
        return new ArrayList<Runnable>(tasksCancelledAtShutDown);
    }

    @Override
    public void execute(final Runnable runnable) {

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                try{
                    runnable.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    if(isShutdown()&&Thread.currentThread().isInterrupted()){
                        tasksCancelledAtShutDown.add(runnable);
                    }

                }

            }
        });

    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout,unit);
    }
}
