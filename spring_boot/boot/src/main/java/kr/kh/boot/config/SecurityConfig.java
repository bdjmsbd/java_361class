package kr.kh.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import kr.kh.boot.model.util.UserRole;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// csrf : 다른 사이트에서 우리 사이트로 공격. Cross-Site Request Forgery
		// member/admin interceptor의 기능
		
		// http.csrf().disable(); // The method csrf() from the type HttpSecurity has been deprecated since version 6.1 and marked for removal
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/post/insert/*", "/post/update/*", "/post/delete/*")
						

						// 위 URL 권한이 'USER'인 회원만 접근하도록 설정
						//.hasAuthority(UserRole.USER.name())			
						
						// 위 URL 권한이 'ROLE_USER'인 회원만 접근하도록 설정
						//.hasRole(UserRole.USER.name())
						
						// 〃USER거나 ADMIN이면〃
						.hasAnyAuthority(UserRole.USER.name(), UserRole.ADMIN.name())
						.requestMatchers("/admin/**").hasAnyAuthority(UserRole.ADMIN.name())
						.anyRequest().permitAll() // 그 외 요청은 인증 필요
				)
				.formLogin((form) -> form
						// .loginPage("/login") // 자체 제작한 login page를 사용할 경우 id/pw의 name은 username/password로 맞춰줘야 한다.
						.permitAll() // 로그인 페이지는 접근 허용
						.loginProcessingUrl("/login")//
						.defaultSuccessUrl("/"))
				.logout((logout) -> logout
						.logoutUrl("/logout") // 이 URL로 post방식으로 전송하면 로그아웃이 자동으로 실행.
						.logoutSuccessUrl("/") // 성공시 이동 경로
						.clearAuthentication(true)
						.invalidateHttpSession(true)
						.permitAll()); // 로그아웃도 모두 접근 가능
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}