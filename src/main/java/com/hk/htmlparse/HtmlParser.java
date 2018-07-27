package com.hk.htmlparse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Administrator on 2017/8/17.
 */
public class HtmlParser {

    public static void main(String[] args){

        HtmlParser htmlParser = new HtmlParser();
        htmlParser.parseHtml();

    }


    public void parseHtml(){

        Document doc = HtmlReader.readHtml("E:\\uploadFile\\51jobhtml\\13886_53186_1_20170711205512066.html");

        //id
        String eid = doc.select(".name").text();

        //工作机会
        String echance = doc.select(".infr tr:eq(1) td:eq(0)").text();

        //电话
        String ephone = doc.select(".infr tr:eq(1) td:eq(1)").text();

        //邮箱
        String eemail = doc.select(".infr tr:eq(1) td:eq(2)").text();

        //个人信息
        String eaddress = doc.select(".infr tr:eq(2) td:eq(0)").text();

        //家庭电话
        String ecellphone = doc.select("#divInfo table:eq(0) tr:eq(1) tr:eq(0) td:eq(0) tr td:eq(1)").text();

        //户口/国籍
        String huji = doc.select("#divInfo table:eq(0) tr:eq(1) tr:eq(0) td:eq(1) tr td:eq(1)").text();

        //家庭地址
        String homeaddress = doc.select("#divInfo table:eq(0) tr:eq(1) tr:eq(2) td table tr td:eq(1) ").text();

        //工作年限
        String erecentwork = doc.select(".box2 .tb2:eq(0) tbody tr:eq(0) td:eq(0)").text();

        //职位
        String ezhiwei= doc.select(".box2 .tb2:eq(0) tbody tr:eq(1) td:eq(1)").text();

        //公司
        String ecompany= doc.select(".box2 .tb2:eq(0) tbody tr:eq(2) td:eq(1)").text();

        //公司
        String ehangye= doc.select(".box2 .tb2:eq(0) tbody tr:eq(3) td:eq(1)").text();

        //专业
        String ezhuanye= doc.select(".box2 .tb2:eq(1) tbody tr:eq(1) td:eq(1)").text();

        //学校
        String eschool= doc.select(".box2 .tb2:eq(1) tbody tr:eq(2) td:eq(1)").text();

        //学历
        String eeducate= doc.select(".box2 .tb2:eq(1) tbody tr:eq(3) td:eq(1)").text();

        //学历
        String ereword= doc.select("#divInfo .plate1").text();

        //期望薪资
        String qiwangxinzi= doc.select("#divInfo table:eq(2) table:eq(0) tr:eq(0) td:eq(0) table:eq(0) td:eq(1)").text();

        //期望工作地点
        String workplace= doc.select("#divInfo table:eq(2) table:eq(0) tr:eq(0) td:eq(1) table:eq(0) td:eq(1)").text();

        //职能
        String zhineng= doc.select("#divInfo table:eq(2) table:eq(0) tr:eq(1) td:eq(0) table:eq(0) td:eq(1)").text();

        //到岗时间
        String daogangshijian= doc.select("#divInfo table:eq(2) table:eq(0) tr:eq(2) td:eq(0) table:eq(0) td:eq(1)").text();

        //工作类型
        String worktype= doc.select("#divInfo table:eq(2) table:eq(0) tr:eq(2) td:eq(1) table:eq(0) td:eq(1)").text();

        //自我评价
        String ziwopingjia= doc.select("#divInfo table:eq(2) table:eq(0) tr:eq(3) td:eq(0) table:eq(0) td:eq(1)").text();

        //========工作经验 1 begin 修改第四个配置 tr:eq(?)========
        //工作时间
        String workeexprience_1 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(0) tr:eq(0) .time").text();

        //工作公司
        String workeexprience_gongsi_1 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(0) tr:eq(0) .plate_right").text();

        //工作部门
        String workeexprience_bumen_1 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(0) tr:eq(2) .time").text();

        //工作部门_头衔
        String workeexprience_bumen_title_1 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(0) tr:eq(2) .rtbox").text();

        //工作描述
        String workeexprience_miaoshu_1 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(0) tr:eq(3) .txt1").text();
        //========工作经验 1 end========

        //========工作经验 2 begin========
        //工作时间
        String workeexprience_2 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(1) tr:eq(0) .time").text();

        //工作公司
        String workeexprience_gongsi_2 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(1) tr:eq(0) .plate_right").text();

        //工作部门
        String workeexprience_bumen_2 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(1) tr:eq(2) .time").text();

        //工作部门_头衔
        String workeexprience_bumen_title_2 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(1) tr:eq(2) .rtbox").text();

        //工作描述
        String workeexprience_miaoshu_2 = doc.select("#divInfo table:eq(3) tr:eq(1) tr:eq(1) tr:eq(3) .txt1").text();
        //========工作经验 2 end========

        //=============教育经历 1 begin===========
        //时间
        String educate_time_1 = doc.select("#divInfo table:eq(4) tr:eq(1) .time").text();

        //大学
        String educate_school = doc.select("#divInfo table:eq(4) tr:eq(1) .rtbox").text();

        //degree
        String educate_degree = doc.select("#divInfo table:eq(4) tr:eq(1) .phd").text();
        //=============教育经历 1 end===========

        System.out.println(eid);

    }



}
