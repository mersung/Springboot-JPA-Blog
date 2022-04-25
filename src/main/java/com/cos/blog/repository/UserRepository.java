package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//해당 JpaRepository는 User테이블이 관리하는 Repository이며, User테이블의 PK는 Integer이다.
//JSP로 따지면 DAO라고 생각하면 됨(JpaRepository를 상속 받았으므로)
//자동으로 bean 등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	//SELECT*FROm user WHERE username = 1?; 
	Optional<User> findByUsername(String username);
}





//JPA Naming쿼리
	//Select * From user where username = ?1 and password =?2;
//	User findByUsernameAndPassword(String username, String password);
	
	//UserRepository.login하면 밑에 실행
	//	@Query(value="Select * From user where username = ?1 and password =?2", nativeQuery = true)
	//	User login(String username, String password);
