<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/list.css">
<title>Document</title>
</head>
<body>
<div class="container">
  <h2>레시피 모음</h2>
 <form action="${pageContext.request.contextPath}/recipe/getByTitle.do"><p>편리하고 다양한 즐거운 집밥<input type="text" name="title" placeholder="Search.." style="position:absolute; right:210px;"></p></form>
  <table class="table table-striped">
    <thead style="text-align:center;">
      <tr>
        <th>번호</th>
        <th>레시피 제목</th>
        <th style="width:75px;">조리방법</th>
        <th>쟤료목록</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="r" items="${list }">
      <tr>
        <td>${r.recipeId}</td>
        <td><a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}">${r.title}</a></td>
        <td>${r.way}</td>
        <td>${r.ingredientInfo}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>

    <ul class="pagination justify-content-center">
      <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
      <li class="page-item"><a class="page-link" href=";">1</a></li>
      <li class="page-item"><a class="page-link" href=";">2</a></li>
      <li class="page-item"><a class="page-link" href=";">3</a></li>
      <li class="page-item"><a class="page-link" href=";">4</a></li>
      <li class="page-item"><a class="page-link" href=";">5</a></li>
      <li class="page-item"><a class="page-link" href=";">6</a></li>
      <li class="page-item"><a class="page-link" href=";">7</a></li>
      <li class="page-item"><a class="page-link" href=";">8</a></li>
      <li class="page-item"><a class="page-link" href=";">9</a></li>
      <li class="page-item"><a class="page-link" href=";">10</a></li>
      <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
    </ul>
</div>
</body>
</html>