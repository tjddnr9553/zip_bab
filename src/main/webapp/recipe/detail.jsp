<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/remote.css">
  <style>
.img-rounded {
    width: 180px;
    height: 140px;
}
</style>
</head>
<body>
<div class="container">
  <h2>${r.title }</h2><br/>
  <h4 id="ingredient">🔘 재 료 목 록</h4>
  <div><c:forEach var="ingredient" items="${ingredient}">
           <c:if test="${not empty ingredient}">
               <li><a href="${pageContext.request.contextPath}/recipe/getByIngredient.do?ingredient=${ingredient}">${ingredient}</a></li>
           </c:if>
       </c:forEach></div><br/>
  <h4 id="calorie">🔘 열 량</h4>
  <div>${r.calorie } kcal</div><br/>
  <h4 id="manual">🔘 조 리 방 법</h4>
  <div><img src="${r.manual_img_01}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_01}</div>
  <div><img src="${r.manual_img_02}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_02}</div>
  <div><img src="${r.manual_img_03}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_03}</div>
  <div><img src="${r.manual_img_04}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_04}</div>
  <div><img src="${r.manual_img_05}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_05}</div>
  <div><img src="${r.manual_img_06}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_06}</div>
  <div><img src="${r.manual_img_07}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_07}</div>
  <div><img src="${r.manual_img_09}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_09}</div>
  <div><img src="${r.manual_img_08}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_08}</div>
  <div><img src="${r.manual_img_10}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_10}</div>
  <div><img src="${r.manual_img_11}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_11}</div>
  <div><img src="${r.manual_img_12}" class="img-rounded" onerror="this.style.display='none'" alt=/">&emsp; ${r.manual_12}</div>
  <h4 id="comPic">🔘 완 성 사 진</h4>
  <div><img src="${r.completePicture}" class="img-rounded" alt=/" style="width:500px; height:400px;"></div><br/>

  <h4 id="review">🔘 후 기</h4>
  <a href="<c:url value='/review/create.do?recipeId=${r.recipeId}'/>">후기 작성</a>
  <c:forEach var="review" items="${reviews}">
    <div>
      ${review.nickname} : ${review.content} - ${review.formattedDateTime} <a href="<c:url value='/review/edit.do?reviewId=${review.reviewId}&recipeId=${r.recipeId}'/>">수정</a>
      <form action="<c:url value='/review/delete.do'/>" class="d-inline-block" method="POST">
        <input type="hidden" name="reviewId" value="${review.reviewId}">
        <input type="hidden" name="recipeId" value="${review.recipeId}">
        <input type="submit" value="삭제">
      </form>
    </div>
  </c:forEach>
</div>

<%-- remote --%>                
<div id="floatdiv" style="text-align:center;">
<ul>
<a href="#ingredient" style="background-color:pink;">재 료 목 록</a>
</ul>
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