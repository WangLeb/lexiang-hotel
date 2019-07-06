package com.lexiang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.RoomType;
import com.lexiang.back.entity.dto.RoomTypeDTO;
import com.lexiang.back.mapper.RoomTypeMapper;
import com.lexiang.back.service.RoomTypeService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-03-26
 */
@Service
public class RoomTypeServiceImpl extends ServiceImpl<RoomTypeMapper, RoomType> implements RoomTypeService {
    
	@Autowired
	private RoomTypeMapper roomTypeMapper;
	
	@Override
	public PageInfo<RoomType> listRoomType(RoomTypeDTO roomTypeDTO) {
		if(roomTypeDTO.getPageIndex()!=null&& roomTypeDTO.getPageSize()!=null) {
			PageHelper.startPage(roomTypeDTO.getPageIndex(),roomTypeDTO.getPageSize());
		}
		QueryWrapper<RoomType> queryWrapper = new QueryWrapper<>();
		QueryWrapper<RoomType> eq = queryWrapper.eq("hotel_id", '1');
		List<RoomType> selectList = roomTypeMapper.selectList(eq);
		PageInfo<RoomType> listRoomType = new PageInfo<>(selectList);
		return listRoomType;
	}

	@Override
	public void insetRoomType(RoomTypeDTO roomTypeDTO) {
		roomTypeMapper.insert(roomTypeDTO);
		
	}

}
