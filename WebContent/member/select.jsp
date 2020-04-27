<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="member_select" class="container">
	<div id="header" class="h3">회원조회</div>

	<form name="frm_mm" id="frm_mm" method="post">
		<div class="row">
			<div class="col-md-3">
			  <input type="button" class="btn btn-secondary" id="btnEnroll" value="회원등록"/>
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
		<c:forEach var="i" items="${list }">
			<div class="card text-center"
				style="width: 270px; float: left; align-items: center;">
					<c:if test="${fn:length(i.photos) == 0}">
						<img class="card-img-top mt-3" src="./images/queen.png"
							alt="Card image" style="width: 50%; height: 50%;">
					</c:if>
					<c:if test="${fn:length(i.photos) > 0}">
						<c:forEach var="j" items="${i.photos }">
							<img class="card-img-top mt-3" src="./member_photo/${j.sysFile }"
								alt="Card image" style="width: 50%; height: 50%;">
						</c:forEach>
					</c:if>
				<div class="card-body">
					<h5 class="card-title">${i.mName}</h5>
					<p class="card-text">${i.mId}</p>
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