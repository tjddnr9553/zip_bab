<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<nav class="navbar navbar-expand-sm bg-body-tertiary">
    <div class="container-fluid">
        <div class="d-inline-block" style="width:40px;">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath }/images/logo/main_logo.png" alt="logo" class="img-fluid">
            </a>
        </div>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">집밥</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link active" aria-current="page" href="#">집밥</a>--%>
                <%--                </li>--%>
                <li class="nav-item">
<<<<<<< HEAD
                    <a class="nav-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=1">레시피
                        보기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/memberrecipe/list.do?pageNum=1">유저 레시피
                        보기</a>
                </li>
=======
                    <a class="nav-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=1">레시피 보기</a>
                </li>&emsp;
>>>>>>> master
                <li class="nav-item">
                    <a class="nav-link" href="#">재료 보기</a>
                </li>&emsp;

                <c:if test="${sessionScope.loginId != null }">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                            ${sessionScope.loginId.getNickname()}
                    </a>
                    <ul class="dropdown-menu">
<<<<<<< HEAD
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/member/edit.do?loginId=${sessionScope.loginId.getLoginId()}">수정페이지</a>
                        </li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/out.do">로그아웃</a>
                        </li>
=======
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/follow/mypage.do?loginId=${sessionScope.loginId.loginId}">마이페이지</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/edit.do?loginId=${sessionScope.loginId.getLoginId()}">수정페이지</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/out.do">로그아웃</a></li>
>>>>>>> master
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                            <%--                        <li><a class="dropdown-item" href="#">회원 탈퇴</a></li>--%>
                        </c:if>

                        <c:if test="${sessionScope.loginId == null }">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/member/login.do">로그인</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/member/join.do">회원가입</a>
                            </li>
                        </c:if>
                    </ul>
                </li>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>--%>
                <%--                </li>--%>
            </ul>
            <%--            <form class="d-flex" role="search">--%>
            <%--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
            <%--                <button class="btn btn-outline-success" type="submit">Search</button>--%>
            <%--            </form>--%>
        </div>
    </div>
</nav>