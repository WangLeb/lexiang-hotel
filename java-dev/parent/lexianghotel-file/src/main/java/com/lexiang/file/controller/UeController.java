package com.lexiang.file.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.lexiang.file.service.FileService;

/**
 * @author wangle
 * @version v 1.0
 * @create 2018-12-05 16:03
 **/


@RestController
@RequestMapping("/fileUpload")
public class UeController {
	
	
	//获取上传的地址
	@Value("${web.upload-path}")
	private String path;
	
	//获得上传到哪台服务器的IP
	@Value("${web.local-ip}")
	private String ip;
	
	//获得上传到到服务器的端口
	@Value("${server.port}")
	private String port;
	

	
	
	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/ueUpload",method = RequestMethod.GET)
	public JSONObject ueUpload(HttpServletRequest request) {
	
		JSONObject json = new JSONObject();
		String action = request.getParameter("action");
		if (action.equals("config")) {
			json.put("imageFieldName", "");
			json.put("imageMaxSize", "");
			List<String> list = new ArrayList<>();
			list.add(".png");
			list.add(".jpg");
			list.add(".jpeg");
			json.put("imageAllowFiles", list);
			json.put("imageFieldName", "upfile");
			json.put("imageActionName", "uploadimage");
			json.put("imageUrlPrefix", "");
			return json;
		}
		if (action.equals("uploadimage")) {

			json = fileService.ueUpload(request,path,ip,port);
		}
		return json;
	}
	

	@RequestMapping(value = "/one")
	public JSONObject fileUpload(@RequestParam("files") MultipartFile[] files) {
		JSONObject fileUpload = fileService.fileUpload(files, path, ip,port);
		return fileUpload;
	}
}
