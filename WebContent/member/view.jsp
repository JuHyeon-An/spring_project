<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">회원 상세보기</div>

	<form name="frm_mm" id="frm_mm" method="post">
		<!-- UI -->
		
    <div class="col-md-3"></div>
    <div class="form-group col-md-6">
      <label for="mId">아이디</label>
      <input type="text" class="form-control" name="mId" value="${vo.mId }"/>
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" name="pwd" value="${vo.pwd }"/>
      <label for="mName">이름</label>
      <input
        type="text"
        class="form-control"
        name="mName"
        placeholder="이름을 입력하세요"
        value="${vo.mName }"
      />
      <label for="mDate">날짜</label>
      <input type="date" class="form-control" name="rDate" value="${vo.rDate }"/>
      <label for="grade">학년</label>
      <select class="form-control" name="grade">
        <option>학년선택</option>
        <option value="1" <c:if test="${vo.grade eq 1 }"> selected</c:if>>1학년</option>
        <option value="2" <c:if test="${vo.grade eq 2 }"> selected</c:if>>2학년</option>
        <option value="3" <c:if test="${vo.grade eq 3 }"> selected</c:if>>3학년</option>
        <option value="4" <c:if test="${vo.grade eq 4 }"> selected</c:if>>4학년</option>
      </select>
      <br />
      <input class="form-control" type="file" name="att" />

      <div class="text-center">
      </div>
    </div>
    <div class="col-md-6"></div>
  </form>
		
		<input type="button" id="btnModify" value="수정"/>
		<input type="button" id="btnDelete" value="삭제"/>
		<input type="button" id="btnFind" value="목록으로"/>
		
		<input type="text" name="findStr" value="${param.findStr }"/>
		<input type="text" name="nowPage" value="${param.nowPage }"/>
		<input type="text" name="serial" value="${param.serial }"/>
</div>
<script>
mm.func();
</script>