<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
                    <li><a href="#recipes">레시피 보기</a></li>
                    <li><a href="#ingredient">재료 보기</a></li>
                    <li><a href="#mypage">마이페이지</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <title>Bootstrap Theme Company Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .jumbotron {
          background-color: #f4511e;
          color: #fff;
        }

        /* 떠다니는 메뉴 (Floating Menu) */
        #floatdiv {
            position:fixed; _position:absolute; _z-index:-1;
            width:160px; /* 가로폭 조절*/
            overflow:hidden;
            right:45%;
            top:24%; /* 이미지 높이 조절 */
            background-color: transparent;
            margin-right: -530px; /* 좌우측 여백 조절 */
            padding:0;
        }#floatdiv ul  { list-style: none; }
        #floatdiv li  { margin-bottom: 2px; text-align: center; }
        #floatdiv a   { color: #5D5D5D; border: 0; text-decoration: none; display: block; }
        #floatdiv a:hover, #floatdiv .menu  { background-color: #5D5D5D; color: #fff; }
        #floatdiv .menu, #floatdiv .last    { margin-bottom: 0px; }
    </style>
</head>
<body>

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

<h4>🔘 조 리 방 법</h4>
<img src="http://www.foodsafetykorea.go.kr/uploadimg/cook/20_00028_1.png" class="img-rounded" alt="Cinque Terre">  1. 손질된 새우를 끓는 물에 데쳐 건진다.<br/><br/>
<img src="http://www.foodsafetykorea.go.kr/uploadimg/cook/20_00028_2.png" class="img-rounded" alt="Cinque Terre">  2. 연두부, 달걀, 생크림, 설탕에 녹인 무염버터를 믹서에 넣고 간 뒤 새우(1)를 함께 섞어 그릇에 담는다.<br/><br/>
<img src="http://www.foodsafetykorea.go.kr/uploadimg/cook/20_00028_3.png" class="img-rounded" alt="Cinque Terre">  3. 시금치를 잘게 다져 혼합물 그릇(2)에 뿌리고 찜기에 넣고 중간 불에서 10분 정도 찐다.<br/><br/><br/><br/>
<h4>🔘 완 성 사 진</h4>
<img src="http://www.foodsafetykorea.go.kr/uploadimg/cook/10_00028_1.png" class="img-rounded" alt="Cinque Terre" style="width:300px; height:200px;">
<p></p>
</body>
</html>