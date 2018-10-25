<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #E3EDCD;
}
.content {
	width: 60%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="content">
		<p>欢迎来到这里 请点击下列入口进入</p>
		<a href="${pageContext.request.contextPath}/queryindex.handler">学生入口</a>
		<br> <a
			href="${pageContext.request.contextPath}/resultable.handler">教师入口</a>
	</div>
</body>
</html>