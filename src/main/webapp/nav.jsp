<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<nav class="navbar navbar-expand-sm bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">🍚집밥</a>
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/recipe/list.do">레시피 보기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">재료 보기</a>
                </li>

                <c:if test="${sessionScope.loginId != null }">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                            ${sessionScope.loginId.getNickname()}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/member/edit.do?loginId=${sessionScope.loginId.getLoginId()}">수정페이지</a></li>
                        <li><a class="dropdown-item" href="/member/out.do">로그아웃</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
<%--                        <li><a class="dropdown-item" href="#">회원 탈퇴</a></li>--%>
                        </c:if>

                 <c:if test="${sessionScope.loginId == null }">
                        <li class="nav-item">
                            <a class="nav-link" href="/member/login.do">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/member/join.do">회원가입</a>
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