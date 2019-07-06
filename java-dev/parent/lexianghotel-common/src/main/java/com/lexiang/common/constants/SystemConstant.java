package com.lexiang.common.constants;


public class SystemConstant {



    /**
     * Message 中的 code
     * 1成功
     * 2失败
     * 3系统内部错误 失效
	 * 4token过期
     */
    public static final String SUCCESS = "1";
    public static final String FAIL = "2";
    public static final String SYSTEM_ERROR = "3";
	public static final String TOKEN_FAIL= "4";



    /**
     * 返回消息定义
     */
    public static final String SUCCESS_MSG = "请求成功";
    
    public static final String FAIL_MSG = "请求失败";
    public static final String FAIL_LOGIN_MSG = "用户名或者密码错误";
    public static final String FAIL_JWT_MSG = "用户没有TOKEN，请重新登录";
    public static final String FAIL_JWT_PAST_DUE = "TOKEN失效，请重新登录";
	public static final String SIGN_FAIL_MSG = "签名错误";
	public static final String SYSTEM_FAIL_MSG = "系统错误";
    public static final String FAIL_USER_MSG = "用户不存在，请联系管理员";
    public static final String FAIL_USER_REGISTER__MSG = "账号已存在，请重新注册";
    public static final String FAIL_USER_FORBIDDEN = "您目前没有权限访问，请联系管理员";
    public static final String SYSTEM_EXCEPTION = "系统繁忙，请稍后再试";
    public static final String FAIL_FILE_MSG = "文件不存在";

    public static final String NO_DATA_MSG = "暂无数据";

}
