package kr.kh.spring3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.kh.spring3.interceptor.TestInterceptor;
import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebMvc
@Log4j
public class WebConfig implements WebMvcConfigurer{
	
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("WebConfig 입니다.");
		registry.addInterceptor(new TestInterceptor())
					.addPathPatterns("/**");
/*					.addPathPatterns("/login","/login")
					.excludePathPatterns("");*/
	}

}
