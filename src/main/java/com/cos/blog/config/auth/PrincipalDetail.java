package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;


// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 userDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션장소에 저장을 해준다.
//@Data //Getter Setter 다 만듬
@Getter
public class PrincipalDetail implements UserDetails {
	private User user; //컴포지션(객체를 품고있음)

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	//alt shift s 오버라이드
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴한다.(true:만료 안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있는지 리턴(true:안 잠김)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호가 만료되지 않았는지 리턴(true:만료 안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정 활성화(사용가능)인지 리턴(true: 활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정의 권한 리턴
	@Override
	// GrantedAuthority를 상속한 클래스 형태의 Collection객체를 리턴	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//ArrayList의 부모는 Collection이다
		Collection<GrantedAuthority> collectors = new ArrayList<>();
//		collectors.add(new GrantedAuthority() {
//
//			@Override
//			public String getAuthority() {
//				// 스프링에서 ROLE을 받을 때 규칙, ROLE을 꼭 넣어줘야함.				
//				return "ROLE_"+user.getRole(); //ROLE_USER 리턴해줘야 인식 가능
//			}
//		});
		
		collectors.add(()->{return "ROLE_"+user.getRole();});
		
		return collectors;
	}
	
}
