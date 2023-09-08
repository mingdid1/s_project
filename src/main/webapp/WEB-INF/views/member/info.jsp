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
	
	<h3>${dto.id} 정보</h3>
	아이디 : ${dto.id }<br>
	비밀번호 : ${dto.pw }<br>
	주소: ${dto.addr }<br>
	
	<jsp:include page="../default/footer.jsp"/>

</body>
</html>