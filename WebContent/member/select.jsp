<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member">
	<div id="header">회원조회</div>

	<form name="frm_mm" id="frm_mm" method="post">
		<input type="button" value="입력" id="btnInsert" />
		<input type="text" name="findStr" value="${param.findStr }"/>
		<input type="button" value="검색" id="btnFind" />
		<input type="text" name="nowPage" value="${param.nowPage }"/>
		<input type="text" name="serial" value="${param.serial }"/>
	</form>

	<!-- title -->
	<div class="title"></div>
		<span class="no">NO</span>
		<span class="subject">제목</span>
		<span class="id">작성자</span>
		<span class="mDate">작성일</span>
		<span class="hit">조회수</span>
	
	<!-- list -->
	<div class="list">
		<c:forEach var="i" begin="1" end="10">
			<div class="items" onclick="mm.view(${i})">
				<span class="no">${i }</span>
				<span class="subject">제목${i }</span>
				<span class="id">작성자${i }</span>
				<span class="mDate">작성일${i }</span>
				<span class="hit">조회수${i }</span>
			</div>
		</c:forEach>
	</div>
	<div id="paging">
		<input type="button" value="이전" onclick="mm.go(1)" />
		<c:forEach var="i" begin="1" end="10">
			<input type="button" value="${i }" onclick="mm.go(${i})" />
		</c:forEach>
		<input type="button" value="다음" onclick="mm.go(11)" />
	</div>
</div>
<script>
mm.func();
</script>