package com.lexiang.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.dto.RoomDTO;
import com.lexiang.back.entity.vo.RoomVO;
import com.lexiang.back.service.RoomService;
import com.lexiang.common.constants.BusConstant;
import com.lexiang.common.constants.Message;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王乐
 * @since 2019-03-25
 */
@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService  roomService;
	
	@PostMapping("/list")
	public Message listRoomType(@RequestBody(required=false) RoomDTO roomDTO) {
		
		
		PageInfo<RoomVO> listRoom = roomService.listRoom(roomDTO);
		return new Message().ok().addData("roomList", listRoom);
	}
	
	@PostMapping("/insert")
	public Message insertRoom(@RequestBody(required=false) Room room) {
		
		roomService.insertRoom(room);
		
		return new Message().ok().addMeta("message", BusConstant.INSERT_ROOM_SUCCESS.getDescription());
	}

}

