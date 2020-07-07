<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
<title>HOJIN</title>

<script>
function replyList() {
								
				var toonNum = ${view.toonNum};
				$.getJSON("/toon/view/replyList" + "?n="+ toonNum, function(data){
					var str = "";
													
					$(data).each(function() {
								console.log(data);

								var repDate = new Date(this.repDate);
								repDate = repDate.toLocaleDateString("ko-US")

								str += "<li data-repNum='" + this.repNum + "'>" 
								+ "<div class='userInfo'>"
								+ "<span class='userName'>" + this.userName + "</span>"
								+ "<span class='date'>" +repDate + "</span>"
								+"</div>"
								+ "<div class='replyContent'>" + this.repCon + "</div>"
								
								+ "<c:if test='${member != null}'>"
								
								+ "<div class='replyFooter'>"
								 + "<button type='button' class='modify' data-repNum='" + this.repNum + "'>수정</button>"
								 + "<button type='button' class='delete' data-repNum='" + this.repNum + "'>삭제</button>"
								 + "</div>"

								 + "</c:if>"
								 
								+ "</li>";											
					});

				$("section.replyList ol").html(str);
		});
}
</script>

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
div.toons div.toonsImg {
	float: left;
	width: 350px;
}

div.toons div.toonsImg img {
	width: 350px;
	height: auto;
}

div.toons div.toonsInfo {
	float: right;
	width: 330px;
	font-size: 22px;
}

div.toons div.toonsInfo p {
	margin: 0 0 20px 0;
}

div.toons div.toonsInfo p span {
	display: inline-block;
	width: 100px;
	margin-right: 15px;
}

div.toons div.toonsInfo p.cartStock input {
	font-size: 22px;
	width: 50px;
	padding: 5px;
	margin: 0;
	border: 1px solid #eee;
}

div.toons div.toonsInfo p.cartStock button {
	font-size: 26px;
	border: none;
	background: none;
}

div.toons div.toonsInfo p.addToCart {
	text-align: right;
}

div.toons div.toonsDes {
	font-size: 18px;
	clear: both;
	padding-top: 30px;
}
</style>

<style>
section.replyForm {
	padding: 30px 0;
}

section.replyForm div.input_area {
	margin: 10px 0;
}

section.replyForm textarea {
	font-size: 16px;
	font-family: '맑은 고딕', verdana;
	padding: 10px;
	width: 500px;;
	height: 150px;
}

section.replyForm button {
	font-size: 20px;
	padding: 5px 10px;
	margin: 10px 0;
	background: #fff;
	border: 1px solid #ccc;
}

section.replyList {
	padding: 30px 0;
}

section.replyList ol {
	padding: 0;
	margin: 0;
}

section.replyList ol li {
	padding: 10px 0;
	border-bottom: 2px solid #eee;
}

section.replyList div.userInfo {
	
}

section.replyList div.userInfo .userName {
	font-size: 24px;
	font-weight: bold;
}

section.replyList div.userInfo .date {
	color: #999;
	display: inline-block;
	margin-left: 10px;
}

section.replyList div.replyContent {
	padding: 10px;
	margin: 20px 0;
}

