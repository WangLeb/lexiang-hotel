package com.lexiang.back.entity.vo;

import com.lexiang.back.entity.Room;
import com.lexiang.back.entity.RoomType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RoomVO extends Room {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoomType roomType;

}
