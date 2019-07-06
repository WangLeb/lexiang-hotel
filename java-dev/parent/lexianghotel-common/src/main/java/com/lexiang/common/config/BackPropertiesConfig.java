package com.lexiang.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.lexiang.common.properties.BackProperties;

/**
 * @description 使back端和web端配置生效
 * @author 王乐
 * @date 2019-3-24
 */

@Configuration
@EnableConfigurationProperties(BackProperties.class)
public class BackPropertiesConfig {

}
