package fetchhtml;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/10/17.
 */
public class HtmlunitFetch {

    public static void main(String[] args){

        String strUrl = "https://www.tianyancha.com/company/2338379220";
        String cookieStr = "TYCID=f217da30ad5e11e78aa941520939e1af; uccid=2a9bdeab271e41ad3ada9006bb7467f5; ssuid=9914057906; aliyungf_tc=AQAAAGXVuWDzQggA4izucwUKbmVa9L91; csrfToken=n62cbV--UEmT1plKT1EWZZLn; tyc-user-info=%257B%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODg2ODczMjQ3NiIsImlhdCI6MTUwODIyNjcwMiwiZXhwIjoxNTIzNzc4NzAyfQ.KmmOGR01cwvttzrBbBDfXIURBivR_olaB1l4r7oynUILVBq_CxHt_KZgYNM3Sz8m7egBJA759E7aY69KdCtTVg%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522state%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252218868732476%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODg2ODczMjQ3NiIsImlhdCI6MTUwODIyNjcwMiwiZXhwIjoxNTIzNzc4NzAyfQ.KmmOGR01cwvttzrBbBDfXIURBivR_olaB1l4r7oynUILVBq_CxHt_KZgYNM3Sz8m7egBJA759E7aY69KdCtTVg; OA=ufhGJ06vqaTZJBXoz0uI2r+HWcnLoyAd4/6uvh+ZK7YaC8WZYc/VL57RxWKdj4V4; _csrf=4eV2raJYe6SZ6Z+Q4IMfAw==; _csrf_bk=175e486128e29546e8dfdecf94b740b7; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1508122904,1508205179,1508218248,1508226412; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1508244695; token=7ab3e6b051864f88993fdec894dec1d0; _utm=6106d4c9de434a67aff2fce26c9d71bb";

        String refer="https://www.tianyancha.com/company/2338379220";
        URL link= null;
        try {
            link = new URL(strUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebClient wc=new WebClient(BrowserVersion.CHROME);
        WebRequest request=new WebRequest(link);
//        request.setCharset("UTF-8");
//        request.setProxyHost("120.120.120.x");
//        request.setProxyPort(8080);
//        request.setAdditionalHeader("Referer", refer);//设置请求报文头里的refer字段
        ////设置请求报文头里的User-Agent字段
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
        //wc.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        //wc.addRequestHeader和request.setAdditionalHeader功能应该是一样的。选择一个即可。
        //其他报文头字段可以根据需要添加
        wc.getCookieManager().setCookiesEnabled(true);//开启cookie管理
        wc.getOptions().setJavaScriptEnabled(true);//开启js解析。对于变态网页，这个是必须的
        wc.getOptions().setCssEnabled(true);//开启css解析。对于变态网页，这个是必须的。
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setThrowExceptionOnScriptError(false);
        wc.getOptions().setTimeout(10000);
        wc.getOptions().setThrowExceptionOnScriptError(false);

        CookieManager cookieManager = wc.getCookieManager();
        cookieManager.setCookiesEnabled(true);
        Cookie cookie = new Cookie(strUrl,"cookie",cookieStr);
        cookieManager.addCookie(cookie);
        wc.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
        wc.setCookieManager(cookieManager);


        HtmlPage page=null;
        try {
            page = wc.getPage(request);
            System.out.println(page.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
