<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>HOJIN Admin</title>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<style>
body {
	font-family: "Fantasy"
	padding: 0;
	margin: 0;
}
ul {
	padding: 0;
	margin: 0;
	list-style: none;
}
div#root {
	width: 90%;
	margin: 0 auto;
}
header#header {
	background : #C8FFFF;
	font-size: 60px;
	padding: 20px 0;
}
header#header a {
	color: #000;
	font-weight: bold;
}
nav#nav {
	background : #FFFFFF;
	padding: 10px;
	text-align: right;
}
nav#nav ul li {
	display: inline-block;
	margin-left: 10px;
}
section#container {
	background : #FFFFFF;
	height : 900px;
	padding: 20px 0;
	border-top: 2px solid #FFFFFF;
	border-bottom: 2px solid #FFFFFF;
}
section#container::after {
	content: "";
	display: block;
	clear: both;
}
aside {
	float: left;
	width: 200px;
}
div#container_box {
	float: right;
	width: calc(100% - 200px - 20px);
}
aside ul li {
	text-align: center;
	margin-bottom: 10px;
}
aside ul li a {
	display: block;
	width: 100%;
	padding: 10px 0;
}
aside ul li a:hover {
	background: #BEEFFF;
}
footer#footer {
	position: fixed;
    left: 5%;
    top: 94%;
   
    width: 90%;
    
	background: #C8FFFF;
	padding: 20px;
	
	margin: 0px auto;
}
footer#footer ul li {
	display: inline-block;
	margin-right: 10px;
}
</style>

</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="include/aside.jsp"%>
			</aside>
			<div id="container_box"></div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>