package net.hk.mutithread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 *
 *
 *
 */
public class Plate {

    List<Object> eggPlate = new ArrayList<Object>();

    //取鸡蛋
    public synchronized void getEgg(){

        while (eggPlate.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eggPlate.clear();
        notify();
        System.out.println("拿到鸡蛋");

    }

    public synchronized void putEgg(){
        while (eggPlate.size()>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eggPlate.add(new Object());
        notify();
        System.out.println("放入鸡蛋");
    }

    public static void main(String[] args){

        Plate plate = new Plate();

        new Thread(new AddThread(plate)).start();
        new Thread(new GetThread(plate)).start();

    }

}

class AddThread implements Runnable{

    private Plate plate;

    public AddThread(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        plate.putEgg();
    }
}

class GetThread implements Runnable{

    private Plate plate;

    public GetThread(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        plate.getEgg();
    }
}
