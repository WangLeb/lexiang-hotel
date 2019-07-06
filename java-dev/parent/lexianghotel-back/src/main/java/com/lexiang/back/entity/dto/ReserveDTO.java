package com.lexiang.back.entity.dto;

import com.lexiang.back.entity.Reserve;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class ReserveDTO extends Reserve {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pageSize;
	private Integer pageIndex;

}
