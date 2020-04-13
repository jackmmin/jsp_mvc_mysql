<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center mb-5">
  <ul class="navbar-nav">
    <li class="nav-item"><a class="nav-link" href="../pCtrl?sign=list">Product</a></li>
    
    <c:choose>
    	<c:when test="${uemail != '' && uemail != null}">
    		<li class="nav-item"><a class="nav-link" href="#">
				${unick}&nbsp; (${uemail})&nbsp;  
				<c:choose>
					<c:when test="${ugrade == '0'}">일반회원</c:when>
					<c:when test="${ugrade == '10'}">우수회원</c:when>
					<c:when test="${ugrade == '20'}">골드회원</c:when>
					<c:when test="${ugrade == '30'}">다이아회원</c:when>
					<c:when test="${ugrade == '50'}">VIP회원</c:when>
					<c:when test="${ugrade == '70'}">매니저</c:when>
					<c:when test="${ugrade == '99'}">관리자</c:when>
				</c:choose>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="../mCtrl?sign=logout">Logout</a></li>
    	</c:when>
    	
    	<c:otherwise>
			<li class="nav-item"><a class="nav-link" href="../login.jsp">Login</a></li>
    		<li class="nav-item"><a class="nav-link" href="../register.jsp">Register</a></li>    		
    	</c:otherwise>
    </c:choose>
    
  </ul>
</nav>
