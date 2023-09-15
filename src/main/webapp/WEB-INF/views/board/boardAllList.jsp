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
	
	<h3>게시판</h3>
	<table border="1">
		<tr>
			<th>번호</th> <th>id</th> <th>제목</th>
			<th>날짜</th> <th>조회수</th> <th>image_file_name</th> 
		</tr>
		
		<c:if test="${list == null }">
			<tr>
				<td colspan="6">등록된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${list != null}">
			<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.writeNo }</td>
					<td>${list.id }</td>
					<td>
						<a href="contentView?writeNo=${list.writeNo }">
							${list.title }
						</a>
					</td>
					<td>${list.saveDate }</td>
					<td>${list.hit }</td>
					<td>${list.imgFileName }</td>
				</tr>
			</c:forEach>
		</c:if>
			
		<tr>
			<td colspan="6">
				<a href="writeForm">글 작성</a>			
			</td>
		</tr>
	</table>
	
	<jsp:include page="../default/footer.jsp"/>	
</body>
</html>