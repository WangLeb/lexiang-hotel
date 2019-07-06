package com.lexiang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Role;
import com.lexiang.back.entity.dto.roleDTO;
import com.lexiang.back.entity.vo.RoleVO;
import com.lexiang.back.mapper.RoleMapper;
import com.lexiang.back.service.RoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
      
	@Override
	public PageInfo<RoleVO> listRole(roleDTO roleDTO) {
		if(roleDTO==null) {
		
				PageHelper.startPage(0,0);
			
		}
		else {
			PageHelper.startPage(roleDTO.getPageIndex(), roleDTO.getPageSize());
		}
		
		List<RoleVO> listRole = roleMapper.listRole(roleDTO);
		PageInfo<RoleVO> pageInfo = new PageInfo<RoleVO>(listRole);
		return pageInfo;
	}

}
