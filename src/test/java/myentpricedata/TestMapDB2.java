package myentpricedata;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/3.
 */
public class TestMapDB2 {

    public static void main(String[] args){

        DB cacheDB = DBMaker.newFileDB(new File("E:/uploadFile/falsedata/localdb/source")).closeOnJvmShutdown().make();
        Map<Integer,String> codeMap = cacheDB.getHashMap("codeMap");

        System.out.println(cacheDB.getHashMap("codeMap").get(2));

        codeMap.remove(2);

        System.out.println(cacheDB.getHashMap("codeMap").get(2));


    }

}
