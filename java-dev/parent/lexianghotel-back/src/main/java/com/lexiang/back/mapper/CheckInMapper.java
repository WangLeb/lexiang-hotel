package com.lexiang.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lexiang.back.entity.CheckIn;
import com.lexiang.back.entity.dto.checkInDTO;
import com.lexiang.back.entity.vo.CheckInVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-03-24
 */
@Mapper
public interface CheckInMapper extends BaseMapper<CheckIn> {
	
   /**
    * 
    * @return 查询登记列表
    */
   List<CheckInVO> listCheckIn(checkInDTO checkInDTO);

}
