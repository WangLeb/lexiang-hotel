package com.lexiang.back.mapper;

import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.dto.RoomDTO;
import com.lexiang.back.entity.vo.RoomVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-03-25
 */
@Mapper
public interface RoomMapper extends BaseMapper<Room> {
  
	List<RoomVO> listRoom(RoomDTO roomDTO);
}
