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
	<jsp:include page="../default/header.jsp"/>
	<h3>개인정보</h3>
	<table border="1">
		<tr>
			<th>글 번호</th> <td>${dto.writeNo }</td> 
			<th>작성자</th> <td>${dto.id }</td> 
		</tr>
		<tr>
			<th>제목</th> <td>${dto.title }</td>
			<th>등록일자</th> <td>${dto.saveDate }</td>
		</tr>
		<tr>
			<th>내용</th> <td>${dto.content }</td>
			<td colspan="2">
				<img src="download?file=${dto.imgFileName }" width="100" height="100"><br>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<c:if test="${id == dto.id }">
					<input type="button" value="수정하기" onclick="location.href='modify_form?writeNo=${dto.writeNo }'">
					<input type="button" value="삭제하기" 
					onclick="location.href='delete?writeNo=${dto.writeNo }&file=${dto.imgFileName }'">
				</c:if>
				<input type="button" value="답글달기">
				<input type="button" value="리스트로 돌아가기" onclick="location.href='boardAllList'">
			</td>
		</tr>
	</table>
	
	<jsp:include page="../default/footer.jsp"/>	
</body>
</html>