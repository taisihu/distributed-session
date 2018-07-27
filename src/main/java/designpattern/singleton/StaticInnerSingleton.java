package designpattern.singleton;

/**
 * Created by Administrator on 2018/6/14.
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {
        if (SingletonHolder.instance != null) {
            throw new IllegalStateException();
        }
    }

    private static class SingletonHolder {
        private static StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
    }

}