section.replyList div.replyFooter button { font-size:14px; border: 1px solid #999; background:none; margin-right:10px; }


</style>

<style>
 div.replyModal { position:relative; z-index:1; display:none; }
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
 div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 div.modalContent button.modal_cancel { margin-left:20px; }
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
		<div id="aside_box">
			<aside id="aside">
				<%@ include file="../include/aside.jsp"%>
			</aside>
		</div>
		<section id="container">
			<div id="container_box">

				<section id="content">
					<form role="form" method="post">
						<input type="hidden" name="toonNum" value="${view.toonNum}" />
					</form>

					<div class="toons">
						<div class="toonsImg">
							<img src="<c:url value="/img/${view.toonImg}"/>"/>
						</div>

						<div class="goodsInfo">
							<p class="toonName">
								<span>제목 </span>${view.toonName}</p>

							<p class="cateName">
								<span>카테고리 </span>${view.cateName}</p>

							<p class="toonGenre">
								<span>장르 </span>${view.toonGenre}</p>
						
						<p class="addMark">
							<button type="button" class="addMark_btn">책갈피</button>
							<script>
								$(".addMark_btn").click(function(){
									
									var toonNum = $("#toonNum").val();
									
									var data = {
											toonNum : toonNum
											};
									
									$.ajax({
										url : "/toon/view/addMark",
										type : "post",
										data : data,
										success : function(result){
											
											if(result == 1) {
												alert("책갈피 성공");
											} else {
												alert("회원만 사용할 수 있습니다.")
											}
										},
										error : function(){
											alert("책갈피 실패");
										}
									});
								});
							</script>
						</p>
						</div>
						<div class="toonDes">${view.toonDes}</div>
						
						<p class="addGood">
						<div class="toonGood">${view.toonGood}</div>
							<c:if test = "${member != null}">
								<button type = "button" class = "addGood_btn">추천하기</button>
							</c:if>
							<script>
							$(".addGood_btn").click(function(){
								
								var toonNum = $("#toonNum").val();
								
								var data = {
										toonNum : toonNum
										};
								
								$.ajax({
									url : "/toon/view/addGood",
									type : "post",
									data : data,
									success : function(){
										
										
											alert("추천 하였습니다.");
											history.go(0);
										
									}
								});
							});
							</script>
							
						</p>
						
						
						
						
						
						
		
						
							</section>

							<script>
						
							$(document).on("click", ".modify", function(){
								//$(".replyModal").attr("style", "display:block;");
								$(".replyModal").fadeIn(200);
								
								var repNum = $(this).attr("data-repNum");
								var repCon = $(this).parent().parent().children(".replyContent").text();
								
								$(".modal_repCon").val(repCon);
								$(".modal_modify_btn").attr("data-repNum", repNum);
								
							});
													
							// 스크립트로 인해 생성된 HTML의 이벤트는 .click() 메서드를 사용할 수 없음
							$(document).on("click", ".delete", function(){
								
								// 사용자에게 삭제 여부를 확인
								var deletConfirm = confirm("정말로 삭제하시겠습니까?"); 
								
								if(deletConfirm) {
								
									var data = {repNum : $(this).attr("data-repNum")};  // ReplyVO 형태로 데이터 생성
									
									$.ajax({
										url : "/toon/view/deleteReply",
										type : "post",
										data : data,
										success : function(result){
											
											// result의 값에 따라 동작
											if(result == 1) {
												replyList();  // 리스트 새로고침
											} else {
												alert("작성자 본인만 할 수 있습니다.")  // 본인이 아닌 경우										
											}
										},
										error : function(){
											// 로그인하지 않아서 에러가 발생한 경우
											alert("로그인하셔야합니다.")
											console.log(result);
										}
									});
								}
							});
						
						</script>

							
						</section>
					</div>
						
					</div>

					<div id="reply">

						<c:if test="${member == null }">
							<p>
								댓글을 남기시려면 <a href="/member/signin">로그인</a>해주세요
							</p>
						</c:if>

						<c:if test="${member != null}">
							<section class="replyForm">
								<form role="form" method="post" autocomplete="off">
								
									<input type="hidden" name="toonNum" id="toonNum" value="${view.toonNum}">
									
									<div class="input_area">
										<textarea name="repCon" id="repCon"></textarea>
									</div>

									<div class="input_area">
										<button type="button" id="reply_btn">댓글 달기</button>
										
										<script>
 											$("#reply_btn").click(function(){
 												
  											var formObj = $(".replyForm form[role='form']");
  											var toonNum = $("#toonNum").val();
  											var repCon = $("#repCon").val()
  
  											var data = {
    											toonNum : toonNum,
    											repCon : repCon
    										};
  
  											$.ajax({
   												url : "/toon/view/registReply",
   												type : "post",
   												data : data,
   												success : function(){
    												replyList();
    												$("#repCon").val("");
   												}
  											});
 										});
										</script>
									</div>

								</form>
							</section>
						</c:if>

						<section class="replyList">
							<ol>
								<%--
								<c:forEach items="${reply}" var="reply">

									<li>
										<div class="userInfo">
											<span class="userName">${reply.userName}</span> <span
												class="date"><fmt:formatDate value="${reply.repDate}"
													pattern="yyyy-MM-dd" /></span>
										</div>
										<div class="replyContent">${reply.repCon}</div>
									</li>
								</c:forEach>
								 --%>
							
							</ol>
							<script>
								replyList();
							</script>
							
							<script>
						
							$(document).on("click", ".modify", function(){
								//$(".replyModal").attr("style", "display:block;");
								$(".replyModal").fadeIn(200);
								
								var repNum = $(this).attr("data-repNum");
								var repCon = $(this).parent().parent().children(".replyContent").text();
								
								$(".modal_repCon").val(repCon);
								$(".modal_modify_btn").attr("data-repNum", repNum);
								
							});
													
							// 스크립트로 인해 생성된 HTML의 이벤트는 .click() 메서드를 사용할 수 없음
							$(document).on("click", ".delete", function(){
								
								// 사용자에게 삭제 여부를 확인
								var deletConfirm = confirm("정말로 삭제하시겠습니까?"); 
								
								if(deletConfirm) {
								
									var data = {repNum : $(this).attr("data-repNum")};  // ReplyVO 형태로 데이터 생성
									
									$.ajax({
										url : "/toon/view/deleteReply",
										type : "post",
										data : data,
										success : function(result){
											
											// result의 값에 따라 동작
											if(result == 1) {
												replyList();  // 리스트 새로고침
											} else {
												alert("작성자 본인만 할 수 있습니다.")  // 본인이 아닌 경우										
											}
										},
										error : function(){
											// 로그인하지 않아서 에러가 발생한 경우
											alert("로그인하셔야합니다.")
											console.log(result);
										}
									});
								}
							});
						
						</script>

							
						</section>
					</div>
				</section>

			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
	
<div class="replyModal">

 <div class="modalContent">
  
  <div>
   <textarea class="modal_repCon" name="modal_repCon"></textarea>
  </div>
  
  <div>
   <button type="button" class="modal_modify_btn">수정</button>
   <button type="button" class="modal_cancel">취소</button>
  </div>
  
 </div>

 <div class="modalBackground"></div>
 
</div>

<script>
$(".modal_modify_btn").click(function(){
	var modifyConfirm = confirm("정말로 수정하시겠습니까?");
	
	if(modifyConfirm) {
		var data = {
					repNum : $(this).attr("data-repNum"),
					repCon : $(".modal_repCon").val()
				};  // ReplyVO 형태로 데이터 생성
		
		$.ajax({
			url : "/toon/view/modifyReply",
			type : "post",
			data : data,
			success : function(result){
				
				if(result == 1) {
					replyList();
					$(".replyModal").fadeOut(200);
				} else {
					alert("작성자 본인만 할 수 있습니다.")						
				}
			},
			error : function(){
				alert("로그인하셔야합니다.")
			}
		});
	}
	
});
$(".modal_cancel").click(function(){
	//$(".replyModal").attr("style", "display:none;");
	$(".replyModal").fadeOut(200);
});
</script>

</body>
</html>