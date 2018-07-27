package myentpricedata;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/3.
 */
public class TestMapDB {

    public static void main(String[] args){

        DB cacheDB = DBMaker.newFileDB(new File("E:/uploadFile/falsedata/localdb/source")).make();
        cacheDB.createHashMap("codeMap");
        Map<Integer,String> codeMap = cacheDB.getHashMap("codeMap");

        codeMap.put(1,"a");
        codeMap.put(2,"b");

        cacheDB.commit();

        System.out.println(cacheDB.getHashMap("codeMap").get(1));

//        codeMap.remove(1);

//        System.out.println(cacheDB.getHashMap("codeMap").get(1));



    }

}
