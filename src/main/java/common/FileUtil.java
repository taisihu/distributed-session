package common;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Created by Administrator on 2017/8/21.
 */
public class FileUtil {

    public static String readFileContent(String filePath){

        String class_str = null;

        try {
            class_str = FileUtils.readFileToString(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return class_str;
    }

    /**
     * 写入文件
     * @param filePath
     * @param local_path_filename
     * @param strContent
     */
    public static void writeToFile(String filePath, String local_path_filename, String strContent) throws Exception{
        BufferedWriter bufferWritter = null;
        try {
            File file = new File(filePath);
            // 创建目录
            if (!file.exists()) {
                file.mkdirs();     //如果不存在，创建目录
            }
            bufferWritter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath+File.separator+local_path_filename), "utf-8"));

            bufferWritter.write(strContent);
            bufferWritter.flush();

            bufferWritter.close();

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e);
        }finally{
            try{
                if(bufferWritter != null){
                    bufferWritter.close();
                }
            }catch(Exception e){}
        }
    }

    public static void appendFile(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File readFile(String filePath){

        File file = new File(filePath);
        return file;

    }

}
