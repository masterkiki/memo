package com.pks.memo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pks.memo.common.FileManagerService;
import com.pks.memo.common.PermissionInterceptor;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
	
	@Autowired
	private PermissionInterceptor interceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH + "/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(interceptor)
		.addPathPatterns("/**")   // 인터셉터를 거쳐서 처리할 페이지 의 url 규칙 /**  이건 전체  /post/** 이건포스트관련
		.excludePathPatterns("/user/signout", "/static/**", "/images/**");  // 로그인 상태에서 로그아웃이 불가능해져서 제외 처리
	}
}
