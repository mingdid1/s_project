<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
		function readURL(input){
			var file = input.files[0]
			if (file != '') {
				var reader = new FileReader();
				reader.readAsDataURL(file);
				reader.onload = function (e){
					$('#preview').attr('src', e.target.result);
				}
			}
		}
	</script>
</head>
<body>
	<jsp:include page="../default/header.jsp"/>
	
	<h3>글쓰기</h3>
	<form action="writeSave" method="post" enctype="multipart/form-data">
		작성자<br>
		<input type="text" name="id" readonly value="${id}"><hr>
		
		제목<br>
		<input type="text" name="title"><hr>
		
		내용<br>
		<textarea rows="10" cols="100" name="content"></textarea><hr>
		
		이미지파일 첨부<br>
		<input type="file" name="file" onchange="readURL(this);">
		<img id="preview" src="#" width=100 height=100 alt="선택된 이미지가 없습니다"/>
		<hr>
		 
		<input type="submit" value="글작성">
		<input type="button" value="목록보기" onclick="location.href='boardAllList'"> 
	</form>
	
	<jsp:include page="../default/footer.jsp"/>	
</body>
</html>