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
		margin-bottom: 0px;
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
	#field1
	{
		width: 90%;
		margin: auto;
		margin-top: 4%;
	}
	#logo_img
	{
		width: 20%;
		height: 20%;
		float: left;
	}
	#home
	{
		float: left;
		margin-top: 0%;
		
	}
	#table
	{
		border: 1px solid black;
		width: 50%;
		margin: auto;
	}
	#review
	{
		width: 50%;
		margin-right: 10%;
		float: left;
		text-align: right;
	}
	#review_write
	{
		width: 70%;
	}
	#field2
	{
		width: 90%;
		margin: auto;
		text-align: center;
	}
	.img
	{
		width: 50%;
	}
	.img_div
	{
		width: 33%;
		float: left;
		margin: auto;
	}
</style>
<script type="text/javascript">
	function way() 
	{
		location.href="loadfind.do";
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
		<fieldset id="field1">
			<div>
				<img src="resources/image/logo.PNG" id="logo_img">
			</div>
			<div id="home">
				<a href="" style="margin-top: 0px;">가게 홈페이지로 이동</a>
				<br>
				<span style="text-align: left;"> 
					영업시간 : <br>
					전화번호 : <br>
					별점 : <br>
					등등	<br>
				</span>
				<button onclick="way()">길찾기</button>
			</div>
			<div>
				<table id="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>글쓴이</th>
							<th>내용</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>.</td>
							<td>.</td>
							<td>.</td>
						</tr>
					</tbody>
				</table>
				<form id="review">
					<input id="review_write" type="text" placeholder="리뷰쓰기">
					<input id="review_btn" type="submit" value="write">
				</form>
			</div>
			<div>
				<fieldset id="field2">
					<legend>메뉴판</legend>
					<div class="img_div">
						<img src="resources/image/pic1.jpg" class="img">
						<h3>메뉴1</h3>
					</div>
					<div class="img_div">
						<img src="resources/image/pic2.jpg" class="img">
						<h3>메뉴2</h3>
					</div>
					<div class="img_div">
						<img src="resources/image/pic3.jpg" class="img">
						<h3>메뉴3</h3>
					</div>
				</fieldset>
			</div>
		</fieldset>
	</div>
	<div>
		<footer>footer정보</footer>
	</div>
</body>
</html>