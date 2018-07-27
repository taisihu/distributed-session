package basetest;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/3/29.
 */
public class TestSplit {

    public static void main(String[] args){

//        String s = ".houseList .list.rel>dl>dt_$_.plptinfo_txt .more";
        String s = "aaaaaaaa_$_bbbbbbbbb_ccccc";
//        String[] sArr = StringUtils.split(s,"_$_");
        String[] sArr = StringUtils.splitByWholeSeparator(s, "_$_");

        System.out.println(sArr);


    }

}
