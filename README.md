# Springboot-JPA-Blog

* 환경세팅
	- Oracle JDK 1.8
	- MySQL 5.7
MySQL Workbench 실행 -> 접속
![image](https://user-images.githubusercontent.com/86938974/166133310-bb4c5e46-d804-4bdf-ad6f-b5fcd7b68422.png)
	- Spring Tools 4.11.0
![image](https://user-images.githubusercontent.com/86938974/166133396-ae6e96a3-b753-4629-a752-cb05f30d6687.png)
![image](https://user-images.githubusercontent.com/86938974/166133425-71cdc6d3-3ce6-4135-86b8-75c84ce39aef.png)

Intellij 검색 -> 다운로드
![image](https://user-images.githubusercontent.com/86938974/166133455-80382c06-575b-4d58-bef2-fad863346876.png)
-UTF-8 세팅
![image](https://user-images.githubusercontent.com/86938974/166133509-d2c50cb2-7557-4e2d-990b-10cbcbed45be.png)
![image](https://user-images.githubusercontent.com/86938974/166133519-2cd81efd-2743-4c29-a861-b9074e178d14.png)
![image](https://user-images.githubusercontent.com/86938974/166133525-fb47422e-dd57-4e91-ad91-f471c784432b.png)
![image](https://user-images.githubusercontent.com/86938974/166133531-81fd6a39-ce19-4d85-888a-0db11e9072d2.png)
![image](https://user-images.githubusercontent.com/86938974/166133534-d393c39c-fc2f-4f36-80f6-f46dc4ce36c7.png)

-STS4 웹 개발 환경 세팅
STS4 javaEE 플러그인 설치(JSP 웹 개발 환경)
![image](https://user-images.githubusercontent.com/86938974/166133589-d5b10223-64cb-4d96-b24c-7597d14077d1.png)
![image](https://user-images.githubusercontent.com/86938974/166133615-284b8520-5e8d-4150-87a2-7996c175db4d.png)
STS4 Javascript 파일 인식 설정
*.js Add
![image](https://user-images.githubusercontent.com/86938974/166133656-9a375c7a-c054-43b9-9a19-14c9bf67b118.png)
default 설정
![image](https://user-images.githubusercontent.com/86938974/166133670-1e9e31d6-8f3e-4e87-88e1-94aff24b8d91.png)
![image](https://user-images.githubusercontent.com/86938974/166133699-130c176c-1ea7-44ad-ab2e-d3ba8a3235e8.png)
CSS,HTML,JSP Files Encoding도 UTF-8로 변경

![image](https://user-images.githubusercontent.com/86938974/166133714-04fd2673-c301-48f5-bdf7-879908c92ef1.png)

-STS4 Lombok 플러그인 설치

Projectlombok.org/download
다운로드 폴더 -> git bash here -> java -jar lombok.jar

* 의존성 설정

![image](https://user-images.githubusercontent.com/86938974/166133777-6e7d5653-ab2b-4301-bc11-b48198161cf4.png)

체크목록

- Developer Tools
  - Spring Boot DevTools (파일이 프로젝트 내에서 체인지 될 때, 변경이 일어났으니 자동 재시작)
  - Lombok(게터세터, 생성자를 어노테이션을 통해 자동으로 생성해주는 라이브러리)
	
- SQL
  - Spring Data JPA(데이터베이스를 JPA를 통해 만듦 = ORM)
  MySQL Driver
	
- Security
  - Spring Security(보안 기능에 대한 라이브러리)
	
- Web
  - Spring Web(어노테이션을 쓰기 위해서 체크함, 내장형 컨테이너로 톰캣을 기본 탑재)
	
![image](https://user-images.githubusercontent.com/86938974/166133959-26fed241-57bc-48fd-8141-c58e20255551.png)

pom.xml에 추가해준다.

![image](https://user-images.githubusercontent.com/86938974/166134087-ceafe5ef-8e3f-4633-94c5-1ffe382c89c2.png)

![image](https://user-images.githubusercontent.com/86938974/167418257-479daa1e-c39c-47bf-a6fe-6e524c96406c.png)

* 스프링의 제어의 역전 (IoC)
	* 싱글톤 패턴
	* 레퍼런스 변수를 스프링이 관리
	* 컴포넌트 스캔 : 패키지 이하를 전부 스캔 후 필요한 것들을 메모리에 로드
	* 이 프로젝트에선 com.cos.blog라고 패키지를 만들었으므로 그 이하만 스프링이 스캔한다.
	* com.cos.test처럼 만들어서 작업파일을 그 아래에 만들면 메모리에 뜨지 않는다.
	* 만든 패키지 이하로 만드는것이 중요(아래와 같이)

![image](https://user-images.githubusercontent.com/86938974/167418272-6a3b56d3-91b0-489c-8b0f-fddc8edcf35d.png)

```
@Controller : 스프링이 com.cos.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new하는 것은 아니고 특정 어노테이션이 붙어있는 클래스 파일들을 new해서(IoC) 스프링 컨테이너에 관리해준다.
@GetMapping : 주소 매핑(브라우저에서 찍힘)
	=> http://localhost:8080/test/hello

```
* 사용자 생성 및 권한 주기
```
root 사용자로 MySQL 접속
create user 'cos'@'%' identified by 'cos1234';

GRANT ALL PRIVILEGES ON *.* To 'cos'@'%';
create database blog;
use blog;
```
* MySQL 한글 설정
	* C드라이브 안에 아래 경로 이동
![image](https://user-images.githubusercontent.com/86938974/167419848-818f5fe5-4ed4-419a-8b0b-5d727e4be3d7.png)
	* 아래와 같이 입력
![image](https://user-images.githubusercontent.com/86938974/167420007-4c9dfc21-84ed-42f2-b9eb-8384cbc0377c.png)
![image](https://user-images.githubusercontent.com/86938974/167420093-7812c3f5-2fff-4fba-a91b-ee323f9823e3.png)
![image](https://user-images.githubusercontent.com/86938974/167420173-a083976b-9a9a-44d1-8e8b-fb295498919a.png)

* 한글 설정 확인
```
show variables like 'c%';
```
![image](https://user-images.githubusercontent.com/86938974/167420442-d4614b21-a6ff-4008-a99e-7f881baedae3.png)

	* pom.xml 파일에서 다음과 같이 입력한다.
![image](https://user-images.githubusercontent.com/86938974/167420756-fbab4fcf-9fe9-4707-8af9-3e44cfa30a9d.png)
![image](https://user-images.githubusercontent.com/86938974/167420900-84e3a240-9b9b-4731-9d95-5f70f9473082.png)

* MySQL 프로젝트 연결
	* application.yml로 수정 
![image](https://user-images.githubusercontent.com/86938974/167421490-7090bb9a-e208-4628-8cc9-66255c5106b5.png)
* yml 특징
	* yml은 json 형식과 비슷한 데이터 타입을 가진다.
	* yml은 모든 스프링에 대한 설정을 할 수 있다.
	* 들여쓰기로 구분한다.
- 코드 삽입
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234
```

* HTTP 1.1 요청방식
	* 클라이언트가 서버에게 필요한 데이터를 요청, 서버가 응답해주는 구조가 HTTP구조
	* HTTP 통신은 약속된 통신이 필요하다.(데이터를 갖고 있는 서버와 클라이언트와의 통신)
	* 통신방법(요청의 방법) : Get, Post, Put, Delete 
		* Get : 데이터를 요청 - Select
		* Post : 데이터를 추가 - Insert
		* Put : 데이터를 수정 - Update
		* Delete : 데이터를 삭제 - Delete
		* 어떤 데이터를 요청하는지 --> MIME 타입
	* PostMan 사용
	* HTTP 통신은 클라이언트와 서버가 통신할 때 요청시마다 스트림(선)을 끊고 다시 연결해서 Data를 주고 받는다 : Stateless (연결이 지속되지 않음) 필요할 때마다 연결하므로 서버입장에서 부하가 적다.
	* 채팅처럼 지속적인 응답과 요청이 필요한경우 Stateful방식을 쓴다 : 연결이 지속되는 방식
	* HTTP 방식은 끊고 다시 연결하므로 다시 인증을 해야하는 불편함이 있을 수 있다. 시큐리티를 사용해서 세션을 유지함

* MIME 타입
	* 클라이언트에게 전송된 문서의 다양성을 알려줌
	* type/subtype 구조
	* text/html , img/jpeg (보내는 데이터는 이미지이며, 그 이미지들 중에서도 jpeg다.)
	* audio/mpeg, text/plain 등등 종류가 많음

```
@Controller : 사용자가 요청 -> 응답(HTML 파일)
@RestController : 사용자가 요청 -> 응답(Data) 
```

	* 인터넷 브라우저 요청은 무조건 Get 요청밖에 할 수 없다.
* Get 요청 받아보기

![image](https://user-images.githubusercontent.com/86938974/167427080-0f05502e-a310-4a06-b9aa-a5f41ce03fe2.png)
![image](https://user-images.githubusercontent.com/86938974/167427155-671a9645-82f4-4b1e-875b-7bf9f395b602.png)
![image](https://user-images.githubusercontent.com/86938974/167427210-f8cc1be5-71ed-4f64-8bb9-5d7e4b80e0a9.png)
* 아래와 같이 받아도 됨
	* Spring은 ? 뒤의 값들을 자동으로 member에 넣어준다. 
	* Member.java를 만들어서 getter와 setter를 만들어 줌 	
![image](https://user-images.githubusercontent.com/86938974/167427370-1b42fbf2-643d-4707-a7dd-19573fc07225.png
![image](https://user-images.githubusercontent.com/86938974/167427301-5e9df579-ada9-4472-a81f-ee4d9a2b9655.png)

* Post 요청 받아보기
	* ?로 받지 않고 body로 받음
![image](https://user-images.githubusercontent.com/86938974/167427610-039ae80f-e069-4dd1-aa32-1c299a931903.png)
![image](https://user-images.githubusercontent.com/86938974/167427724-63d60454-f9ec-40cc-b70d-a9596f376d6e.png)
	* RequestBody 어노테이션을 붙이면 다음과 같이 받을 수 있다.
![image](https://user-images.githubusercontent.com/86938974/167427897-8d649f01-7ffa-4353-b5bc-50e1291facf3.png)
![image](https://user-images.githubusercontent.com/86938974/167428040-1d9b3d59-4bca-4068-abc5-06762b21e2d7.png)
	* application/JSON 데이터 보내보기
![image](https://user-images.githubusercontent.com/86938974/167428272-a345c53f-0bd7-4868-9646-26df27896e5e.png)
	* 다음과 같이 바꿔주면
![image](https://user-images.githubusercontent.com/86938974/167428380-a31d1e29-c58c-482d-b596-e10185c4ea68.png)
![image](https://user-images.githubusercontent.com/86938974/167428425-c4c88614-eea2-44da-98ad-febbc9fa32a0.png)
	* 즉 send시 자동으로 파싱해서 오브젝트에 넣어준다. (Member m에) 이를 스프링부트의 MessageConverter가 해준다.
	
* Maven
	* 어떤 라이브러리가 필요하면 해당 사이트로 가서 다운받는다.
	* 다운파일을 copy하여 내 프로젝트 내부(lib)에 넣고 빌드한다.
	* 또는 copy하지 않고 c:\lib를 만들어 이 곳에 copy한다면 하나의 폴더를 다른 프로젝트들에서 사용할 수 있다.
	* ex) 중앙 저장소를 만들어서 JSoup, Lobok, OJDBC, GSON 등의 라이브러리들을 넣어두면 필요시 중앙저장소에만 접근하면 된다. pom.xml이라는 파일에 필요한 기술( ex) OJDBC가 필요해)을 써놓기만 하면 Maven이라는 프로젝트 관리 도구가 이를 읽어서 중앙저장소에서 다운받아 .m2 폴더를 만들고 repository를 만들어 그 내부에 다 다운받아주고 빌드를 해준다. => 사이트를 돌아다니면서 라이브러리를 다운 받을 필요가 없이 pom.xml에 기술만 해주면 된다. 리눅스에서도 Maven을 설치하여 pom.xml에 기술만 해주면 끝
* Lombok 세팅
	* Maven이 관리하는 폴더 들어가기
![image](https://user-images.githubusercontent.com/86938974/167430116-8bcb2306-0f20-4860-bf32-0ee4dccbd1f5.png)
	* jar 파일 사용
![image](https://user-images.githubusercontent.com/86938974/167430289-2333940c-32e0-400b-9755-9eea61fb9d5f.png)
![image](https://user-images.githubusercontent.com/86938974/167430448-0c20797d-687e-4894-bb62-7ee9d012dfa5.png)
![image](https://user-images.githubusercontent.com/86938974/167430503-29b0712d-5652-4a86-a08d-39fede79b86f.png)
![image](https://user-images.githubusercontent.com/86938974/167430609-f6456b54-7963-4274-b26f-98413391c766.png)
	* cmd창으로 cd 명령어로 폴더 이동 후 다음과 같이 사용해도 된다.
```
java -jar lombok-1.18.12.jar
```
```
@Getter : getter 만들어줌
@Setter : setter 만들어줌
@Data : getter, setter 다 만들어줌
@AllArgsConstructor : 전체 생성자 만들어줌
@NoArgsConstructor : 빈 생성자 만들어줌
```
	* 위 어노테이션을 이용하면 다음과 같이 getter, setter를 만들지 않아도 이용할 수 있다.
![image](https://user-images.githubusercontent.com/86938974/167431767-64e88f4a-e91e-4c08-9a3e-fe8a7ee92b76.png)
![image](https://user-images.githubusercontent.com/86938974/167431895-2344975b-ff62-41c8-978e-05b654838660.png)

```
@Builder : 내가 넣고싶은 데이터를 넣을 수 있다. 순서도 필요 없음
@Builder
public Member(int id, String username, String password, String email) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
}
```
```
@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG+"getter:"+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"setter:"+m.getUsername());
		return "lombok test 완료";
	}
```
* yaml
	* 스프링은 포트, DB 연결, 인코딩 등 전반적인 설정을 yaml파일에서 한다..
	* key와 value사이엔 한 칸 띄어져야 한다
	* 중괄호가 없이 들여쓰기가 되어 있음(스페이스 두 칸)
	* 이러한 이유로 Json보다 가볍다
	* 스프링에서는 이 사항들을 application.yml에 저장

![image](https://user-images.githubusercontent.com/86938974/167644837-74c76de5-e7c4-412c-a5c7-4def3d80924b.png)
	* 스프링이 실행하기 직전에 이 파일을 읽는다.
```
* 포트 안에 context 설정 : 기본 주소를 localhost:8000/ 으로 지정
server:
  port: 8000
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true
    
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true
    properties:
      hibernate.format_sql: true

  jackson:
    serialization:
      fail-on-empty-beans: false
      
cos:
  key: cos1234

```
	* physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
=> 테이블을 만들 때 스프링에서의 변수명 그대로 만들어준다.
	* jpa의 ddl-auto : create --> 스프링 프로젝트 실행시 항상 테이블을 새로 만듦, 처음 이후엔 update로 바꿔줘야함 
	* Controller는 파일을 리턴할 때 쓴다. 파일리턴의 기본 경로는 src/main//resources/static이다.
	* 리턴명 : /home.html 을 해줘야
	* src/main//resources/static/home.html을 찾을 수 있다.
	
![image](https://user-images.githubusercontent.com/86938974/167646550-c159dd69-907d-4855-bebd-a89d5e97d447.png)
	* static 폴더는 정적 파일만 인식 가능 -> 이미지 등, jsp는 못 찾는다.
	* 그래서 다음과 같이 prefix와 suffix를 지정해준다. 
```
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
```
![image](https://user-images.githubusercontent.com/86938974/167647279-6d87ceca-5cb5-4277-961b-49642abee658.png)
	* 다음과 같이 매핑하면 됨 (prefix와 suffix를 이용)	
![image](https://user-images.githubusercontent.com/86938974/167647369-98d90c11-99c2-4f10-a097-4277233d777a.png)

* JPA이용 테이블 생성 Blog 테이블 만들기(User, Board, Reply)
	* model 패키지 생성 
![image](https://user-images.githubusercontent.com/86938974/167647817-421b1752-6288-42a5-82e3-eb67d612689a.png)
	* User, Board, Reply 생성
![image](https://user-images.githubusercontent.com/86938974/167647910-0334c5a5-7ee7-481a-bc9c-8b3aba9dcf96.png)

```
package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
//테이블로 만들기 위해
@Entity //User 클래스가 MySQL에 테이블이 생성이 된다.
@Data // Getter와 Setter가 다 있다.
@NoArgsConstructor //빈 생성자
@AllArgsConstructor //전체 생성자
@Builder //빌더패턴
//@DynamicInsert // insert시에 null인 필드를 제외시킨다. Default값에 null이 들어가는 것을 방지, Default가 그대로 생성 된다.
public class User {
	 
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //시퀀스, auto_increment, 자동 입력
	
	@Column(nullable = false, length = 100, unique = true)
	private String username; //아이디
	
	@Column(nullable = false, length = 100) //123456 => 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//	@ColumnDefault("user")
	// DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. // ADMIN, USER 도메인 설정하여 실수 방지
	
	private String oauth; //카카오, 구글 , 어디로 로그인 했는지
	
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;
	
}
```
- @Entity : 테이블화 시킴( User 클래스가 스프링부트가 실행될 때 MySQL에 테이블이 생성이 된다. )
- @Id : Primary Key
- @GeneratedValue(strategy = GenerationType.IDENTITY) : 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. MySQL이므로 auto_increment 전략을 따라감.
- application의 JPA 설정에서 use-new-id-generator-mappings:false를 해줬으므로 JPA의 전략을 사용하지 않는다. 
- @Column(nullable=false, length = 30) : null허용x , 길이 30자
- @CreationTimestamp : 시간이 자동 입력
- @ColumnDefault : default값 설정
- id와 createDate는 자동 입력이다.
- id는 시퀀스, auto_increment 전략을 사용
- username : 아이디
- password : 비밀번호
- email : 이메일 주소

	* ddl-auto를 create로, show-sql을 true로 설정하면 프로젝트 실행마다 다음과 같이 테이블을 만든다.
![image](https://user-images.githubusercontent.com/86938974/167650362-54b2c580-6011-4ebb-9215-b7afa0932dfc.png)

	* 다음과 같이 테이블이 만들어진 것을 확인할 수 있다.
![image](https://user-images.githubusercontent.com/86938974/167651006-ac366067-fc1e-4f50-bef8-736485958743.png)
	* JPA는 ORM이기 때문에 java에 있는 오브젝트를 테이블로 매핑해준다. => 사용자는 오브젝트만 만들면 됨
	* 즉 다음과 같이 수정하고 저장하면 쿼리가 다시 실행되는데,
![image](https://user-images.githubusercontent.com/86938974/167651300-cf17f543-4936-45c3-8f2e-2be0881ddc0d.png)
	* MySQL에서 바로 확인해보면 다음과 같이 em이 바뀐다. JPA가 내가 만든 오브젝트를 테이블로 매핑해주는 ORM 이기때문
![image](https://user-images.githubusercontent.com/86938974/167651369-4b543484-caeb-4b67-b038-f9f2eea3319e.png)

	* Board 테이블 생성
![image](https://user-images.githubusercontent.com/86938974/168274620-503e755a-151c-4194-9096-82da2fce8cc9.png)
```
package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data //getter setter가 다 생성됨
@NoArgsConstructor //빈 생성자
@AllArgsConstructor //전체 생성자
@Builder
@Entity //데이터베이스에 매핑을 시켜주는 ORM클래스이다.
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터 쓸때 사용
	private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.
	
	//	@ColumnDefault("0")
	private int count; //조회수
	
	//얘도 외래키 이므로 JPA에 의해 자동으로 Join
	//fetch = FetchType.EAGER = Board테이블을 셀렉트하면, user	정보를 가져올게, 한 건 밖에 없으니 (reply와는 다르게)
	//fetch타입이 EAGER이면 무조건 들고와야 하는 정보다. 즉 외래키이면서 게시글은 UserId가 꼭 필요하다. 작성자 이므로, 그래서 EAGER로 꼭 들고와준다.
	@ManyToOne(fetch = FetchType.EAGER) //Board가 Many고, User가 One이라는 뜻 = 한 명의 유저는 여러개의 게시글을 쓸 수 있다는 뜻
	@JoinColumn(name="userId") // 필드 값은 userId라고 만들어짐
	private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다. 그래서 자바에서 데이터베이스 형태에 맞춰야함
	// User객체를 자동으로 참조함
	
	//Board를 셀렉트하면, 	reply정보를 필요하면 가져올게 여러 건 있으니, LAZY전략
	//	오로지 Board테이블에 select할 때, 조인해서 값만 넣어주기 위해 reply를 불러온것
//	@OneToMany(mappedBy = "board", fetch=FetchType.LAZY) // 하나의 Board와 여러개의 Reply
	//mappedBy = 연관관계의 주인이 아니다.(FK가 아니다.)DB에 칼럼을 만들지 마세요.
	//	@JoinColumn(name="replyId") 조인컬럼은 필요가 없다. 한 개의 게시글 id에 여러개 Reply가 달릴 경우, 제1 정규화가 깨진다. 필요없음
	//JPA에 의해 쿼리문을 DB에 날리면 자동으로 Board가 가진 외래키들을 Join해준다.
//	private List<Reply> reply; //reply는 한 개의 Board에 여러 개 달릴 수 있으므로 List형태로 지정

	//만약 댓글 불러오기 기능을 하나 만들고 누르면 댓글을 불러온다면, EAGER방식으로 댓글버튼 하나는 꼭 가져온다.
	@OneToMany(mappedBy="board",fetch=FetchType.EAGER, cascade = CascadeType.REMOVE) //보드를 지울 때 댓글을 다 지움
	@JsonIgnoreProperties({"board"}) //Reply에서 호출을 또 하게 될 때 board는 getter호출이 안 된다 => 무한참조 방지
	@OrderBy("id desc")//아이디 값으로 내림차순 정렬해줌
	private List<Reply>replys;
	
	@CreationTimestamp //자동으로 값 생성
	private Timestamp createDate;
	
	
}


```
- 다음과 같이 생성 확인
![image](https://user-images.githubusercontent.com/86938974/168276449-94b9b379-ff43-473b-8fb7-ad23cf38a988.png)
![image](https://user-images.githubusercontent.com/86938974/168276495-a8786d50-3852-4d07-8349-d3fec3ea7012.png)



	* Reply 테이블 생성
```
package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne //여러개의 답변은 하나의 보드(게시글)과 연결된다.
	@JoinColumn(name="boardId") //boardId 컬럼 생성 후 Board를 참조
	private Board board; //Board를 참조
	
	@ManyToOne //여러개의 답변은 하나의 유저가 쓸 수 있다.
	@JoinColumn(name="userId")
	private User user; //답변을 누가 적었는지도 알아야해서 User를 참조
	
	@CreationTimestamp
	private Timestamp createDate;

//	@Override
//	public String toString() {
//		return "Reply [id=" + id + ", content=" + content + ", board=" + board + ", user=" + user + ", createDate="
//				+ createDate + "]";
//	}
//	
	

//	public void update(User user, Board board, String content) {
//		setUser(user);
//		setBoard(board);
//		setContent(content);
//	}
}

```
- 다음과 같이 생성됨
![image](https://user-images.githubusercontent.com/86938974/168276706-bc0e369e-4e0f-482f-8944-107bf330feb2.png)

![image](https://user-images.githubusercontent.com/86938974/168276678-e04a295e-6839-43cb-9279-84ada0fbdd59.png)

	* Enum 지정
- Role의 범위를 지정해준다.
![image](https://user-images.githubusercontent.com/86938974/168279950-f948c488-c112-4521-8017-7b20f7800e9a.png)

```
package com.cos.blog.model;

public enum RoleType {
	USER, ADMIN
}

```


* Repository (DAO 생성)
	* UserRepository 생성
```
package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//해당 JpaRepository는 User테이블이 관리하는 Repository이며, User테이블의 PK는 Integer이다.
//JSP로 따지면 DAO라고 생각하면 됨(JpaRepository를 상속 받았으므로)
//자동으로 bean 등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{

}
```

	* Exception 처리하기
![image](https://user-images.githubusercontent.com/86938974/168285418-c8f8f194-a2e3-4471-9bbf-e21b64746ed5.png)

```
package com.cos.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;

@ControllerAdvice //모든 예외가 발생시 여기로 들어옴
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}
}
```

* 메인화면 만들기
	* 부트스트랩 사용
	* 다음과 같이 index.jsp, UserController, BoardController 생성
![image](https://user-images.githubusercontent.com/86938974/168287712-adb43842-1c94-474e-b977-5541530b6ac9.png)

![image](https://user-images.githubusercontent.com/86938974/168287941-183fe05d-9f70-4d66-a37b-1b2b617b8c46.png)


![image](https://user-images.githubusercontent.com/86938974/168287873-6c3fc9df-2940-4ccb-a6f3-13302b950720.png)


	* index.jsp 코드
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>


<!-- 
request 정보가 넘어올때 BoardController의
model.addAttribute에서 설정한 boards가 넘어온다.
 items에서 boards를 받아 한 건씩 board라는 변수에 저장
  -->
<c:forEach var="board" items="${boards.content}">
	<div class="container">
		<div class="card m-2">
			<div class="card-body">
				<!-- $표시 후 board.title을 호출하면 board의 getter가 호출되어 title을 가져온다 -->
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.id }" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</div>
</c:forEach>
<div>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1 }">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${boards.number-1 }">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1 }">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1 }">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>







<%@ include file="layout/footer.jsp"%>

```
	* index.jsp는 상단과 하단에 따로 만들어놓은 footer.jsp와 header.jsp를 include 해준다.
	* 다음은 footer와 header.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<br />
<div class="jumbotron text-center" style="margin-bottom: 0">
	<p>Created by 심대성</p>
	<p>📞 010-4799-5309</p>
	<p>🏴 인천광역시 서구 가정동</p>
</div>
</body>
</html>
```

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- 인증이 되었는지 확인 -->
<sec:authorize access="isAuthenticated()">
	<!-- principal = current user object에게 direct access를 허용 -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<title>심대성의 스프링부트 블로그</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">홈</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">

			<c:choose>
				<c:when test="${empty principal }">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">
						<!-- 아래는 /auth를 붙이지 않는다. => 글쓰기, 회원정보, 로그아웃은 로그인 된(인증된) 상태여야 가능 -->
						<li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/updateForm">회원정보</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<br />
```
	* Controller 코드
```
package com.cos.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	
		@Autowired
		private BoardService boardService;
		
	
		//컨트롤러에서 세션을 어떻게 찾는지?
		//@AuthenticationPrincipal PrincipalDetail principal
		@GetMapping({"","/"}) // 아무것도 안 적었을 때와 슬래시를 붙였을 때 이동
		//스프링에서는 메인페이지로 갈 때 모델이 필요함		
		public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) { 
			//index 페이지로 boards를 넘긴다.
			model.addAttribute("boards", boardService.글목록(pageable));//model은 jsp의 request라고 생각하면 됨
			// /WEB-INF/views/index.jsp 로 자동
			return "index"; //controller는 리턴시 viewResolver작동, 해당 index페이지로 model의 정보를 들고 이동
			
		}
	}
```


* 로그인, 회원가입 화면 만들기
	* user 폴더에 joinForm, loginForm 생성
![image](https://user-images.githubusercontent.com/86938974/168290266-edcb5dc5-23a8-4dec-a9f7-559658686996.png)
- loginForm.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action = "/auth/loginProc" method = "post">
		<div class="form-group">
			<label for="username">Username:</label>
			<input type="text"  name="username" class="form-control" placeholder="Enter username" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password"  name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href = "https://kauth.kakao.com/oauth/authorize?client_id=33b04fbab6e3c7a483d83d4b74338eb2&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img  height = "38px" src="/image/kakao_login_button.png"></a>
	</form>

</div>

<!-- 
<script src="/js/user.js"></script>
 -->
<%@ include file="../layout/footer.jsp"%>

```

- joinForm.jsp ( 회원가입 ) 
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<script src="/blog/js/user.js"></script>
<div class="container">
	<form>
		<div class="form-group">
			<label for="username">Username:</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<!-- /라고 지정하면 static폴더를 바로 찾아감 -->
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>

```

	* 회원가입을 위한 기초세팅
- form 태그에서 설정하는것이 아닌 자바스크립트를 이용해서 ajax 를 사용하여 전달한다.
- 스프링은 기본적으로 static을 찾아가므로 이 폴더에 정적 파일을 위치시키면 된다.
- user.js 생성
![image](https://user-images.githubusercontent.com/86938974/168291522-ff85f210-8a64-48eb-bf01-5e892859e99d.png)
- user.js 코드
```
index = {
	init:function(){
		$("#btn-save").on("click",()=>{ //function(){} , ()=>{} this를 바인딩하기 위해서
			this.save();
		});
		$("#btn-update").on("click",()=>{ //function(){} , ()=>{} this를 바인딩하기 위해서
			this.update();
		});
	},
	
	save:function(){
		//alert("user의 save함수 호출됨");
		let data = {
			username:$("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		//ajax호출 시 default가 비동기 호출
		// ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data:JSON.stringify(data), //http body데이터 
			contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지
			dataType:"json"  //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascript오브젝트로 변경해줌
			//회원가입 수행 요청이 성공시 done실행, 실패시 fail문 실행
		}).done(function(resp){
			if(resp.status === 500){
				alert("회원가입에 실패하였습니다.");
			}else{
				alert("회원가입이 완료되었습니다.");
				location.href="/";
			}
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
}
index.init();
```
	* api.UserApiController 생성
![image](https://user-images.githubusercontent.com/86938974/168410791-e3d8723a-b0cb-4458-9c0e-5231bf834691.png)
```
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
}
```
	* dto.ResponseDto 생성
![image](https://user-images.githubusercontent.com/86938974/168410866-dff19a7f-8156-4d63-a44d-9379b1a78406.png)

```
package com.cos.blog.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
	int status;
	T data;
	
}

```
	* service.UserService 생성
- repository는 CRUD를 들고 있다면,
- 서비스는 두개 이상의 트랜잭션을 하나로 묶어서 하나의 트랜잭션으로 묶어서 서비스할 수 있다. (ex)송금 서비스는 수신과 송신측 둘 다 업데이트에 성공하고 커밋 해줘야한다.) 
![image](https://user-images.githubusercontent.com/86938974/168411029-302a2953-fe1d-4fbb-b6c4-a0ee3df9797b.png)
```
package com.cos.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();//1234원문
		String encPassword = encoder.encode(rawPassword);//해쉬화
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
}
	
```

* 전통적인 스프링 트랜잭션 순서
	* 톰캣 시작 - 서버 작동
	* web.xml
	* context.xml -> DB 연결 테스트 
	
	* request 요청이 들어오면 web.xml을 실행한다.
	* web.xml에서 DB 연결 세션을 생성하고(JDBC가 커넥션 됨, CRUD 가능)
	* 트랜잭션이 시작된다.
	* 필터를 거쳐 요청분기가 가능한 Controller로 간다. Controller는 요청을 확인하고 요청에 맞는 Service를 호출한다.
	* Service에서는 요청을 확인하고 테이블 두 개를 SELECT 한다. DB에선 A와 B의 계좌 테이블을 영속성 컨텍스트에 객체화 시켜서 만들어놓는다.
	* Service에서 SELECT된 객체를 repository를 거쳐 응답 받아 갖고있는다. 그 후 Service에서 객체 값을 변경한다. (실제 DB에는 반영 안 됨, 영속성 컨텍스트 객체 변경)
	* Controller로 응답 받아서 (RestController는 JSON, Controller는 HTML 리턴) 리턴해준다.
	* Controller에서 응답 해주고 트랜잭션을 종료시켜서 자동으로 영속성 컨텍스트의 값이 변경된 것을 DB에서 변경감지하여 Flush해 집어넣는다. 그리고 DB연결 세션 종료 
![image](https://user-images.githubusercontent.com/86938974/168411525-de5aa808-5a24-4a16-b36e-2372aa933250.png)

* 기존 방식 문제점 개선( ex) 야구 팀 정보 )
	* A가 요청 시 영속성컨텍스트를 시작한다.
	* Controller에서 Service로 요청이 넘어갈 때 JDBC 커넥션, 트랜잭션이 실행된다.
	* Service에서 Controller로 객체를 넘겨줄 때 JDBC, 트랜잭션, 영속성 컨텍스트를 종료한다.
	* 따라서 트랜잭션의 범위가 줄어들고 영속성 컨텍스트로 빨리 끝나 DB의 부하가 줄어든다.
	* 만약 이대호 선수의 정보를 요청하면 Player와 Team은 Many To One이고, Eager 전략에 의해 선수 정보 뿐만 아니라 영속성 컨텍스트에 Team의 정보도 불러와진다.
	* repository에는 이대호선수의 정보에 대한 객체만 저장되고(Eager이므로 롯데 팀 정보도 이대호 객체에 저장되어있음) Service에서 Controller로 넘어가는 시점에 영속성 컨텍스트, JDBC, 트랜잭션이 종료된다.
	* 비 영속성 상태가 되었으므로 Controller에서 이대호선수 정보를 돌려주고 끝난다.
	* LAZY 전략일 경우 영속성 컨텍스트의 1차 캐시에 롯데 팀 정보를 갖고오지 않아 Controller 팀 정보가 필요시 호출이 불가능하다. (영속성 컨텍스트, JDBC, 트랜잭션이 종료 되었기 때문)
	* 그래서 LAZY일 때는 비어있는 롯데 팀 프록시 객체를 들고온다. 이 때는 Controller가 끝날 때 영속성 컨텍스트를 종료하여 필요시 영속성 컨텍스트에 접근해 롯데 팀 프록시 객체를 이용해 JDBC커넥션을 시작하여 롯데 팀 정보를 불러온다.
 	* Controller에서 Select는 가능하지만, 그 정보를 변경해도 변경감지하여 자동으로 수정해주지 않는다. 트랜잭션과 JDBC가 먼저 종료되기 때문


![image](https://user-images.githubusercontent.com/86938974/168411924-1fddb413-7e36-486f-9a42-7ff83f695bf7.png)


* 스프링 시큐리티 로그인
	* pom.xml에 다음 코드 삽입
	* 시큐리티 태그 라이브러리 삽입
```
	<dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-taglibs</artifactId>
	</dependency>
	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
```
![image](https://user-images.githubusercontent.com/86938974/168412235-023d50f2-0e49-4779-87d2-9be65319d6b8.png)
- Maven Dependencies 에서 다운로드 확인
- 다음 코드를 header.jsp 맨 위에 삽입

```
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

	* 시큐리티 라이브러리가 설치되면 홈페이지 어느곳에 접근하던지 스프링 시큐리티가 가로챈다.
	* 자동으로 세션 생성
	* 그 값을 principal에 저장
<!-- 인증이 되었는지 확인 -->
<sec:authorize access="isAuthenticated()">
	<!-- principal = current user object에게 direct access를 허용 -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
```

	* 스프링 시큐리티 로그인 페이지 커스터마이징
- 인증이 안 된 사용자들이 출입할 수 있는 경로들 /auth/** 허용
- 그냥 주소가 / 이면 index.jsp허용
- static이하에 있는 /js/** , /css/**, /image/** 허용
- 허용하는 이유는 로그인과 회원가입시에는 인증을 할 필요가 없기 때문

- UserApiController 다음과 같이 /auth를 앞에 붙여주면 된다.
```
//회원가입 이므로 /auth 붙여서 인증 x
	//왜 /auth/loginProc를 안 만드는지 : SecurityConfig에서 가로채기 때문
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		System.out.println("UserApiController: save 호출됨");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴
		
	}

```

	* config.SecurityConfig 생성
![image](https://user-images.githubusercontent.com/86938974/168412614-944997df-6e18-40b2-8e8d-ca18dc94c4c9.png)
```
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
```

	* 비밀번호 해쉬 후 회원가입
- 위 코드에 다음과 같이 추가
```
@Bean //IoC가 된다.
	//시큐리티가 들고있는 함수
	public BCryptPasswordEncoder encodePWD() {
		//암호화해서 encPassword에 넣어줌
		//	String encPassword = new BCryptPasswordEncoder().encode(null)
		//IoC = 리턴되는 아래 객체를 스프링이 관리한다.
		return new BCryptPasswordEncoder();
	}	
```
- UserService.java에 다음 코드 추가
```
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();//1234원문
		String encPassword = encoder.encode(rawPassword);//해쉬화
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
```
	* config.auth에 다음 파일들 생성
	
![image](https://user-images.githubusercontent.com/86938974/168413127-6948ccfb-61a9-4542-80b0-e76c49876537.png)
- PrincipalDetail.java
```
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

```

- config.SecurityConfig.java에 다음 코드 추가
```
//시큐리티가 대신 로그인해주는데 password를 가로채기 하는데
	//해당 password가 어떤걸로 해쉬가 되어 회원가입이 되었는지 알아야
	//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교 가능
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
```

	



	







