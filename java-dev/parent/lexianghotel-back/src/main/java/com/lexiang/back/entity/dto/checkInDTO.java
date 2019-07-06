package com.lexiang.back.entity.dto;

import com.lexiang.back.entity.CheckIn;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class checkInDTO extends CheckIn {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pageSize;
	private Integer pageIndex;
    private String roomCode;
    private String reserveId;
    private String exprinTime;
}
