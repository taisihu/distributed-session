package common;

import java.util.UUID;

/**
 * Created by Administrator on 2018/7/16.
 */
public class UUIDUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
