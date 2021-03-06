<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>HOJIN</title>
<style>
	
body { 
margin:0; 
padding:0; 
font-family:'맑은 고딕', verdana; 
}

a { 
color:#05f; 
text-decoration:none; 
}

a:hover { 
text-decoration:underline; 
}
		
h1, h2, h3, h4, h5, h6 { 
margin:0; 
padding:0; 
}

ul, lo, li { 
margin:0; 
list-style:none; 
}
	
		/* ---------- */
		
div#root { 
width:900px; 
height:1200px;
margin:0 auto; 
}

header#header {}

nav#nav {}

section#container { }

section#content { 
float:right; 
width:700px; 
}
	
aside#aside { 
text-align:center; 
}

section#container::after {
 content:""; 
 display:block; 
 clear:both; 
 }	

footer#footer { 
background:#eee; 
padding:20px; 
}
		
		/* ---------- */
		
header#header div#header_box { 
text-align:center; 
padding:30px 0; 
}

header#header div#header_box h1 { 
font-size:50px; 
}

header#header div#header_box h1 a { 
color:#000; 
}
		
nav#nav div#nav_box { 
font-size:14px; 
padding:10px; 
text-align:right; 
}

nav#nav div#nav_box li { 
display:inline-block; 
margin:0 10px; 
}

nav#nav div#nav_box li a { 
color:#333; 
}
		
section#container { }

div#aside_box{ 
font-size:14px;
 padding:10px;
  text-align:left; 
}
		
aside#aside h3 { 
font-size:22px; 
margin-bottom:20px; 
text-align:center; 
}

aside#aside li { 
font-size:16px; 
text-align:center; 
display:inline-block; 
float: left;
}

aside#aside li a { 
color:#000; 
display:block; 
padding:5px 10px; 
width:180px
}

aside#aside li a:hover { 
text-decoration:none; 
background:#eee; 
}

		
aside#aside li {  }

aside#aside li:hover { 
background:#eee; 
} 		

aside#aside li > ul.low { 
display:none; 
position:absolute; 
top:139px; 
left: 460px;
}

aside#aside li:hover > ul.low { 
display:inline-block;
}

aside#aside li:hover > ul.low li a { 
background:#eee; 
border:1px solid #eee;
 width:180; 
 }

aside#aside li:hover > ul.low li a:hover { 
background:#fff;
}

aside#aside li > ul.low li { 
width:180px; 
}
		
footer#footer { 
position: fixed;
bottom: 0;
width: 40%;
margin-top:100px; 
border-radius:50px 50px 0 0; 
}

footer#footer div#footer_box { 
padding:0 20px; 
}
		
	</style>
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="include/header.jsp" %>
		</div>
	</header>

	<nav id="nav">
		<div id="nav_box">
			<%@ include file="include/nav.jsp" %>
		</div>
	</nav>
	<div id="aside_box">
				<aside id="aside">
					<%@ include file="include/aside.jsp" %>
				</aside>
			</div>
	<section id="container">
		<div id="container_box">
			
			<section id="content">
			<br>
			<br>
			<br>
				본문 영역
			</section>
			
		</div>
	</section>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="include/footer.jsp" %>
		</div>		
	</footer>

</div>
</body>
</html>