<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">게시물 상세보기</div>

	<form name="frm_brd" id="frm_brd" method="post">
		<!-- UI -->
		<input type="button" id="btnModify" value="수정"/>
		<input type="button" id="btnDelete" value="삭제"/>
		<input type="button" id="btnRepl" value="답글"/>
		<input type="button" id="btnFind" value="목록으로"/>
		
		<input type="text" name="findStr" value="${param.findStr }"/>
		<input type="text" name="nowPage" value="${param.nowPage }"/>
		<input type="text" name="serial" value="${param.serial }"/>
	</form>
</div>
<script>
brd.func();
</script>