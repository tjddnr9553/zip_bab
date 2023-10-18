<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>유저 레시피 수정</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#ef").hide();
            $(".imgedit").click(function () {
                $("#imgname").val($(this).attr("val"));
                $("#ef").show();
            });

            $(".imgdel").click(function () {
                console.log("실행은 되는거니?");
                let imgNum = $(this).attr("val");
                console.log(imgNum);
                location.href = "${pageContext.request.contextPath}/memberrecipe/imgdel.do?memberRecipeId=${memberRecipe.memberRecipeId}&imgNum=" + imgNum;
            });

            $("#cancel").click(function () {
                $("#ef").hide();
            });
        });
    </script>

    <form id="ef" style="position:absolute;top:100px;height:100px;background-color:yellow"
          action="${pageContext.request.contextPath}/memberrecipe/imgedit.do" method="post"
          enctype="multipart/form-data">
        <input type="file" name="f"><br/>
        <input type="hidden" name="memberRecipeId" value="${memberRecipe.memberRecipeId}">
        <input type="hidden" name="imgname" id="imgname">
        <input type="submit" value="등록"> <input type="button" id="cancel" value="취소">
    </form>
</head>
<body>
<form action="${pageContext.request.contextPath}/memberrecipe/edit.do" method="post" enctype="multipart/form-data">

    <table border="1">
        <tr>
            <%--            <th>memberRecipeId</th>--%>
            <td><input type="hidden" name="memberRecipeId" value="${memberRecipe.memberRecipeId}" readonly></td>
        </tr>
        <tr>
            <%--            <th>memberId</th>--%>
            <td><input type="hidden" name="memberId" value="${sessionScope.loginId}" readonly></td>
        </tr>
        <tr>
            <th>title</th>
            <td><input type="text" name="title" value="${memberRecipe.title}"></td>
        </tr>
        <tr>
            <th>subTitle</th>
            <td><textarea rows="5" cols="20" name="subTitle">${memberRecipe.subTitle}</textarea></td>
        </tr>
        <tr>
            <th>way</th>
            <td><input type="text" name="way" value="${memberRecipe.way}"></td>
        </tr>
        <tr>
            <th>ingredientInfo</th>
            <td><input type="text" name="ingredientInfo" value="${memberRecipe.ingredientInfo}"></td>
        </tr>
        <tr>
            <th>메뉴얼1</th>
            <td><input type="text" name="manual_01" value="${memberRecipe.manual_01}"></td>
        </tr>
        <tr>
            <th>메뉴얼2</th>
            <td><input type="text" name="manual_02" value="${memberRecipe.manual_02}"></td>
        </tr>
        <tr>
            <th>메뉴얼3</th>
            <td><input type="text" name="manual_03" value="${memberRecipe.manual_03}"></td>
        </tr>
        <tr>
            <th>메뉴얼4</th>
            <td><input type="text" name="manual_04" value="${memberRecipe.manual_04}"></td>
        </tr>
        <tr>
            <th>메뉴얼5</th>
            <td><input type="text" name="manual_05" value="${memberRecipe.manual_05}"></td>
        </tr>
        <tr>
            <th>메뉴얼6</th>
            <td><input type="text" name="manual_06" value="${memberRecipe.manual_06}"></td>
        </tr>
        <tr>
            <th>메뉴얼7</th>
            <td><input type="text" name="manual_07" value="${memberRecipe.manual_07}"></td>
        </tr>
        <tr>
            <th>메뉴얼8</th>
            <td><input type="text" name="manual_08" value="${memberRecipe.manual_08}"></td>
        </tr>
        <tr>
            <th>메뉴얼9</th>
            <td><input type="text" name="manual_09" value="${memberRecipe.manual_09}"></td>
        </tr>
        <tr>
            <th>메뉴얼10</th>
            <td><input type="text" name="manual_10" value="${memberRecipe.manual_10}"></td>
        </tr>
        <tr>
            <th>메뉴얼11</th>
            <td><input type="text" name="manual_11" value="${memberRecipe.manual_11}"></td>
        </tr>
        <tr>
            <th>메뉴얼12</th>
            <td><input type="text" name="manual_12" value="${memberRecipe.manual_12}"></td>
        </tr>
        <tr>
            <th>사진1</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_01}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_01 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_1">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_1">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_01}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_1">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진2</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_02}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_02 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_2">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_2">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_02}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_2">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진3</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_03}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_03 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_3">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_3">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_03}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_3">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진4</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_04}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_04 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_4">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_4">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_04}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_4">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진5</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_05}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_05 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_5">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_5">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_05}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_5">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진6</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_06}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_06 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_6">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_6">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_06}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_6">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진7</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_07}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_07 }" style="width:200px;height:200px">
                    <%--                    <input type="file" name="manual_img_07" value="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_07 }">--%>
                    <input type="button" value="변경" class="imgedit" val="manual_img_7">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_7">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_07}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_7">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진8</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_08}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_08 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_8">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_8">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_08}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_8">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진9</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_09}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_09 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_9">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_9">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_09}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_9">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진10</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_10}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_10}" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_10">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_10">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_10}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="img10">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진11</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_11}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_11}" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_11">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_11">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_11}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_11">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>사진12</th>
            <td>
                <c:if test="${not empty memberRecipe.manual_img_12}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_12 }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_12">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_12">
                </c:if>
                <c:if test="${empty memberRecipe.manual_img_12}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_12">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>완성 사진</th>
            <td>
                <c:if test="${not empty memberRecipe.completePicture}">
                    <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.completePicture }" style="width:200px;height:200px">
                    <input type="button" value="변경" class="imgedit" val="manual_img_13">
                    <input type="button" value="삭제" class="imgdel" val="manual_img_13">
                </c:if>
                <c:if test="${empty memberRecipe.completePicture}">
                    이미지 없음
                    <input type="button" value="이미지 추가" class="imgedit" val="manual_img_13">
                </c:if>
            </td>
        </tr>
        <tr>
            <th>열량</th>
            <td><input type="text" name="calorie" value="${memberRecipe.calorie}"></td>
        </tr>

        <tr>
            <th>등록</th>
            <td><input type="submit" value="등록"></td>
        </tr>
    </table>
</form>
</body>
</html>
