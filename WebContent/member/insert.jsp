<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div class="container text-center">
		<h3>회원 등록</h3>
	</div>
	<form name="frm_mm" id="frm_mm" method="post" class="row">
		<div class="col-md-3"></div>
		<div class="form-group col-md-6">
			<label for="mId">아이디</label> <input type="text" class="form-control"
				id="mId" /> <label for="pwd">비밀번호</label> <input type="pwd" 
				class="form-control" id="pwd" /> <label for="mName">이름</label> <input
				type="text" class="form-control" id="mName" placeholder="이름을 입력하세요" />
			<label for="mDate">날짜</label> <input type="date" class="form-control"
				id="mDate" /> <br />
			<div class="text-center">
				<input type="button" class="btn btn-secondary" id="btnRegister"
					value="저장" /> <input type="button" class="btn btn-secondary"
					id="btnFind" value="취소" />

			</div>
			<input type="text" name="findStr" value="${param.findStr }" /> <input
				type="text" name="nowPage" value="${param.nowPage }" /> <input
				type="text" name="serial" value="${param.serial }" />
		</div>
		<div class="col-md-6"></div>

</form>
</div>
<script>
  mm.func();
</script>
