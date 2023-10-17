<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/naverShopping.css">
    <title>Title</title>
    <script type="text/javascript">
        window.addEventListener('DOMContentLoaded', function () {
            // 모든 카드 요소들을 선택
            var cards = document.querySelectorAll('.card');

            // 최대 높이 값을 저장할 변수 초기화
            var maxHeight = 0;

            // 모든 카드 요소들의 높이 중에서 가장 큰 값을 찾음
            cards.forEach(function (card) {
                if (card.offsetHeight > maxHeight) {
                    maxHeight = card.offsetHeight;
                }
            });

            // 모든 카드 요소들의 높이를 최대 높이 값으로 설정
            cards.forEach(function (card) {
                card.style.height = maxHeight + 'px';
            });
        });
    </script>
</head>
<body>
<h3>재료 구매하기</h3>
<div class="card-container">
    <c:forEach var="i" items="${items}" varStatus="loop">
        <div class="col-md-3">
            <div class="card h-100" style="width: 14rem;">
                <a href="${i.link}"><img src="${i.image}" style="width:12.7rem; height:12.7rem;"></a>
                <table>
                    <tr>
                        <th>상품명</th>
                        <td>${i.title}</td>
                    </tr>
                    <tr>
                        <th>가&emsp;격</th>
                        <td>${i.price} 원</td>
                    </tr>
                    <tr>
                        <th>판매처</th>
                        <td>${i.mallName}</td>
                    </tr>
                    <tr>
                        <th>브랜드</th>
                        <td>${i.brand}</td>
                    </tr>
                    <tr>
                        <th>제조사</th>
                        <td>${i.maker}</td>
                    </tr>
                </table>
            </div>
        </div>
    </c:forEach>
</div>
<br/>
</body>
</html>