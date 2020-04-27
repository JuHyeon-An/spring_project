<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
  <div class="container text-center">
    <h3>회원 등록</h3>
  </div>
  <form name="frm_mm" id="frm_mm" method="post" class="row" enctype="multipart/form-data">
    <div class="col-md-3"></div>
    <div class="form-group col-md-6">
      <label for="mId">아이디</label>
      <input type="text" class="form-control" name="mId" value="혀니"/>
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" name="pwd" value="1234"/>
      <label for="mName">이름</label>
      <input
        type="text"
        class="form-control"
        name="mName"
        placeholder="이름을 입력하세요"
        value="주현"
      />
      <label for="mDate">날짜</label>
      <input type="date" class="form-control" name="rDate" value="2020-04-27"/>
      <label for="grade">학년</label>
      <select class="form-control" name="grade">
        <option>학년선택</option>
        <option value="1" selected>1학년</option>
        <option value="2">2학년</option>
        <option value="3">3학년</option>
        <option value="4">4학년</option>
      </select>
      <br />
      <input class="form-control" type="file" name="att" />

      <div class="text-center">
        <input
          type="button"
          class="btn btn-secondary"
          id="btnRegister"
          value="저장"
        />
        <input
          type="button"
          class="btn btn-secondary"
          id="btnFind"
          value="취소"
        />
      </div>
      <input type="text" name="findStr" value="${param.findStr }" />
      <input type="text" name="nowPage" value="${param.nowPage==null? 1 : param.nowPage }" />
      <input type="text" name="serial" value="${param.serial }" />
    </div>
    <div class="col-md-6"></div>
  </form>
</div>
<script>
  mm.func();
</script>
