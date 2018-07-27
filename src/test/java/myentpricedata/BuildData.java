package myentpricedata;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapdb.Atomic;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/1/2.
 */
public class BuildData {

    public static void main(String args[]){

        //保存地区-code
        DB cacheDB = DBMaker.newFileDB(new File("E:/uploadFile/falsedata/localdb/source")).closeOnJvmShutdown().make();
        cacheDB.createHashMap("codeMap");
        Map<Integer,String> codeMap = cacheDB.get("codeMap");
        String outputFileDir = "E:/uploadFile/falsedata/result/";
        String zone_json_path = "E:\\idea_workspace\\activymq\\src\\test\\java\\myentpricedata\\city.js";
        Random random = new Random();
        String[] operateCompArr = new String[]{"中国移动","中国联通","中国电信"};
        String[] tagArr = new String[]{"sjb_xiaoedaikuan_1120xn.DEC-1","sjb_xinyongka_1120xn.DEC-1"};

//        String outputFileDir = "E:/uploadFile/falsedata/result/data.txt";
//        File outputfile = new File(outputFileDir);
//        if(!outputfile.exists()){
//            File parentFile = new File(outputfile.getParent());
//            parentFile.mkdirs();
//            try {
//                outputfile.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        //获取对应的解析json
        String json_str = null;
        JSONArray provinceJsonArr = null;
        try {
            json_str = FileUtils.readFileToString(new File(zone_json_path),"UTF-8");
            JSONObject cityJsonObj = JSON.parseObject(json_str);
            provinceJsonArr = JSON.parseArray(cityJsonObj.get("rows").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int cityArrLength = provinceJsonArr.size();

        long starttime = System.currentTimeMillis();
        for(int i=15;i<26;i++){
            List<String> dataList = new ArrayList<String>();
            File outputfile = new File(outputFileDir+"/data_"+i+".txt");
            try {
                outputfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int j=1;j<=500000;j++){
                //TODO 随机获取地区
                JSONObject prov = provinceJsonArr.getJSONObject(random.nextInt(cityArrLength));
                JSONArray cityJsonArr = prov.getJSONArray("items");
                JSONObject city = cityJsonArr.getJSONObject(random.nextInt(cityJsonArr.size()));
                String dataStr = (i*500000+j) + "," + tagArr[random.nextInt(2)] + ","+codeMap.get(i*500000+j)+"," + prov.get("text") + "," + city.get("text") + "," +operateCompArr[random.nextInt(3)];
                dataStr += ",NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL";
                dataList.add(dataStr);
            }
            try {
                FileUtils.writeLines(outputfile,dataList,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long exectime = starttime - System.currentTimeMillis();
        System.out.println("用时："+exectime);
    }


}
