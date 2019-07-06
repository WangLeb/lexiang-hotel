package com.lexiang.file.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.lexiang.file.service.FileService;
import com.lexiang.file.util.FileUtil;

/**
 * @author wangle
 * @date 2019-1-30
 *
 */
@Service
public class FileServiceImpl  implements FileService {

	

	/**
	 * 
	 * @param request
	 * @param path
	 * @param ip
	 * @return 返回富文本上传的图片
	 */
    @Override
    public JSONObject ueUpload(HttpServletRequest request,String path,String ip,String port) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
        //获取上传的multipart文件集合
        List<MultipartFile> files = multipartRequest.getFiles("upfile");

     
        JSONObject jsonObject = null;
        if (files != null && files.size() > 0) {
        	for(MultipartFile file:files) {
        		
        		HashMap<String, Object> filePath = new HashMap<>();
        		
        		//执行文件上传
        	    jsonObject = FileUtil.uploadOne(file, path,ip,port,filePath);
        	
        	   
        	}

        }
        return jsonObject;
    }

    /**
     * 
     * @param files
     * @param path
     * @param ip
     * @return 上传汇款凭证的图片集合
     * @throws FileUploadException 
     */
	@Override
	public JSONObject fileUpload(MultipartFile[] files, String path,String ip,String port){
	
		JSONObject uploadMore = null;
		if(files !=null && files.length > 0) {
			HashMap<String, Object> filePath = new HashMap<>();
            for(MultipartFile file:files) {
                uploadMore = FileUtil.uploadOne(file, path,ip,port,filePath);
            }
		}
		return uploadMore;
	}
}
