package basetest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
public class FileDataFunTest {

    private static final String LOCAL_PATH = "E:/uploadFile/custdata/7/";


    private static final String LOCAL_PATH_DEAL = "E:/uploadFile/custdata_deal/1/";

    public static void main(String[] args){

        int count_total = 0;

        Collection<File> fileCollection = FileUtils.listFiles(new File(LOCAL_PATH), FileFilterUtils.suffixFileFilter("txt"), null);

        for(File file : fileCollection){


            String fileName = file.getName();

            String[] fileNameArr = StringUtils.split(fileName, "_");

            String deal_fileName = StringUtils.substring(fileNameArr[0], 4);

            //读取数据文件
            try {
                List<String> dataList = FileUtils.readLines(file);
                count_total+=dataList.size();

                FileUtils.writeLines(new File(LOCAL_PATH_DEAL + "/" + "custdata.txt"),dataList,true);

//                for(String data : dataList){
//                    if(StringUtils.isNotEmpty(data)){
//                        FileUtils.writeStringToFile(new File(LOCAL_PATH_DEAL + "/" + "custdata.txt"), data, "UTF-8",true);
//                    }
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("=======count_total="+count_total);


    }



}
