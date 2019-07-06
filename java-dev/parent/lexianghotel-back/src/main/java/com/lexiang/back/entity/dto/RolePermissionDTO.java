package com.lexiang.back.entity.dto;

import com.lexiang.back.entity.RolePermission;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RolePermissionDTO extends RolePermission {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] permissionIds; 

}
