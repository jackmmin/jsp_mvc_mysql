<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/include/00_header.jsp"/>
<jsp:include page="/include/10_nav.jsp"/>

<h1 class="mt-5">LOGIN</h1>
<form action="./mCtrl" method="post">
	<input type="hidden" name="sign" value="login">
	
	<div class="form-group">
		<label for="email">Email: </label>
		<input type="email" name="i_email" id="i_email" class="form-control">
		<br><span id="checkResult"></span>
	</div>
	<div class="form-group">
		<label for="pwd">비밀번호: </label>
		<input type="password" name="i_pwd" class="form-control">
	</div>

	<button type="submit" class="btn btn-outline-primary">로그인하기</button>
	<button type="reset" class="btn btn-outline-secondary">초기화</button>
	
</form>

<jsp:include page="/include/90_footer.jsp"/>

<!-- 

ajax? 비동기식으로 자바스크립트 xml 통신( 화면변화는 없지만 데이터는 전송됨 )
ajax은  url로 타입과 데이터를 보내고 다시 받는다.
ajax의 success는 성공하면 수행. reuslt값으로 out.print(isExist)에 의해 값이 날아온다.

-->