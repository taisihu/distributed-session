package mythread.trackingexec;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/6/1.
 */
public abstract class WebCrawler {

    private volatile TrackingExecutor exec;

    private final Set<URL> urlsToCrawer = new HashSet<URL>();

    public synchronized void start(){

        exec = new TrackingExecutor(Executors.newCachedThreadPool());

        for(URL url : urlsToCrawer){

            //TODO 启动任务


        }

        urlsToCrawer.clear();

    }

    public synchronized void stop() throws InterruptedException{



    }

    protected abstract List<URL> processPage(URL url);

    private void saveUnCrawled(List<Runnable> uncrawled){

        for(Runnable task : uncrawled){

            urlsToCrawer.add(((CrawlerTask)task).getPage());

        }

    }

    private void submitCrawlerTask(URL url){

        exec.execute(new CrawlerTask(url));

    }

    private class CrawlerTask implements Runnable{

        private final URL page;

        public CrawlerTask(URL page){
            this.page = page;
        }

        @Override
        public void run() {
            for(URL link : processPage(page)){
                if(Thread.currentThread().isInterrupted()){
                    return;
                }
                submitCrawlerTask(link);
            }
        }

        public URL getPage() {
            return page;
        }
    }



}
