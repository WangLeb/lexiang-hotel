package com.lexiang.back.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Backuser;
import com.lexiang.back.entity.dto.BackUserDTO;
import com.lexiang.back.entity.vo.BackUserVO;
import com.lexiang.back.service.BackuserService;
import com.lexiang.common.constants.BusConstant;
import com.lexiang.common.constants.Message;



/**
 * <p>
 * 后台管理员表 前端控制器
 * </p>
 *
 * @author 王乐
 * @since 2019-04-09
 */
@RestController
@RequestMapping("/backuser")
public class BackuserController {
	
	
	@Autowired
	private BackuserService backuserService;
	
	
	private static final Logger log = LoggerFactory.getLogger(BackuserController.class);


	/**
	 * 
	 * @return 管理員列表
	 */

	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Message listBackUser(@RequestBody BackUserDTO backUserDTO){
		log.info("能够获取前台的参数");
		PageInfo<BackUserVO> listBackUser = backuserService.listBackUser(backUserDTO);
		return new Message().ok().addData("backUser",listBackUser);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Message insertBackUser(@RequestBody Backuser backUser){
		log.info("能够获取前台的参数");
		backuserService.insertBackUser(backUser);
		return new Message().ok().addMeta("message", BusConstant.INSERT_BACKUSER_SUCCESS.getDescription());
	}
}

