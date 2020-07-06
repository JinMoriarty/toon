<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>HOJIN</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: '맑은 고딕', verdana;
}

a {
	color: #05f;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

ul, lo, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

/* ---------- */
div#root {
	width: 900px;
	margin: 0 auto;
}

header#header {
	
}

nav#nav {
	
}

section#container {
	
}

section#content {
	float: right;
	width: 700px;
}

aside#aside {
	text-align: center;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

footer#footer {
	background: #eee;
	padding: 20px;
}

/* ---------- */
header#header div#header_box {
	text-align: center;
	padding: 30px 0;
}

header#header div#header_box h1 {
	font-size: 50px;
}

header#header div#header_box h1 a {
	color: #000;
}

nav#nav div#nav_box {
	font-size: 14px;
	padding: 10px;
	text-align: right;
}

nav#nav div#nav_box li {
	display: inline-block;
	margin: 0 10px;
}

nav#nav div#nav_box li a {
	color: #333;
}

section#container {
	
}

div#aside_box {
	font-size: 14px;
	padding: 10px;
	text-align: left;
}

aside#aside h3 {
	font-size: 22px;
	margin-bottom: 20px;
	text-align: center;
}

aside#aside li {
	font-size: 16px;
	text-align: center;
	display: inline-block;
	float: left;
}

aside#aside li a {
	color: #000;
	display: block;
	padding: 5px 10px;
	width: 180px
}

aside#aside li a:hover {
	text-decoration: none;
	background: #eee;
}

aside#aside li {
	
}

aside#aside li:hover {
	background: #eee;
}

aside#aside li>ul.low {
	display: none;
	position: absolute;
	top: 205px;
	left: 200px;
}

aside#aside li:hover>ul.low {
	display: inline-block;
}

aside#aside li:hover>ul.low li a {
	background: #eee;
	border: 1px solid #eee;
	width: 180;
}

aside#aside li:hover>ul.low li a:hover {
	background: #fff;
}

aside#aside li>ul.low li {
	width: 180px;
}

footer#footer {
	margin-top: 100px;
	border-radius: 50px 50px 0 0;
}

footer#footer div#footer_box {
	padding: 0 20px;
}
</style>
<style>
section#content ul li {
	display: inline-block;
	margin: 10px;
}

section#content div.goodsThumb img {
	width: 200px;
	height: 200px;
}

section#content div.goodsName {
	padding: 10px 0;
	text-align: center;
}

section#content div.goodsName a {
	color: #000;
}
</style>
<style>
section#content ul li {
	margin: 10px 0;
}

section#content ul li img {
	width: 250px;
	height: 250px;
}

section#content ul li::after {
	content: "";
	display: block;
	clear: both;
}

section#content div.thumb {
	float: left;
	width: 250px;
}

section#content div.toonInfo {
	float: right;
	width: calc(100% - 270px);
}

section#content div.toonInfo {
	font-size: 20px;
	line-height: 2;
}

section#content div.toonInfo span {
	display: inline-block;
	width: 100px;
	font-weight: bold;
	margin-right: 10px;
}

section#content div.toonInfo .delete {
	text-align: right;
}

section#content div.toonInfo .delete button {
	font-size: 22px;
	padding: 5px 10px;
	border: 1px solid #eee;
	background: #eee;
}

.allCheck {
	float: left;
	width: 200px;
}

.allCheck input {
	width: 16px;
	height: 16px;
}

.allCheck label {
	margin-left: 10px;
}

.delBtn {
	float: right;
	width: 300px;
	text-align: right;
}

.delBtn button {
	font-size: 18px;
	padding: 5px 10px;
	border: 1px solid #eee;
	background: #eee;
}

.checkBox {
	float: left;
	width: 30px;
}

.checkBox input {
	width: 16px;
	height: 16px;
}
</style>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
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
		<div id="aside_box">
			<aside id="aside">
				<%@ include file="../include/aside.jsp"%>
			</aside>
		</div>
		<section id="container">
			<div id="container_box">
				<section id="content">
					<ul>
						<li>
							<div class="allCheck">
								<input type="checkbox" name="allCheck" id="allCheck" /><label
									for="allCheck">모두 선택</label>

								<script>
									$("#allCheck").click(
											function() {
												var chk = $("#allCheck").prop(
														"checked");
												if (chk) {
													$(".chBox").prop("checked",
															true);
												} else {
													$(".chBox").prop("checked",
															false);
												}
											});
								</script>
							</div>

							<div class="delBtn">
								<button type="button" class="selectDelete_btn">선택 삭제</button>

								<script>
									$(".selectDelete_btn")
											.click(
													function() {
														var confirm_val = confirm("정말 삭제하시겠습니까?");

														if (confirm_val) {
															var checkArr = new Array();

															$(
																	"input[class='chBox']:checked")
																	.each(
																			function() {
																				checkArr
																						.push($(
																								this)
																								.attr(
																										"data-markNum"));
																			});

															$
																	.ajax({
																		url : "/toon/deletemark",
																		type : "post",
																		data : {
																			chbox : checkArr
																		},
																		success : function() {
																			location.href = "/toon/markList";
																		}
																	});
														}
													});
								</script>
							</div>

						</li>
						<c:forEach items="${markList}" var="markList">
							<li>
								<div class="checkBox">
									<input type="checkbox" name="chBox" class="chBox"
										data-markNum="${markList.markNum}" />
									<script>
										$(".chBox").click(
												function() {
													$("#allCheck").prop(
															"checked", false);
												});
									</script>
								</div>

								<div class="thumb">
									<img src="<c:url value="/img/${markList.toonThumbImg}"/>" />
								</div>
								<div class="toonInfo">
									<p>
										<span>제목 : </span>${markList.toonName}<br />
									</p>
									<div class="delete">
										<button type="button" class="delete_btn"
											data-markNum="${markList.markNum}">삭제</button>
									</div>
								</div>



							</li>
						</c:forEach>
					</ul>
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