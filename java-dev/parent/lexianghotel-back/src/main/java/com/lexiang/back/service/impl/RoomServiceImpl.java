package com.lexiang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.dto.RoomDTO;
import com.lexiang.back.entity.vo.RoomVO;
import com.lexiang.back.mapper.RoomMapper;
import com.lexiang.back.service.RoomService;
import com.lexiang.common.constants.BusConstant;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-03-25
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	
	
	@Override
	public PageInfo<RoomVO> listRoom(RoomDTO roomDTO ) {
		PageHelper.startPage(roomDTO.getPageIndex(),roomDTO.getPageSize());
   
      List<RoomVO> roomDTOList = roomMapper.listRoom(roomDTO);

        PageInfo<RoomVO> listRoom = new PageInfo<RoomVO>(roomDTOList);
		return listRoom;
	}
	
	@Override
	public void insertRoom(Room room) {
	

      try {
		roomMapper.insert(room);
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(BusConstant.INSERT_ROOM_FALSE.getDescription());
	   
	}

        
		
	}

}
	