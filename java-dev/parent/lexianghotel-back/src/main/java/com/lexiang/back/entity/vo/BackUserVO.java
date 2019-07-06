package com.lexiang.back.entity.vo;

import com.lexiang.back.entity.Backuser;
import com.lexiang.back.entity.Role;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class BackUserVO extends Backuser{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Role role;
    
    private Backuser creatUser;

}
