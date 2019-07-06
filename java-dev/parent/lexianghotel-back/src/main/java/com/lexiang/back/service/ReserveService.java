package com.lexiang.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Reserve;
import com.lexiang.back.entity.dto.ReserveDTO;
import com.lexiang.back.entity.vo.ReserveVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-02
 */
public interface ReserveService extends IService<Reserve> {
	
	PageInfo<ReserveVO> listReserve(ReserveDTO reserveDTO);
	
	void insertReserve(Reserve reserve);

}
