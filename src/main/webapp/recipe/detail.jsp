<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/remote.css">
</head>
<body>
<div class="container">
  <h2>${r.title }</h2><br/>

  <h4 id="manual">🔘 조 리 방 법</h4>
  <img src="${r.manual_img_01}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_01}<br/><br/>
  <img src="${r.manual_img_02}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_02}<br/><br/>
  <img src="${r.manual_img_03}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_03}<br/><br/>
  <img src="${r.manual_img_04}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_04}<br/><br/>
  <img src="${r.manual_img_05}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_05}<br/><br/>
  <img src="${r.manual_img_06}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_06}<br/><br/>
  <img src="${r.manual_img_07}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_07}<br/><br/>
  <img src="${r.manual_img_08}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_08}<br/><br/>
  <img src="${r.manual_img_09}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_09}<br/><br/>
  <img src="${r.manual_img_10}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_10}<br/><br/>
  <img src="${r.manual_img_11}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_11}<br/><br/>
  <img src="${r.manual_img_12}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_12}<br/><br/>

  <h4 id="comPic">🔘 완 성 사 진</h4>
  <img src="${r.completePicture}" class="img-rounded" alt="Cinque Terre" style="width:600px; height:450px;">

  <h4 id="review">🔘 후 기</h4>
  <a href="<c:url value='/review/create.do?recipeId=${r.recipeId}'/>">후기 작성</a>
  <c:forEach var="review" items="${reviews}">
    <p>${review.nickname} : ${review.content} - ${review.formattedDateTime}</p>
  </c:forEach>
</div>

<%-- remote --%>
<div id="floatdiv" style="text-align:center;">
<ul>
<a href="#manual" style="background-color:pink;">조 리 방 법</a>
</ul>
<ul>
<a href="#comPic" style="background-color:pink;">완 성 사 진</a>
</ul>
<ul>
<a href='#review' style="background-color:pink;">후 기 보 기</a>
</ul>
</div>
</body>
</html>