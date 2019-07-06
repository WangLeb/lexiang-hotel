package com.lexiang.file.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author ASUS
 * @category 文件上传工具类
 *
 */
public class FileUtil {



	/**
	 * 
	 * @param file     前台传输的文件
	 * @param path     本地基地址
	 * @param fileName 文件名
	 * @return 文件是否上传成功
	 */

	public static void uploudHasParent(File file) {
		if (file.getParentFile() != null) {
			if (!file.getParentFile().exists()) {

				file.getParentFile().mkdirs();

			}
		}
	}

	public static JSONObject uploadOne(MultipartFile file, String path,String ip,String port,HashMap<String, Object> filePath) {

		
		String uploadpath = "";
		// 获得文件的原始名
		String fileOriginName = file.getOriginalFilename();

		// 获得处理后的文件名
		String fileName = FileNameUtil.getFileName(fileOriginName);

		// 获得生成图片的年月日
		String uploudTime = FileTimeUtil.getUploudTime();
		// 生成新的文件名
		String realPath = path + "/" + uploudTime + "/" + FileNameUtil.getFileName(fileName);
		System.out.println("sdsd" + realPath);
		File dest = new File(realPath);
		FileUtil.uploudHasParent(dest);
		try {
			file.transferTo(dest);
			uploadpath = "http://"+ip+":"+port+"/"+"file/"+realPath.substring(realPath.lastIndexOf("//")).replace("//", "");
			

		} catch (IllegalStateException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

		filePath.put("url", uploadpath);
		filePath.put("SUCCESS", "SUCCESS");
		filePath.put("title",FileNameUtil.getFileName(fileName));
		filePath.put("original",FileNameUtil.getFileName(fileName));
	    System.out.println();
		return new JSONObject(filePath);

	}

	public static JSONObject uploadMore(MultipartFile[] files, String path,String ip,String port,HashMap<String, Object> filePath) {

	
		// 获得生成图片的年月日
		String uploudTime = FileTimeUtil.getUploudTime();
		// 生成新的文件名

		String uploadpath = "";

		for (MultipartFile file : files) {
			
			// 获得文件的原始名
			String fileOriginName = file.getOriginalFilename();
			
			// 获得处理后的文件名
			String fileName = FileNameUtil.getFileName(fileOriginName);
			
			// 生成新的文件名
			//String realPath = path + "/" + uploudTime + "/" + FileNameUtil.getFileName(fileName);
			String realPath = path + "/" + uploudTime + "/" + FileNameUtil.getFileName(fileName);

			File dest = new File(realPath);
			FileUtil.uploudHasParent(dest);
			try {
				file.transferTo(dest);
				if (uploadpath == "") {

					uploadpath = "http://"+ip+":"+port+"/"+realPath.substring(realPath.lastIndexOf("//")).replace("//", "");
				} else {
					uploadpath = uploadpath + "," + realPath.substring(realPath.lastIndexOf("//")).replace("//", "");
				}

			} catch (IOException e) {
                 
				e.printStackTrace();
			}

			filePath.put("filepathmore", uploadpath);
			System.out.println("文件名" + uploadpath);
		}
		return new JSONObject(filePath);
	}

}
