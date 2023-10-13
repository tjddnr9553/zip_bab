<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/detail.css">
  <link rel="stylesheet" href="css/remote.css">
</head>
<body data-context-path="${pageContext.request.contextPath }" data-recipe-id="${r.recipeId }" data-recipe-img="${r.completePicture }">
<div class="container">
   <br/><h2>${r.title }</h2><br/>
    <div class="grid-container">
        <div class="grid-item">
            <h3 id="ingredient"><span class="badge bg-secondary">🔘 재 료 목 록</span></h3>
        </div>
        <div class="grid-item">
            <h3 id="calorie"><span class="badge bg-secondary">🔘 열 량</span></h3>
        </div>
        <div class="grid-item">
            <h3 id="calorie"><span class="badge bg-secondary">🔘 조 리 방 법</span></h3>
        </div>
        <div><c:forEach var="ingredient" items="${ingredient}">
                   <c:if test="${not empty ingredient}">
                       <h6><p><strong><li><a href="${pageContext.request.contextPath}/recipe/getByIngredient.do?ingredient=${ingredient}">${ingredient}</a></li></strong></p></h6>
                   </c:if>
               </c:forEach></div>
            <div><h6><strong>${r.calorie } kcal</strong></h6></div>
            <div><h6><strong>${r.way }</strong></h6></div>
    </div>
    <br/><h3 id="manual"><span class="badge bg-secondary">🔘 조 리 방 법</h3>
 <div><img src="${r.manual_img_01}" class="img-rounded" onerror="this.style.display='none'" alt=/" class="img-thumbnail" id="image-01">&emsp; ${r.manual_01}</div>
 <div><img src="${r.manual_img_02}" class="img-rounded" onerror="this.style.display='none'" alt=/" class="img-thumbnail" id="image-02">&emsp; ${r.manual_02}</div>
 <div><img src="${r.manual_img_03}" class="img-rounded" onerror="this.style.display='none'" alt=/" class="img-thumbnail" id="image-03">&emsp; ${r.manual_03}</div>
 <div><img src="${r.manual_img_04}" class="img-rounded" onerror="this.style.display='none'" alt=/" class="img-thumbnail" id="image-04">&emsp; ${r.manual_04}</div>
 <div><img src="${r.manual_img_05}" class="img-rounded" onerror="this.style.display='none'" alt=/" class="img-thumbnail" id="image-05">&emsp; ${r.manual_05}</div>
 <div><img src="${r.manual_img_06}" class="img-rounded" onerror="this.style.display='none'" alt=/" class="img-thumbnail" id="image-06">&emsp; ${r.manual_06}</div>
 <br/>
 <h3 id="comPic"><span class="badge bg-secondary">🔘 완 성 사 진</span></h3>
 <div><img src="${r.completePicture}" class="img-rounded" alt=/" style="width:500px; height:400px;"></div><br/>

  <h3 class="mb-3" id="review"><span class="badge bg-secondary">🔘 후 기</span></h3>

  <button id="write-review" class="btn btn-primary">후기 작성</button>
  <div class="py-3 px-4 mb-5 border-bottom">
    <form id="write-review-form" action="${pageContext.request.contextPath}/review/create.do" method="POST" class="w-75 d-flex d-none">
      <input type="hidden" value="${recipeId}" name="recipeId">
      <textarea name="content" id="content" placeholder="후기를 입력해주세요." class="form-control flex-fill"></textarea>
      <input type="submit" value="작성" class="btn btn-primary align-self-end">
    </form>
  </div>
  <c:forEach var="review" items="${reviews}">
  <div class="review-item border-bottom pt-3 px-4 pb-5">
    <div class="review-info d-flex w-75">
      <div class="profile-img d-inline-block rounded-circle" style="">
        <c:if test="${review.profile != null}">
          <img src="${pageContext.request.contextPath}/images/profile/${review.profile}" alt="profile_img" class="img-fluid rounded-circle">
        </c:if>
        <c:if test="${review.profile == null}">
          <img src="${pageContext.request.contextPath}/images/profile/프사기본.jpg" alt="default_profile_img" class="img-fluid rounded-circle">
        </c:if>
      </div>
      <div class="">
        ${review.nickname} | <span class="text-secondary">${review.formattedDateTime}</span>&nbsp;
      </div>
      <div class="ms-auto">
        <c:if test="${sessionScope.loginId.memberId == review.memberId}">
          <a href="<c:url value='/review/edit.do?reviewId=${review.reviewId}&recipeId=${r.recipeId}'/>" class="btn btn-outline-dark btn-sm">수정</a>
          <form action="<c:url value='/review/delete.do'/>" class="d-inline-block" method="POST">
            <input type="hidden" name="reviewId" value="${review.reviewId}">
            <input type="hidden" name="recipeId" value="${review.recipeId}">
            <input type="submit" value="삭제" class="btn btn-outline-danger btn-sm">
          </form>
        </c:if>
      </div>
    </div>
    <div class="review-content mb-2">
        ${review.content}
    </div>
    <div class="review-like">
      <button id="r-like-${review.reviewId}" class="r-like-btn btn btn-outline-danger" data-review-id="${review.reviewId}" <c:if test="${loginId == null}">disabled</c:if>><i class="bi bi-heart-fill"></i> <span id="like-cnt-${review.reviewId}">${review.likeCnt}</span></button>
    </div>
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

<%-- view history --%>
<div id="viewHistory">

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/recipe/js/detail_view_history.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/recipe/js/review.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/recipe/js/review_like.js"></script>
</body>
</html>