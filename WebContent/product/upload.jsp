<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="unick" value="${nickname}" scope="session"/>
<c:set var="uemail" value="${email}" scope="session"/>
<c:set var="ugrade" value="${grade}" scope="session"/>
<jsp:include page="../include/00_header_product.jsp"/>
<jsp:include page="../include/10_nav_product.jsp"/>

<h1 class="mt-5">상품 등록</h1>

<form action="../pCtrl" method="post">
	<input type="hidden" name="sign" value="upload">
	
    <div class="form-group">
    	<label for="pname">상품명: </label>
    	<input type="text" class="form-control" id="pname" name="i_pname">
    </div>
    
    <div class="form-group">
    	<label for="category">카테고리 선택: </label>
    	<select class="form-control" name="i_category" id="category">
    		<option value="">선택하세요</option>
			<option value="상의">상의</option>
			<option value="하의">하의</option>
			<option value="아우터">아우터</option>
			<option value="후드티">후드티</option>
			<option value="신발">신발</option>
			<option value="기타">기타</option>
		</select>
    </div>
    
    <div class="form-group">
    	<label for="pwriter">등록자: </label>
    	<input type="text" id="pwriter" name="i_pwriter" class="form-control"  value="${uemail}" readonly>
    </div>
    
    <div class="form-group">
    	<label for="imgfile">이미지 첨부: </label>
    	<input type="text" id="imgfile" name="i_imgfile" class="form-control" value="NONE" readonly>
    </div>
    
    <div class="form-group">
    	<label for="content">상세설명: </label>
    	<textarea class="form-control" rows="5" id="content" name="i_content"></textarea>
    </div>
    
	<button type="submit" class="btn btn-outline-primary">등록하기</button>
	<button type="reset" class="btn btn-outline-secondary">초기화</button>

</form>

<jsp:include page="../include/90_footer.jsp"/>