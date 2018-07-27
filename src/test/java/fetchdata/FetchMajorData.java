package fetchdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hk.httputiltest.HttpException;
import com.hk.httputiltest.HttpUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2018/1/15.
 */
public class FetchMajorData {

    public static void main(String[] args){


        String url = "https://gaokao.dashu360.com/major/MajorInfo";

        Map<String,String> paramMap = new HashMap<String,String>();
        Map<String,String> headMap = new HashMap<String,String>();

//        paramMap.put("majorid","070301");
        paramMap.put("user_id","132290");
//        paramMap.put("syear","2016");
//        paramMap.put("page","3");
        paramMap.put("majorid","010101");

        headMap.put("cookie","PHPSESSID=db2mdp24t7qpnh8psaeugvcpe4");

        try {
            String result = HttpUtil.doHTTP("POST", url, paramMap, headMap, 200, "UTF-8");
            JSONObject dataJson = JSON.parseObject(result);
            System.out.println(result);
        } catch (HttpException e) {
            e.printStackTrace();
        }

    }

}
