<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
.position {
	width: 80%;
	height: 600px;
	margin: 0 auto;
}

body {
	background-color: #E3EDCD;
}
</style>

</style>
</head>
<body>
	<div class="position">
		<table border="1" width="80%" height="100%" align="center">
			<tr>
				<th>总计:${requestScope.allCount}人</th>
				<th>(A)在听课 学的还可以</th>
				<th>(B)在听课 学的一般</th>
				<th>(C)在听课，但听不很懂</th>
				<th>(D)没听课,课程本身没意思</th>
				<th>(E)没听课，感觉课程将来没用</th>
				<th>总计:在听课百分比(A,B,C)</th>
				<th>总计:没听课百分比(D,E)</th>
			</tr>
			<tr>
				<td style="font-weight: bold">JavaEE的SSM框架课</td>
				<c:forEach items="${requestScope.resultCount.one}" var="tem">
					<td>${tem}</td>
				</c:forEach>
			</tr>
			<tr>
				<td style="font-weight: bold">Oracle数据库</td>
				<c:forEach items="${requestScope.resultCount.two}" var="tem">
					<td>${tem}</td>
				</c:forEach>
			</tr>
			<tr>
				<td style="font-weight: bold">计算机网络课程</td>
				<c:forEach items="${requestScope.resultCount.three}" var="tem">
					<td>${tem}</td>
				</c:forEach>
			</tr>
			<tr>
				<td style="font-weight: bold">软件工程导论课</td>
				<c:forEach items="${requestScope.resultCount.four}" var="tem">
					<td>${tem}</td>
				</c:forEach>
			</tr>
			<tr>
				<td style="font-weight: bold">企业项目实战课</td>
				<c:forEach items="${requestScope.resultCount.five}" var="tem">
					<td>${tem}</td>
				</c:forEach>
			</tr>

		</table>
		<a href="${pageContext.request.contextPath}/deleteAllData.handler">删除数据
			完成调查</a>
		<br>
		<a href="${pageContext.request.contextPath}/putExcel.handler">导出excel</a>
			
	</div>


</body>
</html>