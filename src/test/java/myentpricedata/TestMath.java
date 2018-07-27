package myentpricedata;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2018/1/4.
 */
public class TestMath {

    public static void main(String[] args){

//        int i = 100001%10000;
//        int i1 = 20000%10000;
//        System.out.println(i +"-"+i1);


        String line = "aaf90c91b86d07121b55775fdba855ce\"11_cu_022686123";
        int dotIndex = line.indexOf("\"");
        String code = StringUtils.substring(line, 0, dotIndex);
        System.out.println(code);

    }

}
