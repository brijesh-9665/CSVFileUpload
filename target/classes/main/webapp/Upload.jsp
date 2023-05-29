<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%out.write("Upload The File Here-"); %>
	<form method="post" action="UploadServlet" enctype="multipart/form-data">  
		<input type="File" name="File"><br/>	
		<input type="Submit" name="Submit" value="Upload" >
	</form>
</body>
</html>