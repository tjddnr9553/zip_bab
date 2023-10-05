<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Document</title>
    <style>
    input[type=text] {
      width: 200px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 3px;
      font-size: 13px;
      background-color: white;
      background-image: url('searchicon.png');
      background-position: 10px 10px;
      background-repeat: no-repeat;
      padding: 12px 20px 12px 40px;
      -webkit-transition: width 0.4s ease-in-out;
      transition: width 0.4s ease-in-out;
    }

    input[type=text]:focus {
      width: 30%;
    }
    </style>
</head>
<body>
<div class="container">
  <h2>레시피 모음</h2>
 <form><p>편리하고 다양한 즐거운 집밥<input type="text" name="search" placeholder="Search.." style="position:absolute; right:300px;"></p></form>
  <table class="table table-striped">
    <thead style="text-align:center;">
      <tr>
        <th>번호</th>
        <th>레시피 제목</th>
        <th>음식종류</th>
        <th>쟤료목록</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="r" items="${list }">
      <tr>
        <td>${r.recipeId}</td>
        <td>${r.title}</td>
        <td>${r.way}</td>
        <td>${r.ingredientInfo}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>