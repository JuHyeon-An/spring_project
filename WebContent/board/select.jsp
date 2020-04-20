<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">게시물 검색</div>

	<form name="frm_brd" id="frm_brd" method="post">
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
			<div class="items" onclick="brd.view(${i})">
				<span class="no">${i }</span>
				<span class="subject">제목${i }</span>
				<span class="id">작성자${i }</span>
				<span class="mDate">작성일${i }</span>
				<span class="hit">조회수${i }</span>
			</div>
		</c:forEach>
	</div>
	<div id="paging">
		<input type="button" value="이전" onclick="brd.go(1)" />
		<c:forEach var="i" begin="1" end="10">
			<input type="button" value="${i }" onclick="brd.go(${i})" />
		</c:forEach>
		<input type="button" value="다음" onclick="brd.go(11)" />
	</div>
</div>
<script>
brd.func();
</script>