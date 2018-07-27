package basetest;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/12.
 */
public class TestClander {

    public Date getBeforeDate(Date date, int days) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - days);
        return now.getTime();
    }


    public Date zerolizedTime(Date fullDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fullDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static void main(String[] args){

        TestClander testClander = new TestClander();

        Date date = testClander.getBeforeDate(new Date(),7);


        System.out.println(testClander.zerolizedTime(date).toString());

    }

}
