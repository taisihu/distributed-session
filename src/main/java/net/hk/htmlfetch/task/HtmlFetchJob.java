package net.hk.htmlfetch.task;

import net.hk.htmlfetch.HttpException;
import net.hk.htmlfetch.HttpUtil;
import net.hk.util.DateUtil;
import net.hk.util.FileUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/28.
 */
@Component("fetchJob")
public class HtmlFetchJob {

    //TODO 到时候打开
//    @Scheduled(cron = "0 0/29 * * * ?")
    public void fetchHtmlWithCookie(){


        String cur_time_sign  = DateUtil.format(new Date(), DateUtil.DATE_HMS_FORMAT_SIGN);

        System.out.println("当前执行任务时间：" + cur_time_sign);
//        String url = "http://id.ifeng.com/";
//        String cookieStr = "userid=1474598455785_zafeq1753; vjuids=7687c48f2.1586c139de4.0.5550ecc271b2; __gads=ID=5e98126a7174baf9:T=1484703558:S=ALNI_Ma-oevqt9HNdQMhu3tQOudSdjlEuA; UM_distinctid=15cbf10d9b871-05f574c74e966a-3c365601-13c680-15cbf10d9b9c97; BDTUJIAID=a7d0f918e977275e11b9e8d199349548; selCityName=%E6%9D%AD%E5%B7%9E; _ga=GA1.2.832174270.1500275498; vjlast=1479281975.1500538184.11; autologin=0; Hm_lvt_b64c5492cbc3815e527cf22d1857788e=1500623806; PHPSESSID=qcltasa6d5dmggd6t2eba4lvn2; IF_TIME=1501229423520; IF_REAL=0; sid=BD9795066172D1997C77249D81318642user84495865; IF_USER=hutaisi%40worken.cn; reborn=BXANJQxmVH0BNVBiVmVUbQA5WzgCY1Jn; prov=cn0571; city=0571; weather_city=zj_hz; region_ip=115.238.44.226; region_ver=1.30";
//        String url = "http://ehire.51job.com/Candidate/ResumeView.aspx?hidUserID=455602910&hidEvents=23&pageCode=3&hidKey=d8ff1235fb707f6b6c228f6eff61a678";
//        String cookieStr ="guid=15020009475712930062; EhireGuid=5153d167c30149f2860f69fa195f3c38; 51job=cenglish%3D0; ASP.NET_SessionId=arv2zsybp5t2uuh2mej31nqy; HRUSERINFO=CtmID=3330726&DBID=2&MType=02&HRUID=4174733&UserAUTHORITY=1111111111&IsCtmLevle=1&UserName=hkdw8388&IsStandard=0&LoginTime=08%2f09%2f2017+11%3a13%3a34&ExpireTime=08%2f09%2f2017+11%3a23%3a34&CtmAuthen=0000011000000001000110010000000011100001&BIsAgreed=true&IsResetPwd=0&CtmLiscense=1&AccessKey=a15121d54380ee6d; AccessKey=e7090a77812b44a; KWD=SEARCH=; LangType=Lang=&Flag=1";

        String url = "http://i.autohome.com.cn/setting/index";
        String cookieStr = "fvlid=1473574769870UafrhDbZ; sessionip=115.238.44.226; sessionid=0DE7BB4C-83C7-4FFC-A0F4-07BB5B416488%7C%7C2016-09-11+14%3A19%3A30.053%7C%7C0; UM_distinctid=15da5fcba56928-0f8ec0c600e641-3c365601-13c680-15da5fcba5710c3; ahpau=1; WanLiTongTip_54901971=1; mylead_54901971=11; sessionfid=2704229298; historybbsName4=c-2288%7C%E9%98%BF%E5%B0%94%E6%B3%95%E7%BD%97%E5%AF%86%E6%AC%A7; pcpopclub=026CD3527FE4A1C34F751E4E89FD43666470220A63CF8B43AABA2A4096700D7E28E4B548F8214A9B1400F353BDE537F513DAEA3D87FE880AD2964900821BF229C77CF2D9F0BFF217A336FA99808858516C092392D2300F9B5CC87044A61553D2CAE30BFD15B11EA414D6C9BA5F03006638B7469AF2F6F7243B4DC3008804B87763A70C4241119F99D463D00EB9471E6C23C55D9A412A6B2D90DDD34BFDBA1058E697226874F6BB5F02723C862F222EEFB4FF4CB850D389AB96B0A8BF1A9BD5399BF5DF347926D53D549D48252D28F9110DEB50E439355BF41B608D255E7D0404AB59A618604FFB46F01407308222CAC33262AB0F903CE3CD50C531E4E3AA166D8B0048981933E54603FD749F3B986EE091F97EE1E7568F92F4F31BFC22BABB05033812C97E3F092919A6BC2F; clubUserShow=55994487|3766|30|worken207|0|0|0||2017-08-18 11:09:29|0; autouserid=55994487; __utma=1.1641388042.1473574771.1502262129.1503025693.30; __utmb=1.0.10.1503025693; __utmc=1; __utmz=1.1503025693.30.25.utmcsr=autohome.com.cn|utmccn=(referral)|utmcmd=referral|utmcct=/hangzhou/; sessionuid=0DE7BB4C-83C7-4FFC-A0F4-07BB5B416488%7C%7C2016-09-11+14%3A19%3A30.053%7C%7C0; mylead_55994487=11; ASP.NET_SessionId=nxobtzgto2seetfavsej0k3y; ahpvno=8; CNZZDATA1262640694=48023668-1502156379-http%253A%252F%252Fwww.autohome.com.cn%252F%7C1503020955; sessionuserid=55994487; sessionlogin=9188291c34814ecdbd22641f408d6c5703566877; Hm_lvt_c5241958b568d64c9f23212513a22b7f=1503025806; Hm_lpvt_c5241958b568d64c9f23212513a22b7f=1503025806; ref=www.baidu.com%7C0%7C0%7C0%7C2017-08-18+11%3A10%3A06.078%7C2016-10-17+09%3A44%3A57.074; sessionvid=AD540731-3CD9-45A3-9499-30FDDF40B909; area=330199; ahrlid=1503025805680yJPCNFsuPX-1503025823441";


        Map<String,String> headMap = new HashMap<String,String>();
        headMap.put("Cookie", cookieStr);
        Map<String,String> paramMap = new HashMap<String,String>();



        try {
            //TODO 此处获取51job页面乱码,其他页面正常
            String result = HttpUtil.doProxyHttp("GET", url, paramMap, headMap, HttpURLConnection.HTTP_OK, "UTF8", "60.191.57.137", 16816);
            try {
                FileUtil.writeToFile("E:\\html_fetch","qichezhijia_"+cur_time_sign,result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
