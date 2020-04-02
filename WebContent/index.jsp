<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pg" value="${param.pg}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.4.1.js"></script>
</head>
<body>
	<h1>여기가 인덱스 페이지입니다.</h1>
	<form action="./mCtrl" method="post">
		<input type="hidden" name="sign" value="register">
		<table border="1">
			<tr>
				<td colspan="2">
					<h3>회원가입</h3>
				</td>
			</tr>
			<tr><!-- 한 줄 -->
				<td>email</td><!-- 한  칸 -->
				<td><input type="email" name="i_email"></td>
				<!-- name은 실제 전달되는 데이터를 식별한다. 같은 폼태그 안에서 절대 중복되면 안된다.-->
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="i_pwd"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="i_nickname"></td>
			</tr>
			
			<tr><td colspan="2">
				<input type="submit" value="가입하기">
				<input type="reset" value="초기화">
			</td></tr>
		</table>
	</form>
		<script>
		$(function(){
			let msg = '${param.pg}';
			if (msg=='wc') {
				alert("회원가입을 축하드립니다.");
			}
		});
	</script>
	
</body>
</html>

<!--

c:set은 MemberCtrl의 ("index.jsp?pg=wc"); 을 받아오기 위해 작성.
input의 name="sign" 을 통해 java에서 접근하고 값은 value="register"를 갖는다.

-->