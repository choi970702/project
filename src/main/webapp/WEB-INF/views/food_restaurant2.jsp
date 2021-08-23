<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	img
	{
		width: 40%;
		height: 50%;
	}
</style>
<script type="text/javascript">
	function imgclick1() 
	{
		location.href="onelist.do";
	}
	function imgclick2() 
	{
		location.href="onelist.do";
	}
	function imgclick3() 
	{
		location.href="onelist.do";
	}
	function imgclick4() 
	{
		location.href="onelist.do";
	}
	function boardlist() 
	{
		location.href="board.do?cPage=${cPage}";
	}
</script>
</head>
<body>
	<%-- 현재 페이지에서 다른 페이지 가져오기  --%>
	<%@ include file="top.jsp" %>
	<!-- 메뉴바 -->
	<div>
		<div id="menu_id">
			<div><a href="search.do?search=">검색</a></div>
			<div><a href="food_restaurant.do">음식 및 음식점 추천</a></div>
			<div><a onclick="boardlist()">게시판</a></div>
			<div><a href="mypage.do">마이페이지</a></div>
		</div>
	</div>
	<div>
			<fieldset>
				<legend>이달의 추천 음식</legend>
				<form style="text-align: center;" action="food_restaurant2.do" method="post">
					<input type="radio" name="food_pick" value="리뷰순">리뷰가 많은순
					<input type="radio" name="food_pick" value="별점순">별점이 높은순
					<input type="submit" value="검색">
				</form>
				<div style="text-align: center;">${food_pick }</div>
				<div>
					<img alt="" src="resources/image/pic1.jpg" onclick="imgclick1()">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
				<div>
					<img alt="" src="resources/image/pic1.jpg" onclick="imgclick2()">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
			</fieldset>
		</div>
		<div>
			<fieldset>
				<legend>이달의 추천 가게</legend>
				<form style="text-align: center;" action="food_restaurant2.do" method="post">
					<input type="radio" name="restaurant_pick" value="리뷰순">리뷰가 많은순
					<input type="radio" name="restaurant_pick" value="별점순">별점이 높은순
					<input type="submit" value="검색">
				</form>
				<div style="text-align: center;">${restaurant_pick }</div>
				<div>
					<img alt="" src="resources/image/pic1.jpg" onclick="imgclick3()">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
				<div>
					<img alt="" src="resources/image/pic1.jpg" onclick="imgclick4()">
					<textarea>~~~~~~~~~~~</textarea>
				</div>
			</fieldset>
		</div>
	<div>
		<footer>footer정보</footer>
	</div>
</body>
</html>