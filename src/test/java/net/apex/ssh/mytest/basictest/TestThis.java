package net.apex.ssh.mytest.basictest;

/**
 * Created by Administrator on 2017/2/14.
 */
public class TestThis {

    public static void main(String[] args){

        TestThis testThis = new TestThis();
        TestThis.ThisInner thisInner = testThis.new ThisInner();

        System.out.println(thisInner);

    }

    public class ThisInner{

    };

}
