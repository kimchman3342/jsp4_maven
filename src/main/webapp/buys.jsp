<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 구매내역 조회</title>
<link rel="stylesheet" href="assets/css/all.css">
</head>
<body>
	<h3>전체 구매내역 조회</h3>
	<div class="search">
	<!-- form action 이 없을 때 동작은? 자기자신 url 입니다.  method 기본값은 GET -->
		<form>
		<button id="selectAll" type="button">전체보기</button>
		</form>
	</div>
	<hr>
	<ul id="list">
		
	</ul>	
	<!-- temp 변수값은 search.js 와 공유합니다. -->
	
	<script type="text/javascript" src="assets/js/buyApi_list.js"></script>
</body>
</html>








