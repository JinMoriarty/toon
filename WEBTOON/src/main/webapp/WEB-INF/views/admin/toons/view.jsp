<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	font-family: '맑은 고딕', verdana;
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
	font-size: 60px;
	padding: 20px 0;
}

header#header h1 a {
	color: #000;
	font-weight: bold;
}

nav#nav {
	padding: 10px;
	text-align: right;
}

nav#nav ul li {
	display: inline-block;
	margin-left: 10px;
}

section#container {
	padding: 20px 0;
	border-top: 2px solid #eee;
	border-bottom: 2px solid #eee;
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
	background: #eee;
}

footer#footer {
	background: #f9f9f9;
	padding: 20px;
}

footer#footer ul li {
	display: inline-block;
	margin-right: 10px;
}
</style>


<style>
.inputArea {
	margin: 10px 0;
}

select {
	width: 100px;
}

label {
	display: inline-block;
	width: 70px;
	padding: 5px;
}

label[for='gdsDes'] {
	display: block;
}

input {
	width: 150px;
}

textarea#gdsDes {
	width: 400px;
	height: 180px;
}

.oriImg {
	width: 500px;
	height: auto;
}

.thumbImg {
	
}

.gdsDes img {
	max-width: 600px;
	height: auto;
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
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			<div id="container_box">
				<h2>작품 조회</h2>

				<form role="form" method="post" autocomplete="off">
					
					<div>
					<label>1차 분류</label> 
					<span class="category1"></span>
					<label>2차 분류</label> 
					<span class="category2">${toons.cateCode}</span>
					</div>
					

					<div class="inputArea">
						<label for="toonName">제목</label>
						<span>${toons.toonName}</span>
					</div>

					<div class="inputArea">
						<label for="toonGenre">장르</label> 
						<span>${toons.toonGenre}</span>
					</div>

					<div class="inputArea">
						<label for="toonDes">내용</label>
						<span>${toons.toonDes}</span>
					</div>

					<div class="inputArea">
						<button type="button" id="register_Btn" class="btn btn-warning">수정</button>
						<button type="button" id="register_Btn" class="btn btn-danger">삭제</button>
					</div>
				</form>

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