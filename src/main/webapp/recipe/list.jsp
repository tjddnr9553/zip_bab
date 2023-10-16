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
    <form action="${pageContext.request.contextPath}/recipe/getByTitle.do?pageNum=${currentPage}" method="GET"
          class="text-end">
        <input type="text" name="title" placeholder="Search.." style="" class="d-inline-block">
    </form>
    <div class="container my-3">
        <div class="row row-cols-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-6">
            <c:forEach var="r" items="${list}">
                <div class="col mb-4">
                    <div class="card h-100" style="">
                        <a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}">
                            <img class="card-img-top img-fluid" src="${r.completePicture}"
                                 alt="${pageContext.request.contextPath }/images/recipe/default.jpg"
                                 style="width:250px;height:220px;">
                        </a>
                        <div class="card-body">
                            <div class="col text-center">
                                <h6 class="card-title" style="text-align:center"><strong>${r.title}</strong></h6>
                                <a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}"
                                   class="btn btn-success btn-sm">레시피</a>&emsp;
                                <a href="${pageContext.request.contextPath}/bookmark/bookmark.do?recipeId=${r.recipeId}&pageNum=${currentPage}"
                                   class="btn btn-success btn-sm">북마크</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- 페이징 처리 -->
    <ul class="pagination justify-content-center">

        <c:if test="${currentPage > 1}">
            <c:if test="${empty title && empty ingredient}">
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${currentPage - 1}">Previous</a>
                </li>
            </c:if>
            <c:if test="${not empty title}">
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/recipe/getByTitle.do?title=${title}&pageNum=${currentPage - 1}">Previous</a>
                </li>
            </c:if>
            <c:if test="${not empty ingredient}">
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/recipe/getByIngredient.do?ingredient=${ingredient}&pageNum=${currentPage - 1}">Previous</a>
                </li>
            </c:if>
        </c:if>

        <c:if test="${currentPage > 0}">
            <c:set var="startPage" value="${(currentPage - 1) / 10 * 10 + 1}"/>
            <c:set var="endPage" value="${startPage + 9}"/>
            <c:if test="${endPage > total}">
                <c:set var="endPage" value="${total}"/>
            </c:if>
            <c:if test="${empty title && empty ingredient}">
                <c:forEach var="p" begin="${startPage}" end="${endPage}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p}">${p}</a>
                    </li>
                </c:forEach>
            </c:if>
            <c:if test="${not empty title}">
                <c:forEach var="p" begin="${startPage}" end="${endPage}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/recipe/getByTitle.do?title=${title}&pageNum=${p}">${p}</a>
                    </li>
                </c:forEach>
            </c:if>
            <c:if test="${not empty ingredient}">
                <c:forEach var="p" begin="${startPage}" end="${endPage}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/recipe/getByIngredient.do?ingredient=${ingredient}&pageNum=${p}">${p}</a>
                    </li>
                </c:forEach>
            </c:if>
        </c:if>

        <c:if test="${currentPage < total}">
            <c:if test="${empty title && empty ingredient}">
                <li class='page-item'>
                    <a class='page-link'
                       href='${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${currentPage + 1}'>Next</a>
                </li>
            </c:if>
            <c:if test="${not empty title}">
                <li class='page-item'>
                    <a class='page-link'
                       href='${pageContext.request.contextPath}/recipe/getByTitle.do?title=${title}&pageNum=${currentPage + 1}'>Next</a>
                </li>
            </c:if>
            <c:if test="${not empty ingredient}">
                <li class='page-item'>
                    <a class='page-link'
                       href='${pageContext.request.contextPath}/recipe/recipe/getByIngredient.do?ingredient=${ingredient}&pageNum=${currentPage + 1}'>Next</a>
                </li>
            </c:if>
        </c:if>
    </ul>
</div>
</body>
</html>