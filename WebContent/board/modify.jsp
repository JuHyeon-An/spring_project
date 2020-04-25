<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">게시물 수정하기</div>

	<form name="frm_brd" id="frm_brd" method="post" enctype="multipart/form-data">
		<!-- UI -->
		<input type="button" id="btnUpdate" value="수정"/>
		<input type="button" id="btnDelete" value="삭제"/>
		<input type="button" id="btnFind" value="목록으로"/>
		
		<input type="text" name="serial" value="${vo.serial}"/>
		<input type="text" name="id" value="${vo.id}"/>
		<input type="text" name="subject" value="${vo.subject}"/>
		<div class="form-control" style="min-height:400px;" contenteditable="true">${vo.content }</div>
		<input type="text" name="mDate" value="${vo.mDate}"/>
		<input type="text" name="pwd">
		<textArea name="content">${vo.content }</textArea>
		
		<input type="text" name="findStr" value="${p.findStr }"/>
		<input type="text" name="nowPage" value="${p.nowPage }"/>
		<input type="text" name="serial" value="${vo.serial }"/>
	
	<fieldset><legend>[첨부된 파일]</legend></fieldset>
			<input type="file" name="attList" id="btnAtt"/>
	<c:forEach var="i" items="${attList }">
		<div>
			<span id="fileList">${i.oriFile }</span>
			<input type="checkbox" name="delFile" value="${i.sysFile }"
						onclick="delCheck(this)" />
			
		</div>
	</c:forEach>
	</form>
	
</div>
<script>
brd.func();

</script>