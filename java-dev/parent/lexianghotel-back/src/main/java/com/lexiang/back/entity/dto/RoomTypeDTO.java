package com.lexiang.back.entity.dto;

import com.lexiang.back.entity.RoomType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RoomTypeDTO extends RoomType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pageSize;
	private Integer pageIndex;
	
	
	
	

}
