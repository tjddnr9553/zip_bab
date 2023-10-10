<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/memberrecipe/create.do" method="post" enctype="multipart/form-data">

    <table border="1">
        <tr>
            <th>memberId</th>
<%--            <td><input type="hidden" name="memberId" value="${sessionScope.loginId }" readonly></td>--%>
            <td><input type="hidden" name="memberId" value="1" readonly></td>
        </tr>
        <tr>
            <th>title</th>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <th>subTitle</th>
            <td><textarea rows="5" cols="20" name="subTitle"></textarea></td>
        </tr>
        <tr>
<%--            요리방법 : 찌기 --%>
            <th>way</th>
            <td><input type="text" name="way"></td>
        </tr>
        <tr>
            <th>ingredientInfo</th>
            <td><input type="text" name="ingredientInfo"></td>
        </tr>
        <tr>
            <th>메뉴얼1</th>
            <td><input type="text" name="manual_01"></td>
        </tr>
        <tr>
            <th>메뉴얼2</th>
            <td><input type="text" name="manual_02"></td>
        </tr>
        <tr>
            <th>메뉴얼3</th>
            <td><input type="text" name="manual_03"></td>
        </tr>
        <tr>
            <th>메뉴얼4</th>
            <td><input type="text" name="manual_04"></td>
        </tr>
        <tr>
            <th>메뉴얼5</th>
            <td><input type="text" name="manual_05"></td>
        </tr>
        <tr>
            <th>메뉴얼6</th>
            <td><input type="text" name="manual_06"></td>
        </tr>
        <tr>
            <th>메뉴얼7</th>
            <td><input type="text" name="manual_07"></td>
        </tr>
        <tr>
            <th>메뉴얼8</th>
            <td><input type="text" name="manual_08"></td>
        </tr>
        <tr>
            <th>메뉴얼9</th>
            <td><input type="text" name="manual_09"></td>
        </tr>
        <tr>
            <th>메뉴얼10</th>
            <td><input type="text" name="manual_10"></td>
        </tr>
        <tr>
            <th>메뉴얼11</th>
            <td><input type="text" name="manual_11"></td>
        </tr>
        <tr>
            <th>메뉴얼12</th>
            <td><input type="text" name="manual_12"></td>
        </tr>
        <tr>
            <th>사진1</th>
            <td><input type="file" name="img1"></td>
        </tr>
        <tr>
            <th>사진2</th>
            <td><input type="file" name="img2"></td>
        </tr>
        <tr>
            <th>사진3</th>
            <td><input type="file" name="img3"></td>
        </tr>
        <tr>
            <th>사진4</th>
            <td><input type="file" name="img4"></td>
        </tr>
        <tr>
            <th>사진5</th>
            <td><input type="file" name="img5"></td>
        </tr>
        <tr>
            <th>사진6</th>
            <td><input type="file" name="img6"></td>
        </tr>
        <tr>
            <th>사진7</th>
            <td><input type="file" name="img7"></td>
        </tr>
        <tr>
            <th>사진8</th>
            <td><input type="file" name="img8"></td>
        </tr>
        <tr>
            <th>사진9</th>
            <td><input type="file" name="img9"></td>
        </tr>
        <tr>
            <th>사진10</th>
            <td><input type="file" name="img10"></td>
        </tr>
        <tr>
            <th>사진11</th>
            <td><input type="file" name="img11"></td>
        </tr>
        <tr>
            <th>사진12</th>
            <td><input type="file" name="img12"></td>
        </tr>
        <tr>
            <th>완성 사진</th>
            <td><input type="file" name="completePicture"></td>
        </tr>
        <tr>
            <th>열량</th>
            <td><input type="text" name="calorie"></td>
        </tr>

        <tr>
            <th>등록</th>
            <td><input type="submit" value="등록"></td>
        </tr>
    </table>
</form>
</body>
</html>
