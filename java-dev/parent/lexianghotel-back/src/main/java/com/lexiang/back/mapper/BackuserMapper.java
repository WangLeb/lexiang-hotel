package com.lexiang.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lexiang.back.entity.Backuser;
import com.lexiang.back.entity.vo.BackUserVO;

/**
 * <p>
 * 后台管理员表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@Mapper
public interface BackuserMapper extends BaseMapper<Backuser> {
	
	List<BackUserVO> listUser();

}
