package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController//데이터만 리턴
public class UserApiController {
	
//	@Autowired
//	private HttpSession session;
	
	@Autowired //세션 객체는 스프링컨테이너가 bean으로 등록을 해서 가지고 있음
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//회원가입 이므로 /auth 붙여서 인증 x
	//왜 /auth/loginProc를 안 만드는지 : SecurityConfig에서 가로채기 때문
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		System.out.println("UserApiController: save 호출됨");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴
		
	}
	
//	//스프링 시큐리티 이용해서 로그인
	
	
	
	
//	@PostMapping("/api/user/login")
//	//로그인시 세션을 받을 수 있음
//	public ResponseDto<Integer> login(@RequestBody User user){
//		System.out.println("UserApiController: save 호출됨");
//		User principal = userService.로그인(user); //principal(접근주체)
//		
//		//세션이 만들어짐		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴
//	}
	
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){ //RequestBody가 없을 경우 Json을 못받음, key=value형태로만 받을 수 있게됨
		userService.회원수정(user);
		//트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음.
		//하지만 세션값은 변경되지 않은 상태이기 때문에 직접 세션값을 변경해줘야한다.
		//회원수정을 해도 DB에는 변경이 되지만 회원수정 탭에서 볼 땐 그대로이다.
		
		//세션 등록
		//어썬티케이션 매니저에게 유저네임과 패스워드를 던져서
		//매니저가 자동으로 세션등록 해준다. 워드문서 참고
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
