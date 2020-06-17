<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>HOJIN</title>

<style>
body {
	font-family: "Lato";
	font-size: 1.5em;
	color: #333;
}
div#root {
	position: absolute;
	top: 30%;
	left: 40%;
	width: 300px;
	height: 700px;
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
#SignUp-from{
		 position: absolute;
		 top: 20%;
		 left: 10%;
         width:200px;
         border: 1px solid gray;
         border-radius: 5px;
         padding: 15px;
}
/* inline이였던 요소들을 block으로 바꿈 */
#SignUp-from input, #login-form label{
         display:block;
}
#SignUp-from label{
         margin-top: 10px;
}
#SignUp-from input{
         margin-top: 5px;
}
/* 애트리뷰트 선택자 */
#SignUp-from input[type='image']{
         margin: 10px auto;
}
div#footer_box {
	position: absolute;
	top: 100%;
	left: -100%;
	width:1000px;
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
					<form id="SignUp-from" role="form" method="post" autocomplete="off">
						<div class="input_area">
							<label for="userId">ID</label> <input type="email" id="userId"
								name="userId" placeholder="Your ID"
								required="required" />
						</div>

						<div class="input_area">
							<label for="userPass">PW</label> <input type="password"
								id="userPass" name="userPass" required="required" />
						</div>

						<div class="input_area">
							<label for="userName">Nick Name</label> <input type="text"
								id="userName" name="userName" placeholder="Your Nick Name"
								required="required" />
						</div>

						<div class="input_area">
							<label for="userPhone">Number</label> <input type="text"
								id="userPhone" name="userPhone" placeholder="Your Phone Number"
								required="required" />
						</div>
						</br>
						<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>

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