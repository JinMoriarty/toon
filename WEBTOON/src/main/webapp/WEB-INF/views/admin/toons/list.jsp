<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
table td{
    width: 100px;
}
#container_box table {
	width: 900px;
}
#container_box table th {
	font-size: 40px;
	font-weight: bold;
	text-align: center;
	padding: 50px;
	border-bottom: 2px solid #666;
}
#container_box table tr:hover {
	background: #eee;
}
#container_box table td {
	padding: 50px;
	text-align: center;
}
#container_box table img {
	width: 150px;
	height: auto;
}
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
	background : #C8FFFF;
	font-size: 60px;
	padding: 20px 0;
}
header#header h1 a {
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
			<div id="container_box">작품 목록</div>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>분류</th>
						<th>장르</th>
						<th>조회수</th>
						<th>별점</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.toonNum}</td>
							<td><a href="/admin/toons/view?=n${list.toonNum}">${list.toonName}</a></td>
							<td>${list.cateCode}</td>
							<td>${list.toonGenre}</td>
							<td>${list.toonView}</td>
							<td>${list.toonGood}</td>
							<td><fmt:formatDate value="${list.toonDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>