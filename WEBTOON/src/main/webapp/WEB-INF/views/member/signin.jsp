<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>HOJIN</title>

<style>
body{
         font-family: "Lato";
         font-size: 1.5em;
         color: #333;
}
div#root {
	position: absolute;
	top: 30%;
	left: 40%;
	width:300px;
	height:700px;
}
header#header div#header_box {
	position: absolute;
	top: -7%;
	left: 2%;
	padding: 30px 0;
}
nav#nav div#nav_box {
	position: absolute;
	top: 11%;
	left: -5%;
	font-size: 20px;
	padding: 10px;
	text-align: left;
}
nav#nav div#nav_box li {
	display: inline-block;
}
nav#nav div#nav_box li a {
	color: #333;
}
/*div#header_box {
	position: absolute;
	border:1px solid red;
	top: 30%;
	left: 40%;
}*/
/*div#nav_box{
	position: absolute;
	border:1px solid red;
	top: 35%;
	left: 45%;
}*/
/*div#container_box{
	position: absolute;
	top: 32%;
	left: 40%;
}*/
div#footer_box {
	position: absolute;
	top: 100%;
	left: -100%;
	width:1000px;
}
#login-form{
		 position: absolute;
		 top: 20%;
		 left: 10%;
         width:200px;
         border: 1px solid gray;
         border-radius: 5px;
         padding: 15px;
}
/* inline이였던 요소들을 block으로 바꿈 */
#login-form input, #login-form label{
         display:block;
}
#login-form label{
         margin-top: 10px;
}
#login-form input{
         margin-top: 5px;
}
/* 애트리뷰트 선택자 */
#login-form input[type='image']{
         margin: 10px auto;
}
</style>

</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<div id="container_box">

				<section id="content">
					<form id="login-form" role="form" method="post" autocomplete="off">
						<div class="input_area">
							<label for="userId">ID</label> <input type="email" id="userId"
								name="userId" required="required" value="asd123@naver.com" /> <!-- 여기 수정해야함 -->
						</div>

						<div class="input_area">
							<label for="userPass">PW</label> <input type="password"
								id="userPass" name="userPass" required="required" value="123" /><!-- 여기 수정해야함 -->
						</div>
						</br>
						<button type="submit" id="signin_btn" name="signin_btn">로그인</button>

						<c:if test="${msg == false}">
							<p style="color: #f00;">로그인에 실패했습니다.</p>
						</c:if>

					</form>
				</section>

			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>