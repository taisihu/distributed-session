package common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Administrator on 2018/7/15.
 */
public class MD5Util {

    private static final String CLIENT_SALT = "jc73ky8r";

    public static String md5(String code){
       return DigestUtils.md5Hex(code);
    }

    /**
     * 把客户端密码加入盐值进行加密处理
     * @param inputPass
     * @return
     */
    private static String convertClientPass(String inputPass){
        String clientPass = CLIENT_SALT.charAt(0)+CLIENT_SALT.charAt(7) + inputPass + CLIENT_SALT.charAt(2) + CLIENT_SALT.charAt(3);
        return md5(clientPass);
    }

    /**
     *
     * 把加密字符串再次使用数据库中的盐值进行加密处理
     *
     *
     */
    private static String convertDBPass(String clientPass,String dbSalt){
        String dbPass = clientPass.charAt(0)+clientPass.charAt(7) + clientPass + clientPass.charAt(2) + clientPass.charAt(3);
        return md5(dbPass);
    }


    /**
     * 暴露给外界的加密接口
     * @param inputPass
     * @param salt
     * @return
     */
    public static String clientPassToDbPass(String inputPass,String salt){
        String clientPass = convertClientPass(inputPass);
        String serverPass = convertDBPass(clientPass,salt);
        return serverPass;
    }

    public static void main(String[] args) {

        System.out.println(convertClientPass("1234"));

        System.out.println(convertDBPass(convertClientPass("1234"),"h7dk8m3s"));//该盐值从数据库中读取

        System.out.println(clientPassToDbPass("1234","h7dk8m3s"));

    }

}
