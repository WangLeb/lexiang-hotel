package com.lexiang.back.mapper;

import com.lexiang.back.entity.Role;
import com.lexiang.back.entity.dto.roleDTO;
import com.lexiang.back.entity.vo.RoleVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	
	List<RoleVO> listRole(roleDTO roleDTO);

}
