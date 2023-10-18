<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/list.css">
    <title>Document</title>
</head>
<body>
<c:set var="currentPage" value="${param.pageNum != null ? param.pageNum : 1}"/>
<div class="container">
    <h2 class="shadow-effect mt-3"><strong>유저 레시피 모음</strong></h2>
    <h4><strong>편리하고 다양한 즐거운 집밥</strong></h4>

    <!-- 로그인 여부 검사후 글작성 버튼 -->
    <c:if test="${not empty sessionScope.loginId}">
        <p>
            <button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/memberrecipe/create.do'">레시피 작성하기
            </button>
        </p>
    </c:if>

    <%-- 정렬 / 검색 --%>
    <div id="sort" class="d-flex">
        <div id="order">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <c:if test='${empty param.order}'>정렬</c:if>
                    <c:if test='${param.order eq 1}'>청소년</c:if>
                    <c:if test='${param.order eq 2}'>20대</c:if>
                    <c:if test='${param.order eq 3}'>30대</c:if>
                    <c:if test='${param.order eq 4}'>40대</c:if>
                    <c:if test='${param.order eq 5}'>50대</c:if>
                    <c:if test='${param.order eq 6}'>남성</c:if>
                    <c:if test='${param.order eq 7}'>여성</c:if>
                    <c:if test='${param.order eq 8}'>조회순</c:if>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item <c:if test='${empty param.order}'>active</c:if>" href="<c:url value="/memberrecipe/list.do"/>">일반</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 8}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=8"/>">조회순</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 6}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=6"/>">남성</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 7}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=7"/>">여성</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 5}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=5"/>">50대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 4}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=4"/>">40대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 3}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=3"/>">30대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 2}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=2"/>">20대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 1}'>active</c:if>" href="<c:url value="/memberrecipe/list.do?order=1"/>">청소년</a></li>
                </ul>
            </div>
        </div>
        <form id="search-form" action="${pageContext.request.contextPath}/memberrecipe/list.do" method="GET"
              class="text-end ms-auto me-0 flex-grow-1">
            <input id="search-input" type="text" value="${param.title}${param.ingredient}" name="<c:if test='${empty param.ingredient}'>title</c:if><c:if test='${not empty param.ingredient}'>ingredient</c:if>" placeholder="Search.." style="" class="d-inline-block">
        </form>
        <div class="dropdown ms-2">
            <button id="search-type" class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                <c:if test='${empty param.ingredient}'>이름</c:if>
                <c:if test='${not empty param.ingredient}'>재료</c:if>
            </button>
            <ul class="dropdown-menu">
                <li><button id="search-title" class="dropdown-item <c:if test='${empty param.ingredient}'>active</c:if>" >이름</button></li>
                <li><button id="search-ingredient" class="dropdown-item <c:if test='${not empty param.ingredient}'>active</c:if>">재료</button></li>
            </ul>
        </div>
    </div>
    <%-- 정렬 / 검색 끝 --%>

    <%-- 메인 list --%>
    <div class="container my-3">
        <div class="row row-cols-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-6">
            <c:forEach var="r" items="${list}">
                <div class="col mb-4">
                    <div class="card h-100" style="">
                        <a href="${pageContext.request.contextPath}/memberrecipe/detail.do?memberRecipeId=${r.memberRecipeId}">
                            <c:if test="${not empty r.completePicture}">
                                <img class="card-img-top img-fluid" src="<c:url value="/images/memberrecipe/${r.completePicture}"/>"
                                     onerror="this.src='${pageContext.request.contextPath }/images/logo/z_no_image.png'"
                                     alt="${r.completePicture}"
                                     style="height:220px;">
                            </c:if>
                            <c:if test="${empty r.completePicture}">
                                <img class="card-img-top img-fluid" src="<c:url value="/images/logo/z_no_image.png"/>"
                                     alt="이미지 없음"
                                     style="height:220px;">
                            </c:if>

                        </a>
                        <div class="card-body">
                            <div class="col text-center">
                                <h6 class="card-title" style="text-align:center"><strong>${r.title}</strong></h6>
                                <a href="${pageContext.request.contextPath}/memberrecipe/detail.do?memberRecipeId=${r.memberRecipeId}"
                                   class="btn btn-success btn-sm">레시피</a>&emsp;

                                <!-- 북마크 여부 확인 -->
                                <form action="${pageContext.request.contextPath}/memberrecipe/bookmark.do" method="POST" class="d-inline-block">
                                    <!-- 중복된 recipeId가 있는 경우에만 북마크 취소 버튼 출력 -->
                                    <input type="hidden" name="recipeId" value="${r.memberRecipeId}">
                                    <c:if test="${r.isBooked eq 1}">
                                        <button class="btn btn-warning btn-sm"><i class="bi bi-check-circle-fill"></i>찜</button>
                                    </c:if>
                                    <!-- 중복된 recipeId가 없는 경우 북마크 완료 버튼 출력 -->
                                    <c:if test="${r.isBooked eq 0}">
                                        <button class="btn btn-success btn-sm"><i class="bi bi-check-circle"></i>찜</button>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%-- 메인 list 끝 --%>

    <!-- 페이징 -->
    <ul class="pagination justify-content-center">

        <c:if test="${currentPage gt 1}">
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=1&${queryStr}">처음으로</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=${currentPage - 1}&${queryStr}">이전</a>
            </li>
        </c:if>
        <c:if test="${currentPage le 1}">
            <li class="page-item disabled">
                <a class="page-link" tabindex="-1" href="#">이전</a>
            </li>
        </c:if>

        <c:forEach var="p" begin="1" end="${totalPage}">
            <c:if test="${p ge currentPage - 5 and p le currentPage + 5}">
                <c:if test="${p eq currentPage}">
                    <li class="page-item active">
                        <a class="page-link" href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=${p}&${queryStr}">${p}</a>
                    </li>
                </c:if>
                <c:if test="${p ne currentPage}">
                    <li class="page-item">
                        <a class="page-link" href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=${p}&${queryStr}">${p}</a>
                    </li>
                </c:if>
            </c:if>
        </c:forEach>

        <c:if test="${currentPage lt totalPage}">
            <li class='page-item'>
                <a class='page-link'
                   href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=${currentPage + 1}&${queryStr}">다음</a>
            </li>
            <li class='page-item'>
                <a class='page-link'
                   href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=${totalPage}&${queryStr}">마지막으로</a>
            </li>
        </c:if>
        <c:if test="${currentPage ge totalPage}">
            <li class="page-item disabled">
                <a class="page-link" tabindex="-1" href="#">다음</a>
            </li>
        </c:if>
    </ul>
    <!-- 페이징 끝 -->
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/memberrecipe/js/list.js"></script>
</body>
</html>