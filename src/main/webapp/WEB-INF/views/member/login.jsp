<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../default/header.jsp"/>
	
		<h3>로그인 페이지 입니다</h3>
		
		<form action="login_chk" method="post">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pw" placeholder="비밀번호">
			<input type="submit" value="login">
		</form>
		
		<a href="register">회원가입</a>
		
	<jsp:include page="../default/footer.jsp"/>
	
</body>
</html>