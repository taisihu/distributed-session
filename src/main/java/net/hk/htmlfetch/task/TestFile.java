package net.hk.htmlfetch.task;

import net.hk.util.FileUtil;
import org.apache.commons.io.FileUtils;

/**
 * Created by Administrator on 2017/7/28.
 */
public class TestFile {

    public static void main(String[] args){

        try {
            FileUtil.writeToFile("E:\\html_fetch", "aaaa", "aaaaaaaaaa");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
