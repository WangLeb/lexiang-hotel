package com.lexiang.common.constants;


public enum BusConstant {
	
	ROOM_HAS_RESERVE("0001","房间已预订，请重新选择"),
	ROOM_HAS_CHECKIN("0002","房间已入住，请重新选择"),
	INSERT_ROOM_FALSE("0003","添加房间失败"),
	INSERT_ROOM_SUCCESS("0004","添加房间成功"),
	INSERT_BACKUSER_SUCCESS("0005","添加管理员成功"),
	INSERT_BACKUSER_FALSE("0006","添加管理员失败"),
	INSERT_PERMISSION_FALSE("0005","添加权限失败"),
	INSERT_PERMISSION_SUCCESS("0005","添加权限成功");
	private final String msg;
	
	private final String description;
	  public String getMsg() {
		return msg;
	}



	public String getDescription() {
		return description;
	}



	private BusConstant(String msg,String description){
	        this.msg = msg;
	        this.description = description;
	    }
	

}
