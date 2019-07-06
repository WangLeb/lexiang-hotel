package com.lexiang.back.entity.vo;

import com.lexiang.back.entity.Reserve;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReserveVO extends Reserve {

	private static final long serialVersionUID = 1L;
	private Reserve reserve;

}
