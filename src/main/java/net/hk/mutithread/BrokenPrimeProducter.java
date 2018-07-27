package net.hk.mutithread;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/10.
 */
class BrokenPrimeProducter extends Thread {

    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancelled = false;

    public BrokenPrimeProducter(BlockingQueue<BigInteger> queue1){
        this.queue = queue1;
    }



    @Override
    public void run() {

        try {
            BigInteger p = BigInteger.ONE;
            System.out.println("1========cancelled状态:" + cancelled);
            while (!cancelled){
                BigInteger sub_p = p.nextProbablePrime();
                System.out.println("1.生产========" + sub_p);
                queue.put(sub_p);//生产太快，导致阻塞
                System.out.println("生产者queue的size:"+queue.size());
                if(queue.size()==3){
                    System.out.println("=====阻塞======");
                }
            }
        }catch (InterruptedException e){

        }

    }

    public void cancel(){
        cancelled = true;
    }

    void consumePrime(BrokenPrimeProducter brokenPrimeProducter){

        BlockingQueue<BigInteger> primes = brokenPrimeProducter.queue;

        brokenPrimeProducter.start();

        try {
            while (true){
                Thread.sleep(3000);//(1)消费者慢比生产者快，导致生产者者阻塞
                BigInteger sub_p = primes.take();
                System.out.println("2.消费========" + sub_p);
                consume(sub_p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            brokenPrimeProducter.cancel();//此处设置取消标志位true，不再进行循环获取数据
            System.out.println("2========cancelled状态:" + cancelled);
            System.out.println("生产者queue的size:"+queue.size());
        }

    }

   void consume(BigInteger prime){
        queue.add(prime);
    }

    public static void main(String[] args){

        BrokenPrimeProducter brokenPrimeProducter = new BrokenPrimeProducter(new ArrayBlockingQueue<BigInteger>(3));

        brokenPrimeProducter.consumePrime(brokenPrimeProducter);



    }


}