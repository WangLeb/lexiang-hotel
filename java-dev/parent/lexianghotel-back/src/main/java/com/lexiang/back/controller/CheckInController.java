package com.lexiang.back.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.CheckIn;
import com.lexiang.back.entity.dto.checkInDTO;
import com.lexiang.back.entity.vo.CheckInVO;
import com.lexiang.back.service.CheckInService;
import com.lexiang.common.constants.Message;


/**
 * <p>
 *  登记表 前端控制器
 * </p>
 *
 * @author 王乐
 * @since 2019-03-24
 */
@RestController
@RequestMapping("/checkin")
public class CheckInController {
	
	@Autowired
	private CheckInService checkInService;
	
	private static final Logger log = LoggerFactory.getLogger(CheckInController.class);

	
	
	/**
	 * 插入登记信息
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Message test(@RequestBody(required=false) checkInDTO checkInDTO){
		log.info("能够获取前台的参数"+checkInDTO);
		CheckIn insertCheckIn = checkInService.insertCheckIn(checkInDTO);
		return new Message().ok().addMeta("message", "登记名称为"+insertCheckIn.getCheckName()+"的用户登记成功");
	}
	/**
	 * 
	 * @return 登记列表
	 */

	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Message listCheckIn(@RequestBody(required=false) checkInDTO checkInDTO){
		log.info("能够获取前台的参数"+checkInDTO);
		PageInfo<CheckInVO> listCheckIn = checkInService.listCheckIn(checkInDTO);
		
		return new Message().ok().addData("registerList",listCheckIn);
		
	}

	@RequestMapping(value="/test")
	public String testSecurity(){

		
		return "Dsdsdasds";
		
	}

}

