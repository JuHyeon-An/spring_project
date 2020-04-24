<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board" class="container">
  <div id="header"><h3>게시물 검색</h3></div>

  <!-- title -->
  <div class="title row mt-3 mb-2">
    <span class="no col-md-1">NO</span>
    <span class="subject col-md-4">제목</span>
    <span class="id col-md-3">작성자</span>
    <span class="mDate col-md-2">작성일</span>
    <span class="hit col-md-1">조회수</span>
  </div>

  <!-- list -->
  <div class="list">
    <c:forEach var="i" items="${list }">
      <div class="items row mb-2" onclick="brd.view(${i.serial})">
        <span class="no col-md-1">${i.serial }</span>
        <span class="subject col-md-4">${i.subject }</span>
        <span class="id col-md-3">${i.id }</span>
        <span class="mDate col-md-2">${i.mDate }</span>
        <span class="hit col-md-1">${i.hit }</span>
      </div>
    </c:forEach>
  </div>

  <div class="row">
    <div class="col-md-3 mt-5">
      <button class="btn btn-outline-secondary" id="btnInsert">글쓰기</button>
    </div>
    <div class="col-md-6">
      <ul class="pagination justify-content-center mt-5">
        <li class="page-item ${(p.startPage>p.blockSize)? '' : 'disabled' }">
          <a
            class="page-link"
            href="#"
            tabindex="-1"
            aria-disabled="true"
            onclick="brd.go(${p.startPage-1})"
            >이전</a
          >
        </li>
        <c:forEach var="i" begin="${p.startPage }" end="${p.endPage }">
          <li class="page-item ${(i==p.nowPage)? 'active' : '' }">
            <a class="page-link" href="#" onclick="brd.go(${i})">${i}</a>
          </li>
        </c:forEach>
        <li class="page-item ${(p.endPage<p.totPage)? '' : 'disabled' }">
          <a class="page-link" href="#" onclick="brd.go(${p.endPage+1})">다음</a>
        </li>
      </ul>
    </div>
    <div class="col-md-3"></div>
  </div>
  <form name="frm_brd" id="frm_brd" method="post" class="row">
    <div class="col-md-4"></div>
    <div class="input-group mb-3 col-md-4 mt-3">
      <input
        type="text"
        class="form-control"
        placeholder="검색어를 입력하세요"
        aria-describedby="btnFind"
        name="findStr"
        value="${p.findStr}"
      />

      <div class="input-group-append">
        <button class="btn btn-outline-secondary" type="button" id="btnFind">
          검색
        </button>
      </div>
    </div>
    <div class="col-md-4"></div>
    <input type="text" name="nowPage" value="${p.nowPage }" />
    <input type="text" name="serial" value="${param.serial }" />
  </form>
</div>

<script>
  brd.func();
</script>
