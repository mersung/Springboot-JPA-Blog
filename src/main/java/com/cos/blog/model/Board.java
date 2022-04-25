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


