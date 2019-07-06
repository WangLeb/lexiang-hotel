package com.lexiang.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import com.lexiang.common.properties.back.sercurityProperties;

import lombok.Data;

/**
 * @description 自定义酒店web端配置
 * @author 王乐
 * @date 2019-3-24
 */
@Data
@ConfigurationProperties(prefix="lexiang.config.web")
public class WebProperties {
	   
	   private sercurityProperties sercurity = new sercurityProperties();

}
