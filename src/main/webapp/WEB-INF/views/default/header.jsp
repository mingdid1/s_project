<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>CARE LAB</h1>
		<hr>
		session id: ${id }<hr>
		
		<a href="index">HOME</a>
		<c:choose>
			<c:when test="${id == null}">
				<a href="login">회원 정보</a>
				<a href="login">LOGIN</a>
			</c:when>		
			<c:otherwise>
				<a href="memberInfo">회원 정보</a>
				<a href="logout">LOGOUT</a>
			</c:otherwise>
		</c:choose>
		<hr>
			
</body>
</html>