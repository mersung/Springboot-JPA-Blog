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

*의존성 설정

![image](https://user-images.githubusercontent.com/86938974/166133777-6e7d5653-ab2b-4301-bc11-b48198161cf4.png)

체크목록

-Developer Tools
  -Spring Boot DevTools (파일이 프로젝트 내에서 체인지 될 때, 변경이 일어났으니 자동 재시작)
  -Lombok(게터세터, 생성자를 어노테이션을 통해 자동으로 생성해주는 라이브러리)
	
-SQL
  -Spring Data JPA(데이터베이스를 JPA를 통해 만듦 = ORM)
  MySQL Driver
	
-Security
  -Spring Security(보안 기능에 대한 라이브러리)
	
-Web
  -Spring Web(어노테이션을 쓰기 위해서 체크함, 내장형 컨테이너로 톰캣을 기본 탑재)
	
![image](https://user-images.githubusercontent.com/86938974/166133959-26fed241-57bc-48fd-8141-c58e20255551.png)

pom.xml에 추가해준다.

![image](https://user-images.githubusercontent.com/86938974/166134087-ceafe5ef-8e3f-4633-94c5-1ffe382c89c2.png)





