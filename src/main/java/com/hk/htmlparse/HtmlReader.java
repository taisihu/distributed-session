package com.hk.htmlparse;

import common.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/17.
 */
public class HtmlReader {

    public static Document readHtml(String filePath){

        Document doc = null;
        File in = FileUtil.readFile(filePath);
        try {
            doc = Jsoup.parse(in, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;

    }

}
