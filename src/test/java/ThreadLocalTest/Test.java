package ThreadLocalTest;

public class Test {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args){
        final Test test = new Test();


        test.set();//在thread1线程中调用同一个ThreadLocal对象的set方法
//        //主线程
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();//在thread1线程中调用同一个ThreadLocal对象的set方法
//                for(int i=0;i<5;i++){
//                    System.out.println("睡眠:"+i);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        };
        try {
            thread1.start();
            thread1.join();//在主线程中调用了thread1的join方法，thread执行完成才会执行主(main)线程
            //用户线程
            System.out.println("执行new Thread方法："+test.getLong());
            System.out.println("执行new Thread方法："+test.getString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("执行main方法："+test.getLong());
        System.out.println("执行main方法："+test.getString());
    }
}