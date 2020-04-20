<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css" />
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
    />

    <!-- 부가적인 테마 -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"
    />

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  </head>
  <body>
    <%@include file="header.jsp"%>
    <div class="btn-group">
      <div class="btn-group">
        <button
          type="button"
          class="btn btn-secondary dropdown-toggle"
          data-toggle="dropdown"
        >
          게시판
        </button>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#" onclick="brd.init();">자유게시판</a>
          <a class="dropdown-item" href="#">게시글등록</a>
        </div>
      </div>
      <div class="btn-group">
        <button
          type="button"
          class="btn btn-secondary dropdown-toggle"
          data-toggle="dropdown"
        >
          회원관리
        </button>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="mm.init();">회원조회</a>
          <a class="dropdown-item" href="#">회원등록</a>
        </div>
      </div>
    </div>
    <hr />

    <section class="section" id="main">
      <div class="container">
        <h1 class="title">Section</h1>
        <h2 class="subtitle">
          A simple container to divide your page into
          <strong>sections</strong>, like the one you're currently reading
        </h2>
      </div>
    </section>

    <%@include file="footer.jsp"%>
    <script src="./lib/jquery-3.4.1.js"></script>
    <script src="./js/board.js"></script>
    <script src="./js/member.js"></script>
    <script src="./js/index.js"></script>
  </body>
</html>
