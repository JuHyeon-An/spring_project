<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member">
<form name="frm_mm" id="frm_mm" method="post" class="row">
		<div class="col-md-3"></div>
		<div class="form-group col-md-6">
		<div id="header" class="h3">로그인</div>
			<label for="mId">아이디</label>
			<input type="text" name="mId" class="form-control"
				id="mId" /> <label for="pwd">비밀번호</label> <input type="password" 
				class="form-control" id="pwd" name="pwd"/> <br/>
			<div class="text-center">
				<input type="button" class="btn btn-secondary" id="btnLogin"
					value="로그인" /> <input type="button" class="btn btn-secondary"
					id="btnCancel" value="취소" onclick="location.href='index.jsp';"/>

			</div>
		</div>
		<div class="col-md-6"></div>

</form>

</div>
<script>
mm.func();
</script>