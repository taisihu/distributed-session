package basetest;

/**
 * Created by Administrator on 2017/3/20.
 */
public class TestSubString {

    public static void main(String[] args){

//        String s = "A,J";
//
//        char c = s.substring(0,1).toCharArray()[0];
//
//        System.out.println(c);

//        System.out.println(s.substring(0,1).charAt(0));


//        short st = 1;
//
//        int i = SeedStatus.DEBUGED.ordinal();
//
//        System.out.print(st == i);


        String idstr = "123";
        System.out.print(idstr.substring(idstr.length()-1));

    }

}


enum SeedStatus{
    NOT_DEBUG, 	//信源未调试
    DEBUGED,	//已调试
    LOCKED,		//发布锁定
    ON_LINE,	//已上线
    ON_LINE_BACKED, //上线退回
    INVALID,		//失效
    INCREMENTING  //增量检测
}