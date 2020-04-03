<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="unick" value="${nickname}" scope="session"/>
<c:set var="uemail" value="${email}" scope="session"/>
<c:set var="ugrade" value="${grade}" scope="session"/>

<jsp:include page="00_header.jsp"/>
<jsp:include page="10_nav.jsp"/>

<div class="jumbotron">
    <h1>JM 쇼핑몰에 오신 것을 환영합니다.</h1>      
  </div>
  <p>별다른 기능이 없습니다.</p>      
  <p>기능구현 후 수정될 예정입니다.</p>  

<script>
	$(function(){
		let msg = '${param.pg}';
		if (msg=='wc') {
			alert("회원가입을 축하드립니다.");
		}else if(msg=='ls'){
			alert("로그인 되었습니다.");
		}else if(msg=='bye'){
			alert("로그아웃 되었습니다.")
		}
	});
</script>
<jsp:include page="90_footer.jsp"/>

<!-- 

jsp:include 내용들은 항상 있어야한다.
c:.....에서 var는 날아온 value 값을 var의 변수값으로 여기에서 사용하겠다는 의미
git commit -m "separate header, footer, navigation"
 -->