package com.lexiang.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.RoomType;
import com.lexiang.back.entity.dto.RoomTypeDTO;
import com.lexiang.back.service.RoomTypeService;
import com.lexiang.common.constants.Message;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王乐
 * @since 2019-03-26
 */
@RestController
@RequestMapping("/roomtype")
public class RoomTypeController {
    
	@Autowired
	private RoomTypeService  roomTypeService;
	
	@PostMapping("/list")
	public Message listRoomType(@RequestBody(required=false) RoomTypeDTO roomTypeDTO) {
		
		PageInfo<RoomType> listRoomType = roomTypeService.listRoomType(roomTypeDTO);
		
		return new Message().ok().addData("roomTypeList", listRoomType);
	}
	
	
	@PostMapping("/insert")
	public Message insertRoomType(@RequestBody(required=false) RoomTypeDTO roomTypeDTO) {
		
		roomTypeService.insetRoomType(roomTypeDTO);
		
		return new Message().ok();
	}
}

