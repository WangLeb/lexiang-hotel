package com.lexiang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.CheckIn;
import com.lexiang.back.entity.Reserve;
import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.dto.checkInDTO;
import com.lexiang.back.entity.vo.CheckInVO;
import com.lexiang.back.mapper.CheckInMapper;
import com.lexiang.back.mapper.ReserveMapper;
import com.lexiang.back.mapper.RoomMapper;
import com.lexiang.back.service.CheckInService;
import com.lexiang.common.constants.BusConstant;

/**
 * 
 * 登记管理业务层实现
 * 
 *
 * @author 王乐
 * @since 2019-03-24
 */
@Service
public class CheckInServiceImpl extends ServiceImpl<CheckInMapper, CheckIn> implements CheckInService {

	@Autowired
	private CheckInMapper checkInMapper;

	@Autowired
	private RoomMapper rommMapper;

	@Autowired
	private ReserveMapper reserveMapper;

	public CheckIn insertCheckIn(checkInDTO checkInDTO) {

		// 获得预定号
		String reserveId = checkInDTO.getReserveId();

		CheckIn checkIn = new CheckIn();
		// 当有预定号时
		if (reserveId != null) {

			// 查找吹对应预定号的信息
			Reserve reserve = reserveMapper.selectById(reserveId);
			System.out.println("dsdasdd" + reserve);

			// 将信息存储到实体中

			checkIn.setCardId(checkInDTO.getCardId());
			checkIn.setCheckName(reserve.getReserveName());
			checkIn.setCardId(checkInDTO.getCardId());
			checkIn.setOutTime(reserve.getOutTime());
			checkIn.setCreatTime(reserve.getInTime());
			checkIn.setNums(reserve.getNum());
			checkIn.setPhone(reserve.getReservePhone());
			checkIn.setRoomId(reserve.getRoomId());
			// 获得入住的房间
			Room roomOne = rommMapper.selectById(reserve.getRoomId());
			// 改变房间状态为入住状态
			roomOne.setState(2);
			// 操作
			rommMapper.updateById(roomOne);
			checkInMapper.insert(checkIn);
		}
		// 如果没有预订号
		else {
			String roomCode = checkInDTO.getRoomCode();
			// 查询模板
			QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
			QueryWrapper<Room> eq = queryWrapper.eq("room_code", roomCode);
			Room roomOne = rommMapper.selectOne(eq);
			if (roomOne.getState() == 1) {
				throw new RuntimeException(BusConstant.ROOM_HAS_RESERVE.getDescription());
			}
			if (roomOne.getState() == 2) {
				throw new RuntimeException(BusConstant.ROOM_HAS_CHECKIN.getDescription());
			}
			roomOne.setState(2);
			rommMapper.updateById(roomOne);
			checkIn.setRoomId(roomOne.getId());
			checkInMapper.insert(checkIn);
		}

		return checkIn;
	}

	/**
	 * 
	 * @return 查询登记列表
	 */
	public PageInfo<CheckInVO> listCheckIn(checkInDTO checkInDTO) {
		
		
		if (checkInDTO.getPageIndex()==null||checkInDTO.getPageSize()==null) {
			PageHelper.startPage(0, 0);
		} else {
			PageHelper.startPage(checkInDTO.getPageIndex(), checkInDTO.getPageSize());
		}
		List<CheckInVO> listCheckIn = checkInMapper.listCheckIn(checkInDTO);
		PageInfo<CheckInVO> pageInfo = new PageInfo<CheckInVO>(listCheckIn);
		/*
		 * QueryWrapper<CheckIn> queryWrapper = new QueryWrapper<>(); List<CheckIn>
		 * listCheckIn = checkInMapper.selectList(queryWrapper);
		 */
		
		return pageInfo;
	}

}
