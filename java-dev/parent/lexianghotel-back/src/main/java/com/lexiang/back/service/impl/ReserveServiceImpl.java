package com.lexiang.back.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Reserve;
import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.dto.ReserveDTO;
import com.lexiang.back.entity.vo.ReserveVO;
import com.lexiang.back.mapper.ReserveMapper;
import com.lexiang.back.mapper.RoomMapper;
import com.lexiang.back.service.ReserveService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-02
 */
@Service
public class ReserveServiceImpl extends ServiceImpl<ReserveMapper, Reserve> implements ReserveService {
	@Autowired
	private ReserveMapper reserveMapper;
	
	@Autowired
	private RoomMapper roomMapper;

	@Override
	public PageInfo<ReserveVO> listReserve(ReserveDTO reserveDTO) {

	
		//开启分页
		PageHelper.startPage(reserveDTO.getPageIndex(), reserveDTO.getPageSize());
		
	    //查询列表
		List<ReserveVO> listReserve = reserveMapper.listReserve(reserveDTO);
		
	
		
		//包装查询列表
		PageInfo<ReserveVO> pageInfo = new PageInfo<ReserveVO>(listReserve);
		
		return pageInfo;
	}

	@Override
	public void insertReserve(Reserve reserve) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("type_id", reserve.getTypeId());
		hashMap.put("state", 0);
		//新建mybatisPLUS查询模板
		QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
		//为模板添加条件
		QueryWrapper<Room> eq = queryWrapper.allEq(hashMap);
		List<Room> selectList = roomMapper.selectList(eq);
		Room room = selectList.get(0);
		
		roomMapper.updateById(room.setState(1));
		String id = room.getId();
		
		Reserve reserves = reserve.setRoomId(id);
		reserveMapper.insert(reserves);
	}
	
	

}
