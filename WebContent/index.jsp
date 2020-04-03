<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pg" value="${param.pg}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script src="resources/bootstrap/js/jquery-3.4.1.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="mt-5">REGISTER</h1>
		<form action="./mCtrl" method="post">
			<input type="hidden" name="sign" value="register">

			<div class="form-group">
				<label for="email">Email: </label> <input type="email"
					name="i_email" id="i_email" class="form-control"> <br>
				<span id="checkResult"></span>
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호: </label> <input type="password" name="i_pwd"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="nick">닉네임: </label> <input type="text" name="i_nickname"
					class="form-control">
			</div>

			<button type="submit" class="btn btn-outline-primary">가입하기</button>
			<button type="reset" class="btn btn-outline-secondary">초기화</button>

		</form>
	</div>

</body>
</html>

<!--

c:set은 MemberCtrl의 ("index.jsp?pg=wc"); 을 받아오기 위해 작성.
input의 name="sign" 을 통해 java에서 접근하고 값은 value="register"를 갖는다.

-->