package com.lexiang.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class LexiangAuthorizationServerConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
		    .antMatchers("login", "/oauth/authorize")
		    .and()
		    .authorizeRequests()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .formLogin()
		    .permitAll();
	}

}
