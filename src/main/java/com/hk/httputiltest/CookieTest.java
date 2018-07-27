/**
 * 
 */
package com.hk.httputiltest;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;
//import com.gargoylesoftware.htmlunit.CookieManager;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import com.gargoylesoftware.htmlunit.util.Cookie;

//import iptest.HttpXmlClient;
//import test.ThreadLocalClientFactory;

/**
 * @ author huhuafeng @ 时间：2016年9月9日 @ 方法描述：
 */
public class CookieTest {
	private static Set<String> tempset = new HashSet<String>();
	private static List<String> templist = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		
//		String url = "https://list.lu.com/list/huoqi";
//		WebClient webClient =ThreadLocalClientFactory.getInstance().getClient();
//		webClient.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//		// 模拟浏览器打开一个目标网址
//		HtmlPage rootPage = null;
//		try {
//			rootPage = webClient.getPage(url);
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		String htmlContent = rootPage.asXml();
//
//		Document doc = Jsoup.parse(htmlContent);
//		System.out.println(doc.html().toString());
		
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> headers = new HashMap<String, String>();
//		String tmpurl= "https://e.lufunds.com/jijin/list";
//		String tmpurl = "http://ehire.51job.com/InboxResume/InboxRecentEngine.aspx?Style=1";
		String tmpurl = "http://ehire.51job.com/Candidate/ResumeViewFolder.aspx?hidSeqID=9436252835&hidFolder=EMP";
//		String tmpurl = "http://ehire.51job.com/Ajax/Common/GlobalActionLogAjax.ashx?logType=event&pageNo=3&memo=&eventNo=8&Key=ca3841557ff6d90172a7ee36ea68e4fc&rnd=0.8488470893751237";
//		String tmpurl = "http://ehire.51job.com/Candidate/ResumeViewFolder.aspx?hidSeqID=9454593530&hidFolder=EMP";
//		params.put("UserID", "200908554");
//		params.put("password", "hu123456");
		String cookieStr = "guid=14983068958901500070; EhireGuid=c0d75d5651c14f708b3126e6902ec3f8; 51job=cenglish%3D0; HRUSERINFO=CtmID=1774804&DBID=2&MType=02&HRUID=2102278&UserAUTHORITY=1100111011&IsCtmLevle=1&UserName=hkdw298&IsStandard=0&LoginTime=06%2f27%2f2017+14%3a26%3a39&ExpireTime=06%2f27%2f2017+14%3a36%3a39&CtmAuthen=0000011000000001000110010000000011100001&BIsAgreed=true&IsResetPwd=0&CtmLiscense=1&AccessKey=e3210a818b3e5238; AccessKey=43d7b1dfd3ea450; ASP.NET_SessionId=chexjdjgauydpdqgtb0yhqn3; KWD=EMP=; LangType=Lang=&Flag=1";
		headers.put("Cookie", cookieStr);
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		String json = HttpXmlClient.post(tmpurl, params,headers);
//		String json = HttpXmlClient.post(tmpurl, params,null,cookieStr);
//		String json = HttpXmlClient.get(tmpurl, params,cookieStr);
//		String json = HttpXmlClient.get(tmpurl, params,cookieStr);
//		System.out.println(json);
		Document doc = Jsoup.parse(json);
		
//		print(json,"d://ip2.html");
		System.out.println(doc.select("#divInfo table:has(.plate1) :matches(工作经验) tr .p15").get(0).select("tr .plate_right"));
		
//		System.out.println(doc.select(".validateImg img"));
		
//		downloadPicture("");
//		System.out.println(doc.html().toString());
//		print(doc.html().toString());
	}

	public static void print(String line,String filename) {
		try {
			Runtime r = Runtime.getRuntime();
			// Process p = r.exec("ipconfig /all");
			FileWriter fw = new FileWriter(new File(filename),false);

			fw.write(line);
			fw.write("\n");

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private static String downloadPicture(String urlString) {  
		 
//		 	urlString = "https://user.lu.com/user/captcha/captcha.jpg?source=login&_=1478574688813";
	        URL url = null;  
	        int imageNumber = 0;  
	          
	     
	            try {  
	                url = new URL(urlString);  
	                DataInputStream dataInputStream = new DataInputStream(url.openStream());  
	                String imageName = "d:/" + imageNumber + ".jpg";  
	                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));  
	  
	                byte[] buffer = new byte[1024];  
	                int length;  
	  
	                while ((length = dataInputStream.read(buffer)) > 0) {  
	                    fileOutputStream.write(buffer, 0, length);  
	                }  
	  
	                dataInputStream.close();  
	                fileOutputStream.close();
	                imageNumber++;  
	                return imageName;
	               
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	            
	            return null;
	         
	    }  
}
