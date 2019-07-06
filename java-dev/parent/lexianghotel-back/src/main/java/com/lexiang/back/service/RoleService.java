package com.lexiang.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Role;
import com.lexiang.back.entity.dto.roleDTO;
import com.lexiang.back.entity.vo.RoleVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
public interface RoleService extends IService<Role> {

	
	PageInfo<RoleVO> listRole(roleDTO roleDTO);
}
