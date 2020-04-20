<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">결과</div>
	${msg }
	
	<form name="frm_mm" id="frm_mm" method="post">
	<!-- UI -->
		<input type="button" id="btnFind" value="목록으로"/>
		
		<input type="text" name="findStr" value="${param.findStr }"/>
		<input type="text" name="nowPage" value="${param.nowPage }"/>
	</form>

</div>
<script>
mm.func();
</script>