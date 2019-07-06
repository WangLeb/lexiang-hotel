package com.lexiang.back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@Configuration
@EnableResourceServer
public class LexiangHotelBackClientConfig extends WebSecurityConfigurerAdapter {
	
            @Override
            protected void configure(HttpSecurity http) throws Exception {
            	http.formLogin()
            	.and()
            	//这句话的意思是接下来都是授权操作
            	.authorizeRequests()
            	.antMatchers("/*").permitAll()
            	//这些请求不需要通过验
            	//任何请求
            	.anyRequest()
            	//都需要认证
            	.authenticated()
            	.and()
            	.csrf().disable()
            	.cors().disable();
            }

}
