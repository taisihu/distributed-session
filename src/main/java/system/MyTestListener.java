package system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2018/5/31.
 */
public class MyTestListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("============MyTestListener contextInitialized======================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("============MyTestListener contextDestroyed======================");
    }
}
