/** 
 * Project Name:hxcrawler 
 * File Name:FileUtil.java 
 * Package Name:com.hangxun.util 
 * Date:2017年7月12日上午11:08:29 
 * Copyright (c) 2017, hurico@126.com All Rights Reserved. 
 * 
 */ 

package net.hk.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/** 
 * ClassName:FileUtil <br/> 
 * Function: 写入到文件 <br/> 
 * Reason:   TODO ADD REASON.(可选) <br/> 
 * Date:     2017年7月12日 上午11:08:29 <br/> 
 *
 * @author   hugui 
 * @version   
 * @since    JDK 1.7     
 */
public class FileUtil {
	
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
