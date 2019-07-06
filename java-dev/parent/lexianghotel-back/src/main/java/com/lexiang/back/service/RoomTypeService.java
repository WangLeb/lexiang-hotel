package com.lexiang.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.RoomType;
import com.lexiang.back.entity.dto.RoomTypeDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-03-26
 */
public interface RoomTypeService extends IService<RoomType> {
	
	PageInfo<RoomType> listRoomType(RoomTypeDTO roomTypeDTO);
	
	void insetRoomType(RoomTypeDTO roomTypeDTO);

}
