package com.lexiang.file.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 
 * @author wangle
 * @date 2019-1-30
 *
 */
public class FileNameUtil {
	/**
	 * 
	 * @param fileName(文件名)
	 * @return 返回文件后缀名
	 */
	public static String getSuffix(String fileOriginName) {

		//截取文件的后缀名
		return fileOriginName.substring(fileOriginName.lastIndexOf("."));

	}
	
	/**
	 * 
	 * @param fileOriginName(文件原始名)
	 * @return 处理后的文件名(包括后缀)
	 */
	public static String getFileName(String fileOriginName) {
		
		//获得文件上传时间
		String fileDateFomate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
		
		//去除时间上的-和:符号
		String fileDate = fileDateFomate.replace("-", "").replace(":", "");
		
		//获取文件后缀名
		String suffix = FileNameUtil.getSuffix(fileOriginName);
		
		//生成最终的文件名
		String fileName = fileDate+"_"+UUIDUtil.getUUID()+suffix;
		
		//返回文件名
		return fileName;
		
	}

}
