<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.btn
	{
		text-align: center;
		height: 2%;
		border: 2px solid black;
	}
	#menu_id
	{
		width: 80%;
		text-align: center;
		margin-top: 3%;
		margin-left: 10%;
	}
	
	#menu_id > div
	{
		width: 23%;
		height: 40px;
		display: inline-block;
		text-align: center;
		cursor: pointer;
		line-height: 40px;
		margin: auto;	
		background-color: gray;
	}
	#menu_id > div > a
	{
		display: block;
	}
	a
	{
		text-decoration: none;
		color: black;
	}
	.div_in
	{
		float: left;
		width: 50%;
		text-align: center;
		margin-top: 2%;
		margin-bottom: 2%;
	}
	.in
	{
		border: 2px solid black;
		width: 50%;
	}
	img
	{
		width: 40%;
		height: 50%;
	}
	fieldset
	{
		width: 45%;
		float: left;
		margin-left: 1%;
		margin-right: 1%;
	}
	textarea 
	{
		height: 80px;
		width: 50%;
		text-align: center;
	}
	footer
	{
		background-color: gray;
		width: 100%;
		height: 60px;
		font-size: 10px;
		margin-top: 40%;
		padding: 10px;
	}
	a:hover
	{
		color: silver;
		cursor: pointer;
	}
	#menu_id > div:hover
	{
		background-color: black;
	}
</style>
<script type="text/javascript">
	function boardlist() 
	{
		location.href="board.do?cPage=${cPage}";
	}
</script>
</head>
<body>
	<%-- 현재 페이지에서 다른 페이지 가져오기  --%>
	<%@ include file="top.jsp" %>
	<!-- <div>
		위치 검색, 로그인 회원가입 태그
		<div>
			<form action="addr_search.do" method="post">
				<input type="text" id="top_addr" placeholder="위치를 쓰세요." name="addr_search" required>
				<input type="submit" id="top_btn" class="btn"  value="검색" >
			</form>
		</div>
		<div>
			<div class="a_div" style="margin-right: 2%;">
				<a href="main.do">home</a>
			</div>
			<div class="a_div">
				<a href="login.do">로그인 </a> &nbsp;|&nbsp;
				<a href="join.do">회원가입</a>
			</div>
		</div>
	</div><br> -->
	<!-- 메뉴바 -->
	<div>
		<div id="menu_id">
			<div><a href="search.do?search=">검색</a></div>
			<div><a href="food_restaurant.do">음식 및 음식점 추천</a></div>
			<div><a onclick="boardlist()">게시판</a></div>
			<div><a href="mypage.do?cPage=${cPage} ">마이페이지</a></div>
		</div>
	</div>
	<div>
		<div class="div_in">
			<form action="search.do">
				<!-- 음식으로 검색하기 -->
				<input class="in" type="text" placeholder="음식이름" name="search" required>
				<input class="btn" type="submit" value="검색">
				<input type="hidden" name="choice" value="음식이름">
			</form>
		</div>
		<div class="div_in">
			<form action="search.do">
				<!-- 음식점으로 검색하기 -->
				<input class="in" type="text" placeholder="가게이름" name="search" required>
				<input class="btn" type="submit" value="검색">
				<input type="hidden" name="choice" value="가게이름">
			</form>
		</div>
		<div>
			<fieldset>
				<legend>먹을거리 추천</legend>
				<div>
					<img alt="" src="resources/image/pic1.jpg">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
				<div>
					<img alt="" src="resources/image/pic1.jpg">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
			</fieldset>
		</div>
		<div>
			<fieldset>
				<legend>가볼만한 가게 추천</legend>
				<div>
					<img alt="" src="resources/image/pic1.jpg">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
				<div>
					<img alt="" src="resources/image/pic1.jpg">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
			</fieldset>
		</div>
	</div>
	<div>
		<footer>footer정보</footer>
	</div>
	
</body>
</html>