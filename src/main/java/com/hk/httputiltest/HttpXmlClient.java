/**
 * 
 */
package com.hk.httputiltest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


/**
 * 请求url工具 @ author huhuafeng @ 时间：2016年10月17日 @ 方法描述：
 */
public class HttpXmlClient {

	public static String post(String url, Map<String, String> params, Map<String, String> headers) {
		CloseableHttpClient httpclient = HttpClients.createSystem();

		String body = null;

		HttpPost post = postForm(url, params);
		for (String temp : headers.keySet()) {
			post.setHeader(temp, headers.get(temp));
		}
		body = invoke(httpclient, post);

		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

	public static String get(String url, Map<String, String> params, Map<String, String> headers) {

		StringBuilder bs = new StringBuilder("?");

		for (String str : params.keySet()) {
			bs.append(str + "=" + params.get(str) + "&");
		}

		bs.deleteCharAt(bs.length() - 1);

		url = url + bs.toString();
		CloseableHttpClient httpclient = HttpClients.createSystem();
		String body = null;

		HttpGet get = new HttpGet(url);
		for (String temp : headers.keySet()) {
			get.setHeader(temp, headers.get(temp));
		}
		body = invoke(httpclient, get);

		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

	public static String post(String url, Map<String, String> params, CookieStore cookieStore, String heastr) {
		CloseableHttpClient httpclient = HttpClients.createSystem();
		// CloseableHttpClient httpclient =
		// HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		String body = null;

		HttpPost post = postForm(url, params);
		// System.out.println(cookieStore.toString());
		// post.setHeader("Host","ehire.51job.com");
		// post.setHeader("Referer","http://ehire.51job.com/Candidate/SearchResumeNew.aspx");
		post.setHeader("Cookie", heastr);
		post.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		// Header[] ttt = post.getAllHeaders();
		//
		// for(int i = 0; i< ttt.length ; i++){
		// System.out.println(ttt[i]);
		// }

		body = invoke(httpclient, post);

		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

	public static String get(String url, Map<String, String> params, String cookieStr) {

		StringBuilder bs = new StringBuilder("?");

		for (String str : params.keySet()) {
			bs.append(str + "=" + params.get(str) + "&");
		}

		bs.deleteCharAt(bs.length() - 1);

		url = url + bs.toString();
		CloseableHttpClient httpclient = HttpClients.createSystem();
		String body = null;

		HttpGet get = new HttpGet(url);
		// get.setHeader("Host","ehire.51job.com");
		// get.setHeader("Set-Cookie","LangType=Lang=&Flag=1; expires=Thu,
		// 27-Jul-2017 06:30:53 GMT; path=/; HttpOnly");
		// get.setHeader("Referer","http://ehire.51job.com/Candidate/ResumeViewFolder.aspx?hidSeqID=9454593530&hidFolder=EMP");
		get.setHeader("Cookie", cookieStr);
		get.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");

		body = invoke(httpclient, get);

		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

	public static String get(String url, int type) {
		CloseableHttpClient httpclient = HttpClients.createSystem();
		String body = null;
		RequestConfig config = null;
		if (type == 1) {
			// HttpHost proxy = new HttpHost("122.96.59.107", 80, "http");
			HttpHost proxy = new HttpHost("122.96.59.107", 80, "http");
			config = RequestConfig.custom().setProxy(proxy).build();
		}

		HttpGet get = new HttpGet(url);
		if (type == 1) {
			get.setConfig(config);
		}
		body = invoke(httpclient, get);

		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

	public static String get(String url) {
		CloseableHttpClient httpclient = HttpClients.createSystem();
		String body = null;

		HttpHost proxy = new HttpHost("192.168.0.2", 8080, "http");
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

		HttpGet get = new HttpGet(url);
		get.setConfig(config);

		body = invoke(httpclient, get);

		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

	private static String invoke(CloseableHttpClient httpclient, HttpUriRequest httpost) {

		HttpResponse response = sendRequest(httpclient, httpost);

		// Header[] ttt = response.getAllHeaders();
		// for(int i = 0 ; i< ttt.length ; i++){
		// System.out.println(ttt[i]);
		// }
		// System.out.println(response.getHeaders("Cookie").toString());
		// org.apache.http.Header[] Cookies=response.getHeaders("Cookie");
		// StringBuffer stringCookie = new StringBuffer();
		// for (int j = 0; j < Cookies.length; j++) {
		// stringCookie.append(Cookies[j].getValue()).append(";");
		// }
		// System.out.println(stringCookie);

		String body = paseResponse(response);

		return body;
	}

	private static String paseResponse(HttpResponse response) {
		HttpEntity entity = response.getEntity();

		String charset = EntityUtils.getContentCharSet(entity);

		String body = null;
		try {
			body = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}

	private static HttpResponse sendRequest(CloseableHttpClient httpclient, HttpUriRequest httpost) {
		HttpResponse response = null;

		try {
			// Header[] oo = httpost.getAllHeaders();
			// for(int i =0;i<oo.length ;i++){
			// System.out.println(oo[i]);
			// }

			response = httpclient.execute(httpost);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private static HttpPost postForm(String url, Map<String, String> params) {

		HttpPost httpost = new HttpPost(url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpost;
	}

	public static void test() {
		Map<String, String> inputs = new HashMap<String, String>();

		Map<String, String> params = new HashMap<String, String>();
		// String url = "https://www.hdfax.com/financialproduct/list/info";

		String url = "https://www.koudailc.com/list/list-data";

		params.put("channelId", "4");
		params.put("page", "2");
		params.put("pageSize", "6");
		params.put("status", "0");
		params.put("period", "0");
		params.put("apr", "0");

		// 保存 type 访问方式创建
		String type = "1";

		// 保存 url 参数创建
		// Map<String, String> params = new HashMap<String, String>();
		// String url =
		// "http://iweb.hanxinbank.com/borrowInfo/queryBorrowinfoPage.do";
		// params.put("pageSize", "1");
		// params.put("borrowType", "1001");
		// params.put("borrowLevel", "100");
		// params.put("currentPage", "5");

		// String json = HttpXmlClient.get(url);
		// System.out.println(json);

		// String json = HttpXmlClient.post(url, params);
		// System.out.println(json);
		// JSONObject jsonObject = JSONObject.parseObject(json);
		//
		// // 保存 result
		// JSONObject jsonObject1 = jsonObject.getJSONObject("result");
		//
		// // 保存 items
		// JSONArray jsonArray = jsonObject1.getJSONArray("items");

		// 保存 初始化 要有的 json中的key
		// for (int i = 0; i < jsonArray.size(); i++) {
		// JSONObject temp = jsonArray.getJSONObject(i);
		// System.out.println("item" + i + ":" + temp);
		// }

	}

	public static void main(String[] args) {

		Map<String, String> inputs = new HashMap<String, String>();

		Map<String, String> params = new HashMap<String, String>();
		// String url = "https://www.hdfax.com/financialproduct/list/info";

		// String url = "https://www.koudailc.com/list/list-data";
		String url = "https://user.lu.com/user/login";
		params.put("userName", "klark_hu");
		params.put("pwd", "hu123456");
		params.put("password", "hu123456");
		params.put("validNum", "1234");
		params.put("loginFlag", "1");
		params.put("loginagree", "on");
		params.put("isTrust", "1");

		// params.put("channelId", "4");
		// params.put("page", "2");
		// params.put("pageSize", "6");
		// params.put("status", "0");
		// params.put("period", "0");
		// params.put("apr", "0");

		// 保存 type 访问方式创建
		String type = "1";

		// 保存 url 参数创建
		// Map<String, String> params = new HashMap<String, String>();
		// String url =
		// "http://iweb.hanxinbank.com/borrowInfo/queryBorrowinfoPage.do";
		// params.put("pageSize", "1");
		// params.put("borrowType", "1001");
		// params.put("borrowLevel", "100");
		// params.put("currentPage", "5");

		// String json = HttpXmlClient.get(url);
		// System.out.println(json);

		// String json = HttpXmlClient.post(url, params);
		// System.out.println(json);
		// JSONObject jsonObject = JSONObject.parseObject(json);
		//
		// // 保存 result
		// JSONObject jsonObject1 = jsonObject.getJSONObject("result");
		//
		// // 保存 items
		// JSONArray jsonArray = jsonObject1.getJSONArray("items");

		// 保存 初始化 要有的 json中的key
		// for (int i = 0; i < jsonArray.size(); i++) {
		// JSONObject temp = jsonArray.getJSONObject(i);
		// System.out.println("item" + i + ":" + temp);
		// }

	}
}
