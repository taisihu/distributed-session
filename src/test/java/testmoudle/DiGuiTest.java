package testmoudle;


import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/3/28.
 */
public class DiGuiTest {

    public static void main(String[] args){

        DiGuiTest diGuiTest = new DiGuiTest();
        System.out.println(diGuiTest.testSub("aaaaaaaaaa_bsd_efg"));

    }


    public String testSub(String s){
        if(s.contains("_")){
            return testSub(StringUtils.split(s,"_")[1]);
        }
        return s;
    }


}
