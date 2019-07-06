package com.lexiang.file.util;

import java.util.UUID;

/**
 * 
 * @author wangle
 * @date 2019-1-30
 *
 */
public class UUIDUtil {
    /**
     * 
     * @return 返回去掉"-"的UUID
     */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}