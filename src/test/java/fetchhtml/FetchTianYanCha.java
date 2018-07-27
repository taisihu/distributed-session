package fetchhtml;

import com.hk.httputiltest.HttpException;
import com.hk.httputiltest.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12.
 */
public class FetchTianYanCha {

        public static void main(String[] args){

            Map<String,String> paramMap = new HashMap<String,String>();
            Map<String,String> headMap = new HashMap<String,String>();

//            paramMap.put("key","顺网科技");
//            paramMap.put("checkFrom","searchBox");

            headMap.put("Cookie","TYCID=f1cb7fb0ce5f11e7aac36fb7a44ec93e; undefined=f1cb7fb0ce5f11e7aac36fb7a44ec93e; ssuid=4268914717; aliyungf_tc=AQAAAOgUFDQAlwIAsifsc1kXXqN2djVx; csrfToken=OnDLE7EFsQeK1jeBJSLPGRPa; tyc-user-info=%257B%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODg2ODczMjQ3NiIsImlhdCI6MTUxMTQyNTI0NCwiZXhwIjoxNTI2OTc3MjQ0fQ.2uTPc-rebbA-01TwGXGPoio5WHmMQ8vwfamSnEY3TCSGN7ah2yIZP8QLwGHikFSBPbtnD3e3VimZpAFzIZS0lQ%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522state%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252218868732476%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODg2ODczMjQ3NiIsImlhdCI6MTUxMTQyNTI0NCwiZXhwIjoxNTI2OTc3MjQ0fQ.2uTPc-rebbA-01TwGXGPoio5WHmMQ8vwfamSnEY3TCSGN7ah2yIZP8QLwGHikFSBPbtnD3e3VimZpAFzIZS0lQ; _csrf=fDB/kxp1F2jXtedw5FSc2A==; OA=El1orI1+d+NsJDuXYuw7Crz/v0E08ok8sdhFNNt5sXY572i6onnDL72JrwyzHOPd; _csrf_bk=548318ce68dc932f2cc72c328119d8d8; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1511229716,1511425206; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1511492110; token=f341ff58953e4d3c8c68fcd3a4a71ea8; _utm=9d98c303dc78407792d886c1b19cd8a8; RTYCID=9414d53d47de445cbfafa6bd522cabba");
            headMap.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
//

            String url = "https://www.tianyancha.com/company/46928783";

            try {
                String page_htmle = HttpUtil.doHTTP("GET", url, paramMap, headMap);



//                System.out.println(page_htmle);

                Document doc = Jsoup.parse(page_htmle);

//                Elements subEles = doc.select(".company_header_width>span:contains(地址)");

//                Elements subEles = doc.select(".company_header_width span:contains(地址)");
//                String result = subEles.next().html();

                //doc.select(".company_header_width .in-block.overflow-width.vertical-top.pr10").text()

                Elements subEles1 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(0)>td:eq(1)");
                Elements subEles2 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(0)>td:eq(3)");
                Elements subEles3 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(1)>td:eq(1)");
                Elements subEles4 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(1)>td:eq(3)");
                Elements subEles5 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(2)>td:eq(1)");
                Elements subEles6 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(2)>td:eq(3)");
                Elements subEles7 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(3)>td:eq(1)");
                Elements subEles8 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(3)>td:eq(3)");
                Elements subEles9 = doc.select("ase0910>.table.companyInfo-table.f14>tbody>tr:eq(4)>td:eq(1)");
                Elements subEles10 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(4)>td:eq(3)");
                Elements subEles11 = doc.select(".base0910>.table.companyInfo-table.f14>tbody>tr:eq(6)");



//                String result = subEles.text();



                System.out.println(subEles1.text());
                System.out.println(subEles2.text());
                System.out.println(subEles3.text());
                System.out.println(subEles4.text());
                System.out.println(subEles5.text());
                System.out.println(subEles6.text());
                System.out.println(subEles7.text());
                System.out.println(subEles8.text());
                System.out.println(subEles9.text());
                System.out.println(subEles10.text());
                System.out.println(subEles11.text());



            } catch (HttpException e) {
                e.printStackTrace();
            }

        }

}
