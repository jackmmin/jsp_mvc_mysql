<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="unick" value="${nickname}" scope="session" />
<c:set var="uemail" value="${email}" scope="session" />
<c:set var="ugrade" value="${grade}" scope="session" />
<jsp:include page="/include/00_header.jsp" />
<jsp:include page="/include/10_nav.jsp" />

<h2>상품 리스트</h2>
<c:if test="${uemail != null && uemail != ''}"><a href="upload.jsp" class="btn btn-primary">상품등록</a></c:if>
  <table class="table table-hover">
    <thead>
    
      <tr>
        <th>상품번호</th>
        <th>카테고리</th>
        <th>상품명</th>
        <th>등록자</th>
        <th>조회수</th>
        <th>최종등록일</th>
      </tr>
      
    </thead>
    <tbody>
    <c:forEach items="${list}" var="pvo">
      <tr>
        <td>${pvo.pno}</td>
        <td>${pvo.category}</td>
        <td><a href="./pCtrl?sign=detail&pno=${pvo.pno}">${pvo.pname}</a></td>
        <td>${pvo.pwriter}</td>
        <td>${pvo.readcount}</td>
        <td>${pvo.moddate}</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>

<jsp:include page="/include/90_footer.jsp"/>
