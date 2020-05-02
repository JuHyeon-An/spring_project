<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header"><h3 class="text-center">게시물 입력</h3></div>
	<form name="frm_brd" id="frm_brd" method="post" enctype="multipart/form-data" class="row">
	<!-- UI -->
		
		<div class="col-md-1"></div>
		<div class="form-group col-md-10">
			<label for="mId">${sessionScope.mId }</label>
			<input type="text" class="form-control"
				id="mId" name="id"/> 
				<input type="text" name="pwd">
				
				<label for="subject">제목</label> <input
				type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요" />
				
			<label for="content">내용</label>
			
			<textArea id="summernote" name="content">들어갔나요</textArea>
			
			<div class="text-center mt-3">
				<input type="button" class="btn btn-secondary" id="btnRegister"
					value="저장" /> <input type="button" class="btn btn-secondary"
					id="btnFind" value="취소" />

			</div>
			<input type="file" name="att" id="btnAtt" multiple/>

			<div id="attList"></div>

			<input type="text" name="findStr" value="${param.findStr }" />
			<input type="text" name="nowPage" value="${param.nowPage }" />
			<input type="text" name="serial" value="${param.serial }" />
		
		
		</div>
		<div class="col-md-1"></div>

		

	</form>

</div>
<script>
brd.func();

</script>