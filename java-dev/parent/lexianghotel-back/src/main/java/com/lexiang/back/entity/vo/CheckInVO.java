package com.lexiang.back.entity.vo;

import java.io.Serializable;

import com.lexiang.back.entity.CheckIn;
import com.lexiang.back.entity.Room;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CheckInVO extends CheckIn implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	private Room room;

}
