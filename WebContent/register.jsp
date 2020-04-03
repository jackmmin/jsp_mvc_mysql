<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="00_header.jsp"/>
<jsp:include page="10_nav.jsp"/>

<h1 class="mt-5">REGISTER</h1>
<form action="./mCtrl" method="post">
	<input type="hidden" name="sign" value="register">
	
	<div class="form-group">
		<label for="email">Email: </label>
		<input type="email" name="i_email" id="i_email" class="form-control">
		<br><span id="checkResult"></span>
	</div>
	<div class="form-group">
		<label for="pwd">비밀번호: </label>
		<input type="password" name="i_pwd" class="form-control">
	</div>
	<div class="form-group">
		<label for="nick">닉네임: </label>
		<input type="text" name="i_nickname" class="form-control">
	</div>

	<button type="submit" class="btn btn-outline-primary">가입하기</button>
	<button type="reset" class="btn btn-outline-secondary">초기화</button>
	
</form>

<script>
	$(function(){
		$("#i_email").blur(function(){ // blur는 '벗어나면'. 안에를 수행하라
			let email = $("#i_email").val(); // i_email의 값을 email에 저장하라
			console.log("ajax-email: " + email);
			$.ajax({
				url: "./mCtrl",
				type: "post",
				data: {sign: "idCheck", email: email} // json 형식. 자바스크립트 오브젝트 노테이션
			}).done(function(result){
				if(result=='1'){
					$("#checkResult").html("사용할 수 없는 이메일 입니다.").css("color", "#f00");
				}else{
					$("#checkResult").html("사용할 수 있는 이메일 입니다.").css("color", "#0f0");
				}
			}).fail(function(){
				console.log("아이디체크 실패");
			});
		});
	});
</script>

<jsp:include page="90_footer.jsp"/>

<!-- 

ajax? 비동기식으로 자바스크립트 xml 통신( 화면변화는 없지만 데이터는 전송됨 )
ajax은  url로 타입과 데이터를 보내고 다시 받는다.
ajax의 success는 성공하면 수행. reuslt값으로 out.print(isExist)에 의해 값이 날아온다.

-->