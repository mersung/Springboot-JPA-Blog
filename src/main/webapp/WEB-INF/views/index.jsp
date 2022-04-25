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



