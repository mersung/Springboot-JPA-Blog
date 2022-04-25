package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것(IoC관리)
@Configuration
//컨트롤러로 가서 실행이 되기 전 모든 요청이 이곳으로 온다.
@EnableWebSecurity //시큐리티 필터가 등록이 된다.  = 스프링 시큐리티가 활성화 되어 있는데 어떤 설정을 해당 파일(아래 SecurityConfig)에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻.
//위 세개는 세트이다. 함께 다님
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean //IoC가 된다.
	//시큐리티가 들고있는 함수
	public BCryptPasswordEncoder encodePWD() {
		//암호화해서 encPassword에 넣어줌
		//	String encPassword = new BCryptPasswordEncoder().encode(null)
		//IoC = 리턴되는 아래 객체를 스프링이 관리한다.
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인해주는데 password를 가로채기 하는데
	//해당 password가 어떤걸로 해쉬가 되어 회원가입이 되었는지 알아야
	//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교 가능
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//request가 아래 주소(antMatchers의 주소)로 들어오면, 누구나 들어올 수 있다. permitAll
		http
			//form태그의 id값을 가져와서 ajax로 요청을 했기 때문에 csrf토큰이 없어서 막아버리기 때문
			.csrf().disable()//csrf토큰 비활성화 (테스트시 걸어두는게 좋음)
			.authorizeRequests()
			.antMatchers("/", "/auth/**","/js/**", "/css/**", "/image/**","/dummy/**")
			.permitAll()// /auth/**는 허락하고,
			.anyRequest()  //다른 Request주소는 
			.authenticated() // 인증을 해야해
		.and()
			.formLogin()
			//매핑된 /auth/loginForm은 자동으로 뜸, '/'만 붙여서 접근하면 제한되어 있기 때문에
			//auth로 갈 때 빼고는 인증이 필요하다. 위에서 걸어줬기 때문
			// 슬러시 '/'로 오면 당연히 인증이 필요하므로 아래 페이지로 이동한다.
			//인증이 되지 않는 어떤 요청은 loginForm으로 온다.
			.loginPage("/auth/loginForm")
			//위에서 로그인을 수행 후 버튼을 클릭하면 
			.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
			.defaultSuccessUrl("/");//위 요청이 정상적으로 완료 되면 이동함
			
		
	}

	
}
