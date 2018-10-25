<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<style type="text/css">
	body{
		background-color: #E3EDCD;
	}
	.content{
		width:60%;
		margin: 0 auto; 
	}
	
</style>
</head>
<body>
	<h3 align="center">学生课程在线评测</h3>
	<div class="content">
		<form
			action="${pageContext.request.contextPath}/submitsuccess.handler"
			method="post">

			<div>
				<h4>请选择其中的一项</h4>
				<ol>
					<li><span>你的JavaEE的SSM框架学习情况:()</span>
						<div>
							<input type="radio" name="one" value="A" checked="checked">(A)在听课学的还可以
						</div>
						<div>
							<input type="radio" name="one" value="B">(B)在听课 学的一般
						</div>
						<div>
							<input type="radio" name="one" value="C">(C)在听课，但听不很懂
						</div>
						<div>
							<input type="radio" name="one" value="D">(D)没听课,课程本身没意思
						</div>
						<div>
							<input type="radio" name="one" value="E">(E)没听课，感觉课程将来没用
						</div></li>
					<br />
					<br />
					<br />
					<li><span>你的Oracle数据库课程学习情况:()</span>
						<div>
							<input type="radio" name="two" value="A" checked="checked">(A)在听课学的还可以
						</div>
						<div>
							<input type="radio" name="two" value="B">(B)在听课 学的一般
						</div>
						<div>
							<input type="radio" name="two" value="C">(C)在听课，但听不很懂
						</div>
						<div>
							<input type="radio" name="two" value="D">(D)没听课,课程本身没意思
						</div>
						<div>
							<input type="radio" name="two" value="E">(E)没听课，感觉课程将来没用
						</div></li>
					<br />
					<br />
					<br />
					<li><span>你的计算机网络课程学习情况:()</span>
						<div>
							<input type="radio" name="three" value="A" checked="checked">(A)在听课学的还可以
						</div>
						<div>
							<input type="radio" name="three" value="B">(B)在听课 学的一般
						</div>
						<div>
							<input type="radio" name="three" value="C">(C)在听课，但听不很懂
						</div>
						<div>
							<input type="radio" name="three" value="D">(D)没听课,课程本身没意思
						</div>
						<div>
							<input type="radio" name="three" value="E">(E)没听课，感觉课程将来没用
						</div></li>
					<br />
					<br />
					<br />
					<li><span>你的软件工程导论课程学习情况:()</span>
						<div>
							<input type="radio" name="four" value="A" checked="checked">(A)在听课学的还可以
						</div>
						<div>
							<input type="radio" name="four" value="B">(B)在听课 学的一般
						</div>
						<div>
							<input type="radio" name="four" value="C">(C)在听课，但听不很懂
						</div>
						<div>
							<input type="radio" name="four" value="D">(D)没听课,课程本身没意思
						</div>
						<div>
							<input type="radio" name="four" value="E">(E)没听课，感觉课程将来没用
						</div></li>
					<br />
					<br />
					<br />

					<li><span>你的毛泽东思想和中国特色社会主义理论体系概论:()</span>
						<div>
							<input type="radio" name="five" value="A" checked="checked">(A)在听课学的还可以
						</div>
						<div>
							<input type="radio" name="five" value="B">(B)在听课 学的一般
						</div>
						<div>
							<input type="radio" name="five" value="C">(C)在听课，但听不很懂
						</div>
						<div>
							<input type="radio" name="five" value="D">(D)没听课,课程本身没意思
						</div>
						<div>
							<input type="radio" name="five" value="E">(E)没听课，感觉课程将来没用
						</div></li>

				</ol>
			</div>

			<div>
				<input type="submit" value="提交" >
			</div>
		</form>
	</div>
</body>
</html>