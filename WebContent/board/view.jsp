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
		
		<input type="text" value="${vo.serial}"/>
		<input type="text" value="${vo.id}"/>
		<input type="text" value="${vo.subject}"/>
		<div class="form-control" style="min-height:400px;" contenteditable="true">${vo.content }</div>
		<input type="text" value="${vo.mDate}"/>
		<input type="text" name="pwd">
		
		
		<input type="text" name="findStr" value="${p.findStr }"/>
		<input type="text" name="nowPage" value="${p.nowPage }"/>
		<input type="text" name="serial" value="${vo.serial }"/>
	</form>
	
	<fieldset><legend>[첨부된 파일]</legend></fieldset>
	<c:forEach var="i" items="${attList }">
		<div>
			<span>첨부된 파일 ${i.sysFile }</span>
		</div>
	</c:forEach>
	
</div>
<script>
brd.func();

</script>