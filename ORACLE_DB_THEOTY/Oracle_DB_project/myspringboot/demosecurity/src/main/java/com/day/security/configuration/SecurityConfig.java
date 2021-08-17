package com.day.security.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.day.security.handler.MyLoginFailerHandler;
import com.day.security.handler.MyLoginSuccessHandler;

//스프링 시큐리티의 웹 보안 기능 초기화 및 설정
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();//비밀번호를 안전하게 저장할 수 있도록 비밀번호의 단방향 암호화를 지원하는 PasswordEncoder 인터페이스와 구현체들을 제공한다
		/*
		 BcryptPasswordEncoder : Bcrypt 해시 함수를 사용하여 비밀번호 암호화
		 Argon2PasswordEncoder : Argon2 해시 함수를 사용하여 비밀번호 암호화
		 Pbkdf2PasswordEncoder : Pbkdf2 해시 함수를 사용하여 비밀번호 암호화
		 SCryptPasswordEncoder : SCrypt 해시 함수를  사용하여 비밀번호 암호화
		 */
//		 return new PasswordEncoder() {
//
//			@Override
//			public boolean matches(CharSequence rawPassword, String encodedPassword) {
//				log.error("MyPasswordEncoder.matches.rawPassword : [" + rawPassword + "]");
//				log.error("MyPasswordEncoder.matchesencodedPassword : [" + encodedPassword + "]");
//				return rawPassword.equals(encodedPassword);
//			}
//
//			@Override
//			public String encode(CharSequence rawPassword) {
//				return rawPassword.toString();
//			}
//		};
	}
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new MyLoginSuccessHandler();
	}
	@Bean
	public AuthenticationFailureHandler failHandler() {
		return new MyLoginFailerHandler();
	}
	 
	@Autowired
	DataSource dataSource;
	
//	모든 인증은 AuthenticationManager를 통해 이루어지며 AuthenticationManager를 생성하기 위해서는 AuthenticationManagerBuilder를 사용
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		log.error("<1>configureGlobal----");
//		auth.inMemoryAuthentication().withUser("a").password(passwordEncoder().encode("1")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("b").password(passwordEncoder().encode("2")).roles("MANAGER");
		
		
		
		String query1 = "SELECT userid, userpw, enabled FROM tbl_member WHERE userid=?";
		String query2 = "SELECT userid, auth FROM tbl_member_auth WHERE userid=?";
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query1)
//		.rolePrefix("ROLE_")
		.authoritiesByUsernameQuery(query2);
	}
	
	
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		log.error("security configure AuthenticationManagerBuilder----");
//		auth.userDetailsService(customUserDetailsService);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.error("<2>configure(HttpSecurity http)---------------");
		http
		 .csrf().disable()
			.authorizeRequests() // 요청에 대한 권한확인한다.
				.antMatchers("/myLogin").permitAll() // 누구나 접근 허용
				.antMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 접근 가능
//				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/manager/**").hasRole("MANAGER")
		.and()	
//		     인증방법은 폼로그인방식처리. spring security내장된 /login과 /logout사용함
//			.formLogin(); 
//		                 
			.formLogin()
				.loginPage("/myLogin") // the custom login page
				                       //커스텀 로그인 form의 action 경로와 loginPage()의 파라미터 경로가 일치해야 인증을 처리할 수 있음		/*			.successHandler(successHandler())
				.successHandler(successHandler())
				.failureHandler(failHandler())
				// 사용자정의 /myLogin를 사용하면  getpost /logout사용불가
		.and() // 로그아웃 설정
           .logout()
           		.logoutRequestMatcher(new AntPathRequestMatcher("/myLogout"))
//           		.logoutSuccessUrl("/")
           		.logoutSuccessUrl("/user")
           		.invalidateHttpSession(true)
		.and()
//		       권한이 없는 경우 403응답코드가 응답된다.
//	       403응답인 경우  accessDeniedPage값에 지정된 url로 forward된다 : controller필요!
			.exceptionHandling()
				.accessDeniedPage("/accessError")
		
	;
	}	

	@Override
	public void configure(WebSecurity web) { // 4
		log.error("<3> configure(WebSecurity)----");
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/html/**");
	}
}
