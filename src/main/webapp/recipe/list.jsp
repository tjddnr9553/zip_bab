<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/list.css">
    <title>레시피 모음</title>
</head>
<body>
<c:set var="currentPage" value="${param.pageNum != null ? param.pageNum : 1}"/>
<div class="container">
    <h2 class="shadow-effect mt-3"><strong>레시피 모음</strong></h2>
    <h4><strong>편리하고 다양한 즐거운 집밥</strong></h4>
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
                    <li><a class="dropdown-item <c:if test='${empty param.order}'>active</c:if>" href="<c:url value="/recipe/listByPage.do"/>">일반</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 8}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=8"/>">조회순</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 6}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=6"/>">남성</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 7}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=7"/>">여성</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 5}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=5"/>">50대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 4}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=4"/>">40대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 3}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=3"/>">30대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 2}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=2"/>">20대</a></li>
                    <li><a class="dropdown-item <c:if test='${param.order eq 1}'>active</c:if>" href="<c:url value="/recipe/listByPage.do?order=1"/>">청소년</a></li>
                </ul>
            </div>
        </div>
        <form id="search-form" action="${pageContext.request.contextPath}/recipe/listByPage.do" method="GET"
              class="text-end ms-auto me-0 flex-grow-1">
            <input id="search-input" type="text" name="title" placeholder="Search.." style="" class="d-inline-block">
        </form>
    </div>
    <%-- 정렬 / 검색 끝 --%>

    <%-- 메인 list --%>
    <div class="container my-3">
        <div class="row row-cols-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-6">
            <c:forEach var="r" items="${list}">
                <div class="col mb-4">
                    <div class="card h-100" style="">
                        <a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}">
                            <img class="card-img-top img-fluid" src="${r.completePicture}"
                                 alt="${pageContext.request.contextPath }/images/logo/z_no_image.png"
                                 style="height:220px;">
                        </a>
                        <div class="card-body">
                            <div class="col text-center">
                                <h6 class="card-title" style="text-align:center"><strong>${r.title}</strong></h6>
                                <a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}"
                                   class="btn btn-success btn-sm">레시피</a>&emsp;

                                <!-- 북마크 여부 확인 -->
                                <c:set var="isBookmarked" value="false"/>
                                <c:forEach var="bookmark" items="${blist}">
                                    <c:if test="${bookmark.recipeId == r.recipeId}">
                                        <c:set var="isBookmarked" value="true"/>
                                        <!-- 중복된 recipeId가 있는 경우에만 북마크 취소 버튼 출력 -->
                                        <a href="${pageContext.request.contextPath}/bookmark/bookmark.do?recipeId=${r.recipeId}"
                                           class="btn btn-warning btn-sm"><i class="bi bi-check-circle-fill"></i>찜</a>
                                    </c:if>
                                </c:forEach>
                                <!-- 중복된 recipeId가 없는 경우 북마크 완료 버튼 출력 -->
                                <c:if test="${!isBookmarked}">
                                    <a href="${pageContext.request.contextPath}/bookmark/bookmark.do?recipeId=${r.recipeId}"
                                       class="btn btn-success btn-sm"><i class="bi bi-check-circle"></i>찜</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <%-- 메인 list 끝 --%>

    <!-- 페이징 처리 -->
    <ul class="pagination justify-content-center">

        <c:if test="${currentPage gt 1}">
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=1&${queryStr}">처음으로</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${currentPage - 1}&${queryStr}">이전</a>
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
                        <a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p}&${queryStr}">${p}</a>
                    </li>
                </c:if>
                <c:if test="${p ne currentPage}">
                    <li class="page-item">
                        <a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p}&${queryStr}">${p}</a>
                    </li>
                </c:if>
            </c:if>
        </c:forEach>

        <c:if test="${currentPage lt totalPage}">
            <li class='page-item'>
                <a class='page-link'
                   href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${currentPage + 1}&${queryStr}">다음</a>
            </li>
            <li class='page-item'>
                <a class='page-link'
                   href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${totalPage}&${queryStr}">마지막으로</a>
            </li>
        </c:if>
        <c:if test="${currentPage ge totalPage}">
            <li class="page-item disabled">
                <a class="page-link" tabindex="-1" href="#">다음</a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>