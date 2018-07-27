package com.hk.httputiltest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtil {

    private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    public static final String DEFAULT_ENCODE = "UTF-8";

    /**
     * GET
     *
     * @param url
     * @return
     * @throws HttpException
     * @author  
     */
    public static String doHTTP(String url) throws HttpException {
        return doHTTP(url, null);
    }

    /**
     * GET
     *
     * @param url
     * @param paramMap
     * @return
     * @throws HttpException
     * @author  
     */
    public static String doHTTP(String url, Map<String, ?> paramMap) throws HttpException {
        return doHTTP(GET_METHOD, url, paramMap);
    }

    /**
     * HTTP请求，默认状态码要求为200
     *
     * @param method
     * @param url
     * @param paramMap
     * @return
     * @author  
     */
    public static String doHTTP(String method, String url, Map<String, ?> paramMap) throws HttpException {
        return doHTTP(method, url, paramMap, HttpURLConnection.HTTP_OK, DEFAULT_ENCODE);
    }

    /**
     * 指定统一编码
     *
     * @param method
     * @param url
     * @param paramMap
     * @param encode
     * @return
     * @throws HttpException
     */
    public static String doHTTP(String method, String url, Map<String, ?> paramMap, String encode) throws HttpException {
        return doHTTP(method, url, paramMap, HttpURLConnection.HTTP_OK, encode);
    }

    /**
     * @param method   请求类型
     * @param url      请求地址
     * @param paramMap 请求参数
     * @param status   响应的状态码
     * @param encode   输入流的编码，默认为UTF-8
     * @return
     * @author  
     */
    public static String doHTTP(String method, String url, Map<String, ?> paramMap, int status, String encode) throws HttpException {
        return doHTTP(method, url, paramMap, null, status, encode);
    }

    /**
     * @param method
     * @param url
     * @param paramMap
     * @param headMap
     * @return
     * @throws HttpException
     * @author  
     */
    public static String doHTTP(String method, String url, Map<String, ?> paramMap, Map<String, String> headMap) throws HttpException {
        return doHTTP(method, url, paramMap, headMap, HttpURLConnection.HTTP_OK, DEFAULT_ENCODE);
    }

    /**
     * @param method   请求类型
     * @param url      请求地址
     * @param paramMap 请求参数
     * @param headMap  请求头
     * @param status   响应的状态码
     * @param encode   输入流的编码，默认为UTF-8
     * @return
     * @throws HttpException
     * @author  
     */
    public static String getCookie(String method, String url, Map<String, ?> paramMap, Map<String, String> headMap, int status, String encode,String cookieStr) throws HttpException {
        HttpURLConnection conn = null;
        try {
            String params = "";
            if (GET_METHOD.equals(method)) {
                params = getParams(paramMap, encode);
                String splitStr = "";
                if (StringUtils.isNotBlank(params)){
                	splitStr = url.contains("?") ? "&" : "?";
                }
                conn = (HttpURLConnection) new URL(url + splitStr + params).openConnection();
                conn.setRequestProperty("Content-type", "text/html;charset=" + encode);
                conn.setRequestMethod(method);
            } else {
            	URL postUrl = new URL(url);
                conn = (HttpURLConnection)postUrl.openConnection();
                conn.setRequestMethod(method);
                conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
                conn.setUseCaches(false);
            }
            if(StringUtils.isNotEmpty(cookieStr)){
            	conn.setRequestProperty("Cookie", cookieStr);
            }
            if (headMap != null && !headMap.isEmpty()) {
                for (Entry<String, String> e : headMap.entrySet()) {
                    conn.setRequestProperty(e.getKey(), e.getValue());
                }
            }
            
            conn.setRequestMethod(method);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(8000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            
            if (POST_METHOD.equals(method)) {
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), encode);
                params = getParams(paramMap, encode);
                out.write(params);
                out.flush();
                out.close();
            }
            
            String sessionId = "";  
            String cookieVal = "";  
            String key = null;  
            //取cookie  
            for(int i = 1; (key = conn.getHeaderFieldKey(i)) != null; i++){  
                if(key.equalsIgnoreCase("set-cookie")){  
                    cookieVal = conn.getHeaderField(i);  
                    cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));  
                    sessionId = sessionId + cookieVal + ";";  
                }  
            }  
            
            logger.info("请求接口{},请求参数{},返回状态{},返回结果{}", url, params, conn.getResponseCode(), sessionId);
            
            return sessionId;
            
        } catch (Exception e) {
            throw new HttpException(e);
        } finally {
        	logger.info("请求接口{}", url);
            if (conn != null) {
                conn.disconnect();
            }
            	
        }
    }
    
    public static String doHTTP(String method, String url, Map<String, ?> paramMap, Map<String, String> headMap, int status, String encode) throws HttpException {
        HttpURLConnection conn = null;
        try {
            String params = "";
            if (GET_METHOD.equals(method)) {
                params = getParams(paramMap, encode);
                String split = "";
                if (StringUtils.isNotBlank(params)){
                    split = url.contains("?") ? "&" : "?";
                }
                conn = (HttpURLConnection) new URL(url + split + params).openConnection();
                conn.setRequestProperty("Content-type", "text/html;charset=" + encode);
            } else {
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            }
            if (headMap != null && !headMap.isEmpty()) {
                for (Entry<String, String> e : headMap.entrySet()) {
                    conn.setRequestProperty(e.getKey(), e.getValue());
                }
            }

            conn.setRequestMethod(method);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(8000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            if (POST_METHOD.equals(method)) {
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), encode);
                params = getParams(paramMap, encode);
                out.write(params);
                out.flush();
                out.close();
            }

            StringBuilder resBuilder = null;
            try {
                if (conn.getResponseCode() == status) {
                    // 取得输入流，并使用Reader读取
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), encode));
                    String lines;
                    resBuilder = new StringBuilder();
                    while ((lines = reader.readLine()) != null) {
                        resBuilder.append(lines);
                    }
                    reader.close();
                    return resBuilder.toString();
                }
            } finally {
                logger.info("请求接口{},请求参数{},返回状态{},返回结果{}", url, params, conn.getResponseCode(), resBuilder);
            }
        } catch (Exception e) {
            throw new HttpException(e);
        } finally {
        	logger.info("请求接口{}", url);
            if (conn != null) {
                conn.disconnect();
            }
            	
            
        }
        return null;
    }
    
    public static HttpURLConnection getConnect(String url) throws HttpException{
    	return getConnect("GET", url, null, null, HttpURLConnection.HTTP_OK, DEFAULT_ENCODE);
    }
    
    public static HttpURLConnection getConnect(String method, String url, Map<String, ?> paramMap, Map<String, String> headMap, int status, String encode) throws HttpException {
        HttpURLConnection conn = null;
        try {
            String params = "";
            if (GET_METHOD.equals(method)) {
                params = getParams(paramMap, encode);
                String split = "";
                if (StringUtils.isNotBlank(params)){
                    split = url.contains("?") ? "&" : "?";
                }
                conn = (HttpURLConnection) new URL(url + split + params).openConnection();
                conn.setRequestProperty("Content-type", "text/html;charset=" + encode);
            } else {
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            }
            if (headMap != null && !headMap.isEmpty()) {
                for (Entry<String, String> e : headMap.entrySet()) {
                    conn.setRequestProperty(e.getKey(), e.getValue());
                }
            }

            conn.setRequestMethod(method);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(8000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            if (POST_METHOD.equals(method)) {
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), encode);
                params = getParams(paramMap, encode);
                out.write(params);
                out.flush();
                out.close();
            }
            return conn;
        } catch (Exception e) {
            throw new HttpException(e);
        } finally {
        	logger.info("请求接口{}", url);
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
    
    public static String getSpecialCookie(String method, String url, Map<String, ?> paramMap, Map<String, String> headMap, int status, String encode,String cookieStr) throws HttpException {
        HttpURLConnection conn = null;
        try {
            String params = "";
            if (GET_METHOD.equals(method)) {
                params = getParams(paramMap, encode);
                String split = "";
                if (StringUtils.isNotBlank(params)){
                    split = url.contains("?") ? "&" : "?";
                }
                conn = (HttpURLConnection) new URL(url + split + params).openConnection();
                conn.setRequestProperty("Content-type", "text/html;charset=" + encode);
                conn.setRequestMethod(method);
            } else {
            	URL postUrl = new URL(url);
                conn = (HttpURLConnection)postUrl.openConnection();
                conn.setRequestMethod(method);
                conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
                conn.setUseCaches(false);
            }
            if(StringUtils.isNotEmpty(cookieStr)){
            	conn.setRequestProperty("Cookie", cookieStr);
            }
            if (headMap != null && !headMap.isEmpty()) {
                for (Entry<String, String> e : headMap.entrySet()) {
                    conn.setRequestProperty(e.getKey(), e.getValue());
                }
            }
            
            conn.setRequestMethod(method);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(8000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            
            if (POST_METHOD.equals(method)) {
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), encode);
                params = getParams(paramMap, encode);
                out.write(params);
                out.flush();
                out.close();
            }
            
            String sessionId = "";  
            String cookieVal = "";  
            String key = null;  
            //取cookie  
//            for(int i = 1; (key = conn.getHeaderFieldKey(i)) != null; i++){  
//                if(key.equalsIgnoreCase("set-cookie")){  
//                    cookieVal = conn.getHeaderField(i);  
//                    cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));  
//                    sessionId = sessionId + cookieVal + ";";  
//                }  
//            }  
            
            logger.info("请求接口{},请求参数{},返回状态{},返回结果{}", url, params, conn.getResponseCode(), sessionId);
            
//            return sessionId;
            
            StringBuilder resBuilder = null;
                if (conn.getResponseCode() == status) {
                    // 取得输入流，并使用Reader读取
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), encode));
                    String lines;
                    resBuilder = new StringBuilder();
                    while ((lines = reader.readLine()) != null) {
                        resBuilder.append(lines);
                    }
                    reader.close();
                    return resBuilder.toString();
                }
                return null;
        } catch (Exception e) {
            throw new HttpException(e);
        } finally {
        	logger.info("请求接口{}", url);
            if (conn != null) {
                conn.disconnect();
            }
            	
        }
    }

    /**
     * @param paramMap
     * @return
     * @throws java.io.UnsupportedEncodingException
     * @author  
     */
    public static String getParams(Map<String, ?> paramMap, String encode)
            throws UnsupportedEncodingException {

        if (paramMap == null) {
            return "";
        }

        List<String> paramList = new ArrayList<String>();
        for (Entry<String, ?> entry : paramMap.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            paramList.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(), encode));
        }
        return StringUtils.join(paramList, "&");
    }
    
    /**
     * @param paramStr
     * @return
     * @throws java.io.UnsupportedEncodingException
     * @author  
     */
    public static Map<String,String> getParamsMap(String reqUrl, String encode)
            throws UnsupportedEncodingException {

        if (reqUrl == null) {
            return null;
        }
        
        String paramsStr = reqUrl.substring(reqUrl.indexOf("?")+1);
        Map<String,String> paramMap = new HashMap<String,String>();
        String[] nameValuePairArr = paramsStr.split("&");
        for(String paramNameValuePair : nameValuePairArr){
        	String[] nameValueArr = paramNameValuePair.split("=");
        	if(null!=nameValueArr && nameValueArr.length==2){
        		paramMap.put(nameValueArr[0], nameValueArr[1]);
        	}
        }
        return paramMap;
    }

    private HttpUtil() {
    }
}
