package basetest.testbasic;

/**
 * Created by Administrator on 2018/3/9.
 */
public class TestByte {

    public static void main(String[] args){

        int a = 120;
        int b = 21;

        String s = Integer.toBinaryString(a + b);

        int i = (byte)(a+b);
        System.out.println(s);
        System.out.println(i);

    }


}
