<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap Theme Company Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/recipe.css">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#home">Zip-Bab🍚</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/recipe/list.do">레시피 보기</a></li>
                <li><a href="#ingredient">재료 보기</a></li>
                <li><a href="#mypage">마이페이지</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron text-center">
    <h1>Zip-Bab🍚</h1>
    <p>편안하고 즐거운 요리</p>
</div>
<div id="floatdiv" style="text-align:center;">
<ul>
<a href='#링크 주소' target='_blank' style="background-color:orange;">레시피 보기</a>
</ul>
<ul>
<a href='#링크 주소' target='_blank' >레시피 보기</a>
</ul>
<ul>
<a href='#링크 주소' target='_blank' style="background-color:orange;">레시피 보기</a>
</ul>
</div>


</body>
</html>