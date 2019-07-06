package com.lexiang.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.CheckIn;
import com.lexiang.back.entity.dto.checkInDTO;
import com.lexiang.back.entity.vo.CheckInVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-03-24
 */
public interface CheckInService extends IService<CheckIn> {

	CheckIn insertCheckIn(checkInDTO checkInDTO);

	/**
	 * 
	 * @return 查询登记列表
	 */
	PageInfo<CheckInVO> listCheckIn(checkInDTO checkInDTO);
}
