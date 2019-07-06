package com.lexiang.back.entity.vo;

import java.util.List;

import com.lexiang.back.entity.Permission;
import com.lexiang.back.entity.Role;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class RoleVO extends Role{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Permission> permissions;
}
