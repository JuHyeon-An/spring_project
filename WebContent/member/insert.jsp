<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">회원 등록</div>
	<form name="frm_mm" id="frm_mm" method="post">
	<!-- UI -->
		<input type="button" id="btnRegister" value="저장"/>
		<input type="button" id="btnFind" value="취소"/>
		
		<input type="text" name="findStr" value="${param.findStr }"/>
		<input type="text" name="nowPage" value="${param.nowPage }"/>
		<input type="text" name="serial" value="${param.serial }"/>
	</form>

</div>
<script>
mm.func();
</script>