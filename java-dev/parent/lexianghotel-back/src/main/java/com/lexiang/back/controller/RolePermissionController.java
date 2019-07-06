package com.lexiang.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lexiang.back.entity.RolePermission;
import com.lexiang.back.entity.dto.RolePermissionDTO;
import com.lexiang.back.service.RolePermissionService;
import com.lexiang.common.constants.BusConstant;
import com.lexiang.common.constants.Message;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@RestController
@RequestMapping("/role-permission")
public class RolePermissionController {
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@RequestMapping("/insert")
	public Message insertRolePermissions(@RequestBody RolePermissionDTO rolePermissionDTO) {
		
		String roleId = rolePermissionDTO.getRoleId();
		QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<RolePermission>();
		QueryWrapper<RolePermission> eq = queryWrapper.eq("role_id",roleId );
		rolePermissionService.remove(eq);
		String[] permissionIds = rolePermissionDTO.getPermissionIds();
		for(String permission:permissionIds) {
			RolePermission rolePermission = new RolePermission();
			rolePermission.setPermissionId(permission);
			rolePermission.setRoleId(roleId);
			rolePermissionService.save(rolePermission);
		}
		
		return new Message().ok().addMeta("message", BusConstant.INSERT_PERMISSION_SUCCESS.getDescription());
		
	}
}

