<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
  <div id="index-header" class="jumbotron text-center" style="margin-bottom: 0;">
      <c:choose>
      	<c:when test="${empty sessionScope.mId }">
      <span id="login-link"><span onclick="goLogin();">로그인 </span></span>
      	</c:when>
      	<c:otherwise>
      		<span id="login-link">${sessionScope.mId }님 환영합니다. </span>
		    <span id="logout-link"><span onclick="logout();">로그아웃</span></span>
      	</c:otherwise>
      </c:choose>
      
      <h1>나의 봄...</h1>
      <p>다시 찾아온 봄.. 그 두번째 이야기..</p>
    </div>
    
</body>
