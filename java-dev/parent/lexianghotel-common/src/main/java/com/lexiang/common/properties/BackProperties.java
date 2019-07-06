package com.lexiang.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


import com.lexiang.common.properties.back.sercurityProperties;

import lombok.Data; 

/**
 * @description 自定义酒店back端配置
 * @author 王乐
 * @date 2019-3-24
 */
@Data
@ConfigurationProperties(prefix="lexiang.config.back")
public class BackProperties {
	

   
   private sercurityProperties sercurity = new sercurityProperties();
   

}
