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
	
	a:hover
	{
		color: silver;
		cursor: pointer;
	}
	#menu_id > div:hover
	{
		background-color: black;
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
	.retry_btn
	{
		margin-top: 5%;
		margin-bottom: 5%;
	}
</style>
<script type="text/javascript">
	/* 나중에 load 수정 */
	function load(f) 
	{
		/* if (f.elements[0].values == null) 
		{
			f.elements[0].focus();
		}else if(f.elements[1].values == null)
		{
			f.elements[1].focus();
		}else
		{
			alert("안내를 시작함");		
		} */
		alert("안내를 시작함");	
		
	}
	function start() 
	{
		document.getElementById("start_addr").focus();
		
	}
	function end() 
	{
		document.getElementById("end_addr").focus();
	}
</script>
</head>
<body>
	<%-- 현재 페이지에서 다른 페이지 가져오기  --%>
	<%@ include file="top.jsp" %>
	<div style="text-align: center; float: none;">
		<h1>길찾기</h1>
	</div>
	<!-- * 카카오맵 - 지도퍼가기 -->
	<!-- 1. 지도 노드 -->
	<div id="daumRoughmapContainer1624432839749" 
		class="root_daum_roughmap root_daum_roughmap_landing" 
		style="float: left; width: 60%; margin: auto;">
	</div>

	<!--
		2. 설치 스크립트
		* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
	-->
	<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

	<!-- 3. 실행 스크립트 -->
	<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1624432839749",
		"key" : "26cht",
		/* "mapWidth" : "700", */
		"mapHeight" : "380"
	}).render();
	</script>
	<!-- 나중에 파라미터 받아와서 출발위치 도착위치 받자. -->
	<div>
		<fieldset style="width: 25%; margin: auto; height: 400px; margin-bottom: 1%;">
			<form>
				<input type="text" placeholder="출발위치" id="start_addr">
				<input class="retry_btn" type="button" value="출발위치 다시 검색하기" onclick="start()"><hr>
				<input type="text" placeholder="도착위치" id="end_addr">
				<input class="retry_btn" type="button" value="도착위치 다시 검색하기" onclick="end()"><hr>
				<input type="button" value="길찾기" onclick="load(this.form)"><hr>
			</form>
		</fieldset>
	</div>
	<div>
		<footer>footer정보</footer>
	</div>
</body>
</html>