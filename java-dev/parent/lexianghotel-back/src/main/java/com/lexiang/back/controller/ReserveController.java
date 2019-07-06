package com.lexiang.back.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Reserve;
import com.lexiang.back.entity.dto.ReserveDTO;
import com.lexiang.back.entity.vo.ReserveVO;
import com.lexiang.back.service.ReserveService;
import com.lexiang.common.constants.Message;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-02
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController {
	@Autowired
	private ReserveService reserveService;
	
	private static final Logger log = LoggerFactory.getLogger(ReserveController.class);

	
	/**
	 * 
	 * @return 登记列表
	 */

	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Message listReserve(@RequestBody(required=false) ReserveDTO reserveDTO){

		PageInfo<ReserveVO> listReserve = reserveService.listReserve(reserveDTO);
		
		return new Message().ok().addData("reserveList",listReserve);
		
	}
	
	/**
	 * 插入预订信息
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Message insertReserve(@RequestBody(required=false) Reserve reserve){
		log.info("能够获取前台的参数"+reserve);
		reserveService.insertReserve(reserve);
		return new Message().ok().addMeta("message", "登记名称为"+reserve.getReserveName()+"的用户登记成功");
	}
}

