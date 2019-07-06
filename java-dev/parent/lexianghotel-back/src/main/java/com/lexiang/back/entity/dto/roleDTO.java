package com.lexiang.back.entity.dto;

import com.lexiang.back.entity.Role;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class roleDTO extends Role{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pageIndex;
	private Integer pageSize;

}
