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




	




	



	







