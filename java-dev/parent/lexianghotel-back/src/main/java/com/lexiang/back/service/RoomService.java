package com.lexiang.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.dto.RoomDTO;
import com.lexiang.back.entity.vo.RoomVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-03-25
 */
public interface RoomService extends IService<Room> {
	
	PageInfo<RoomVO> listRoom(RoomDTO roomDTO);
	
	void insertRoom(Room room);

}
