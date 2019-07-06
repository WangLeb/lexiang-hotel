package com.lexiang.back.mapper;

import com.lexiang.back.entity.Reserve;
import com.lexiang.back.entity.dto.ReserveDTO;
import com.lexiang.back.entity.vo.ReserveVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-02
 */
@Mapper
public interface ReserveMapper extends BaseMapper<Reserve> {
	
	List<ReserveVO> listReserve(ReserveDTO reserveDTO);

}
