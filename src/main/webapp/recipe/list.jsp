<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/list.css">
<title>Document</title>
</head>
<body>
<div class="container">
  <h2>레시피 모음</h2>
 <form action="${pageContext.request.contextPath}/recipe/getByTitle.do"><p>편리하고 다양한 즐거운 집밥
    <input type="text" name="title" placeholder="Search.." style="position:absolute; right:210px;"></p></form><br/>
        <div class="container mt-3">
            <div class="row">
                <c:forEach var="r" items="${list}">
                    <div class="col-md-2 mb-1">
                        <div class="card h-100" style="width:200px;">
                            <img class="card-img-top img-fluid" src="${r.completePicture}" alt="이미지 없음" style="width:250px;height:220px;">
                            <div class="card-body">
                                <h6 class="card-title"><a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}">${r.title}</a></h6>
                                <p class="card-text">${r.way}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

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