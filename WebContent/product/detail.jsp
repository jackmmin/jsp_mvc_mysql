<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="unick" value="${nickname}" scope="session"/>
<c:set var="uemail" value="${email}" scope="session"/>
<c:set var="ugrade" value="${grade}" scope="session"/>
<jsp:include page="../include/00_header_product.jsp"/>
<jsp:include page="../include/10_nav.jsp"/>

<body>
	<div class="container">

	<div>
		<%-- <h1>${pvo.pno}</h1> --%>
		<h1>안녕하세요 detail 입니다.</h1>
	</div>

<jsp:include page="/include/90_footer.jsp"/>