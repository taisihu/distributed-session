package net.apex.ssh.mytest;

//import org.mapdb.Caches;

import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Hashtable;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestMeth {

    public String formatDouble4(double d) {
        DecimalFormat df = new DecimalFormat("#0.00");

        return df.format(d);
    }

    public static void main(String[] args){

//        TestMeth tm = new TestMeth();
//        String d = tm.formatDouble4(1.00);
//        System.out.println(d);

//        Hashtable ht = new Hashtable();

        String str = String.valueOf(2);
        Short s = new Short(str);

        System.out.println(s);

    }

}
