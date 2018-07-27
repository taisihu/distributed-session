package myentpricedata;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/1/3.
 */
public class LoadCode {

    public static void main(String[] args){

        String inputFileDir = "E:\\uploadFile\\falsedata\\md5_code_resource\\md5_code_all\\";
        DB cacheDB = DBMaker.newFileDB(new File("E:/uploadFile/falsedata/localdb/source")).closeOnJvmShutdown().make();
        cacheDB.createHashMap("codeMap");
        Map<Integer,String> codeMap = cacheDB.get("codeMap");
        int codeMapSize = codeMap.size();
        System.out.println("当前codeMapSize:"+codeMapSize+" - "+System.currentTimeMillis());
        //key
        AtomicInteger sequence = new AtomicInteger(codeMapSize+1);

        Collection<File> fileList = (List<File>) FileUtils.listFiles(new File(inputFileDir), FileFilterUtils.suffixFileFilter("txt"), null);
        for(File file : fileList){
            //读取数据文件
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"));//10M缓存
                while (in.ready()) {
                    String line = in.readLine();
                    int dotIndex = line.indexOf("\"");
                    String code = StringUtils.substring(line, 0, dotIndex);
//                    String[] columnArr = StringUtils.split(line, ",");
//                    String id = columnArr[0];
//                    String tag = columnArr[1];
//                    String userCode = columnArr[2];
//                    String prov = columnArr[3];
//                    String city = columnArr[4];
//                    String operateComp = columnArr[5];
//                    String dateStr = columnArr[23];

//                    String key = prov+city;
//                    User user = new User();
//                    user.setId(id);
//                    user.setTag(tag);
//                    user.setUseCcode(userCode);
//                    user.setProv(prov);
//                    user.setCity(city);
//                    user.setOperateComp(operateComp);
//                    user.setDateStr(dateStr);

//                    List<User> userList = userMap.get(key);
//                    if(CollectionUtils.isEmpty(userList)){
//                        userList = new ArrayList<User>();
//                        userList.add(user);
//                        userMap.put(key,userList);
//                    }else{
//                        userList.add(user);
//                    }
                    codeMap.put(sequence.getAndAdd(1),code.trim());
                    if(sequence.get()%10000==0){
                        cacheDB.commit();
                    }
                }
                in.close();
                cacheDB.commit();
                System.out.println("当前codeMapSize:"+codeMap.size()+" - "+System.currentTimeMillis());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
