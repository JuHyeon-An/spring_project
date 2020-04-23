<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member" class="container">
	<div id="header" class="h3">회원조회</div>

	<form name="frm_mm" id="frm_mm" method="post">
		<div class="row">
			<div class="col-md-3">
			  <button class="btn btn-secondary" id="btnInsert">회원등록</button>
			</div>
			
			<div class="col-md-5"></div>
		  
			<div class="input-group mb-3 col-md-3">
			  <input
				type="text"
				class="form-control"
				placeholder="회원명을 입력하세요"
				aria-describedby="btnFind"
				name="findStr"
				value="${param.findStr}"
			  />
			  <div class="input-group-append">
				  <button class="btn btn-secondary" type="button" id="btnFind">
					  검색
					</button>
				</div>
			</div>
			</div>
	</form>

	<!-- list -->
	<div class="list row">
		<c:forEach var="i" begin="1" end="10">
			<div class="card text-center" style="width:270px; float: left; align-items: center;">
				<img class="card-img-top mt-3" src="./images/queen.png" alt="Card image" style="width: 50%; height: 50%;">
				<div class="card-body">
				  <h5 class="card-title">이름${i}</h5>
				  <p class="card-text">id${i}</p>
				  <a href="#" class="btn btn-outline-secondary">See Profile</a>
				</div>
			  </div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
	<div class="col-md-6">
		<ul class="pagination justify-content-center mt-5">
		  <li class="page-item disabled">
			<a
			  class="page-link"
			  href="#"
			  tabindex="-1"
			  aria-disabled="true"
			  onclick="brd.go(1)"
			  >이전</a
			>
		  </li>
		  <c:forEach var="i" begin="1" end="10">
			<li class="page-item">
			  <a class="page-link" href="#" onclick="brd.go(${i})">${i}</a>
			</li>
		  </c:forEach>
		  <li class="page-item">
			<a class="page-link" href="#" onclick="brd.go(11)">다음</a>
		  </li>
		</ul>
	  </div>
	  <div class="col-md-3"></div>
	</div>
</div>
<script>
mm.func();
</script>