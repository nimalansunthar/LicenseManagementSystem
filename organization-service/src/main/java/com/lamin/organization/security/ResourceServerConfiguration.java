package com.lamin.organization.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	 private static final String ROOT_PATTERN = "/**";
	
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
//                .antMatchers(HttpMethod.GET, ROOT_PATTERN).access("#oauth2.hasScope('webclient')")
//                .antMatchers(HttpMethod.POST, ROOT_PATTERN).access("#oauth2.hasScope('webclient')")
//                .antMatchers(HttpMethod.PATCH, ROOT_PATTERN).access("#oauth2.hasScope('webclient')")
//                .antMatchers(HttpMethod.PUT, ROOT_PATTERN).access("#oauth2.hasScope('webclient')")
//                .antMatchers(HttpMethod.DELETE, ROOT_PATTERN).access("#oauth2.hasScope('webclient')");
    }
//    @Override
//    public void configure(HttpSecurity http) throws Exception{
//
//        http
//        .authorizeRequests()
//         // .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
//         // .hasRole("ADMIN")
//          .anyRequest()
//          .authenticated();
//    }
}