package net.hk.htmlfetch;

import net.hk.util.FileUtil;

/**
 * Created by Administrator on 2017/7/31.
 */
public class FetchHtmlToy {


    public static void main(String[] args){

        String url = "http://bbs.0550.com/";

        try {
            String result = HttpUtil.doHTTP(url);
//            FileUtil.writeToFile("E:\\html_fetch","juzi1",result);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
