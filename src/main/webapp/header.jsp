<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.headerr{ list-style: none ; 
		padding: 20px;
		display: flex;	
		border-bottom: 3px solid gray;
		width: 100%;
	}
	.he { 	padding: 20px; 	}
	a#a { 	text-decoration: none; 	}
	hr { border: 3px solid gray;}
</style>
</head>
<body>
	<ul class="headerr">
		<li class="he"><a href="${pageContext.request.contextPath }/index.jsp" id="a">Home</a></li>
		<li class="he"><a href="${pageContext.request.contextPath }/customer/join" id="a">고객 등록</a></li>
		<li class="he"><a href="${pageContext.request.contextPath }/customer/list" id="a">고객 목록</a></li>
		<li class="he"><a href="${pageContext.request.contextPath }/products" id="a">상품 관리</a></li>
		<li class="he"><a href="${pageContext.request.contextPath }/buys" id="a">판매 관리</a></li>
	</ul>
</body>
</html>