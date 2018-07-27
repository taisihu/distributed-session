package basetest;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/4/6.
 */
public class TestReplace {

    public static void main(String[] args){

//        String s = "saaaaaa%sbbbbb";
//        String s1 = String.format(s,"c");
//        System.out.println(s1);
//        System.out.println(s1.substring(0,s1.indexOf('c')));


        String s = "adsfqwerfgtyhnjuioSaaaaa";
        String s1 = s.replace('a','A');
        System.out.println(s1);

    }

}
