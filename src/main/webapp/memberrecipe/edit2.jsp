<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>유저 레시피 수정</title>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet"/>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
</head>
<form id="ef" style="
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 300px;
    padding: 20px;
    background-color: #f8f9fa;
    border-radius: 10px;
    box-shadow: 0px 0px 15px rgba(0,0,0,0.1);
" action="${pageContext.request.contextPath}/memberrecipe/imgedit.do" method="post" enctype="multipart/form-data">

    <input type="file" name="f" style="width:100%;margin-bottom:10px;box-sizing:border-box;"><br/>
    <input type="hidden" name="memberRecipeId" value="${memberRecipe.memberRecipeId}">
    <input type="hidden" name="imgname" id="imgname">
    <input type="submit" value=등록 style="display:block;width:100%;padding-top:.5rem;
        padding-bottom:.5rem;background-color:#E54C5C; color:white; border:none; border-radius:.25rem;text-align:center;">
    <input type="button" id=cancel value=취소 style="display:block;width:100%; margin-top:.5rem;
        padding-top:.5rem;padding-bottom:.5rem;border:none;background-color:#6c757d;color:white;border-radius:.25rem;text-align:center;">
</form>
<body id="page-top">
<!-- Contact Section-->
<section class="page-section" id="contact">
    <div class="container">
        <!-- Contact Section Heading-->
        <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">레시피 수정</h2>
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
            <div class="divider-custom-line"></div>
        </div>
        <!-- Contact Section Form-->
        <div class="row justify-content-center">
            <div class="col-lg-8 col-xl-7">
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form id="contactForm" action="${pageContext.request.contextPath}/memberrecipe/edit.do" method="post"
                      enctype="multipart/form-data" data-sb-form-api-token="API_TOKEN">
                    <input type="hidden" name="memberRecipeId" value="${memberRecipe.memberRecipeId}" readonly>
                    <input type="hidden" name="memberId" value="${sessionScope.loginId.memberId}" readonly>
                    <!-- title input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="title" name="title" type="text" value="${memberRecipe.title}"
                               placeholder="Enter your title..." data-sb-validations="required"/>
                        <label for="title">제목</label>
                        <div class="invalid-feedback" data-sb-feedback="title:required">A title is required.</div>
                    </div>
                    <!-- SubTitle input-->
                    <div class="form-floating mb-3">
                        <textarea class="form-control" id="subTitle" name="subTitle" type="text"
                                  placeholder="Enter your SubTitle here..." style="height: 10rem"
                                  data-sb-validations="required">${memberRecipe.subTitle}</textarea>
                        <label for="subTitle">부제목</label>
                        <div class="invalid-feedback" data-sb-feedback="subTitle:required">A subTitle is required.</div>
                    </div>
                    <!-- way input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="way" name="way" value="${memberRecipe.way}" type="text"
                               placeholder="Enter your way..." data-sb-validations="required"/>
                        <label for="way">요리종류</label>
                        <div class="invalid-feedback" data-sb-feedback="way:required">A way is required.</div>
                    </div>
                    <!-- ingredientInfo input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="ingredientInfo" value="${memberRecipe.ingredientInfo}"
                               name="ingredientInfo" type="text" placeholder="Enter your name..."
                               data-sb-validations="required"/>
                        <label for="ingredientInfo">재료</label>
                        <div class="invalid-feedback" data-sb-feedback="ingredientInfo:required">A ingredientInfo is
                            required.
                        </div>
                    </div>
                    <!-- 메뉴얼1 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual1" value="${memberRecipe.manual_01}" name="manual_01"
                               type="text" placeholder="Enter your menual1..." data-sb-validations="required"/>
                        <label for="menual1">메뉴얼1</label>
                        <div class="invalid-feedback" data-sb-feedback="menual1:required">A menual1 is required.</div>
                    </div>
                    <!-- 메뉴얼2 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual2" value="${memberRecipe.manual_02}" name="manual_02"
                               type="text" placeholder="Enter your menual2..." data-sb-validations="required"/>
                        <label for="menual2">메뉴얼2</label>
                        <div class="invalid-feedback" data-sb-feedback="menual2:required">A menual2 is required.</div>
                    </div>
                    <!-- 메뉴얼3 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual3" value="${memberRecipe.manual_03}" name="manual_03"
                               type="text" placeholder="Enter your menual3..." data-sb-validations="required"/>
                        <label for="menual3">메뉴얼3</label>
                        <div class="invalid-feedback" data-sb-feedback="menual3:required">A menual3 is required.</div>
                    </div>
                    <!-- 메뉴얼4 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="메뉴얼4" value="${memberRecipe.manual_04}" name="manual_04"
                               type="text" placeholder="Enter your 메뉴얼4..." data-sb-validations="required"/>
                        <label for="메뉴얼4">메뉴얼4</label>
                        <div class="invalid-feedback" data-sb-feedback="메뉴얼4:required">A 메뉴얼4 is required.</div>
                    </div>
                    <!-- 메뉴얼5 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual5" value="${memberRecipe.manual_05}" name="manual_05"
                               type="text" placeholder="Enter your menual5..." data-sb-validations="required"/>
                        <label for="menual5">메뉴얼5</label>
                        <div class="invalid-feedback" data-sb-feedback="menual5:required">A menual5 is required.</div>
                    </div>
                    <!-- 메뉴얼6 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual6" value="${memberRecipe.manual_06}" name="manual_06"
                               type="text" placeholder="Enter your menual6..." data-sb-validations="required"/>
                        <label for="menual6">메뉴얼6</label>
                        <div class="invalid-feedback" data-sb-feedback="menual6:required">A menual6 is required.</div>
                    </div>
                    <!-- 메뉴얼7 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual7" value="${memberRecipe.manual_07}" name="manual_07"
                               type="text" placeholder="Enter your menual7..." data-sb-validations="required"/>
                        <label for="menual7">메뉴얼7</label>
                        <div class="invalid-feedback" data-sb-feedback="menual7:required">A menual7 is required.</div>
                    </div>
                    <!-- 메뉴얼8 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual8" value="${memberRecipe.manual_08}" name="manual_08"
                               type="text" placeholder="Enter your menual8..." data-sb-validations="required"/>
                        <label for="menual8">메뉴얼8</label>
                        <div class="invalid-feedback" data-sb-feedback="menual8:required">A menual8 is required.</div>
                    </div>
                    <!-- 메뉴얼9 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual9" value="${memberRecipe.manual_09}" name="manual_09"
                               type="text" placeholder="Enter your menual9..." data-sb-validations="required"/>
                        <label for="menual9">메뉴얼9</label>
                        <div class="invalid-feedback" data-sb-feedback="menual9:required">A menual9 is required.</div>
                    </div>
                    <!-- 메뉴얼10 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual10" value="${memberRecipe.manual_10}" name="manual_10"
                               type="text" placeholder="Enter your menual10..." data-sb-validations="required"/>
                        <label for="menual10">메뉴얼10</label>
                        <div class="invalid-feedback" data-sb-feedback="menual10:required">A menual10 is required.</div>
                    </div>
                    <!-- 메뉴얼11 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual11" value="${memberRecipe.manual_11}" name="manual_11"
                               type="text" placeholder="Enter your menual11..." data-sb-validations="required"/>
                        <label for="menual11">메뉴얼11</label>
                        <div class="invalid-feedback" data-sb-feedback="menual11:required">A menual11 is required.</div>
                    </div>
                    <!-- 메뉴얼12 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="menual12" value="${memberRecipe.manual_12}" name="manual_12"
                               type="text" placeholder="Enter your menual12..." data-sb-validations="required"/>
                        <label for="menual12">메뉴얼12</label>
                        <div class="invalid-feedback" data-sb-feedback="menual12:required">A menual12 is required.</div>
                    </div>
                    <!-- 사진1 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_01}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_01 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_1">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_1">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_01}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_1">
                        </c:if>
                    </div>
                    <!-- 사진2 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_02}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_02 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_2">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_2">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_02}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_2">
                        </c:if>
                    </div>
                    <!-- 사진3 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_03}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_03 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_3">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_3">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_03}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_3">
                        </c:if>
                    </div>
                    <!-- 사진4 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_04}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_04 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_4">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_4">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_04}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_4">
                        </c:if>
                    </div>
                    <!-- 사진5 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_05}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_05 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_5">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_5">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_05}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_5">
                        </c:if>
                    </div>
                    <!-- 사진6 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_06}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_06 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_6">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_6">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_06}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_6">
                        </c:if>
                    </div>
                    <!-- 사진7 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_07}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_07 }"
                                 style="width:200px;height:200px">
                            <%--                    <input type="file" name="manual_img_07" value="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_07 }">--%>
                            <input type="button" value="변경" class="imgedit" val="manual_img_7">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_7">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_07}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_7">
                        </c:if>
                    </div><!-- 사진8 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_08}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_08 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_8">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_8">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_08}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_8">
                        </c:if>
                    </div><!-- 사진9 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_09}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_09 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_9">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_9">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_09}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_9">
                        </c:if>
                    </div>
                    <!-- 사진10 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_10}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_10}"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_10">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_10">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_10}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="img10">
                        </c:if>
                    </div>
                    <!-- 사진11 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_11}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_11}"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_11">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_11">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_11}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_11">
                        </c:if>
                    </div>
                    <!-- 사진12 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.manual_img_12}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.manual_img_12 }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_12">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_12">
                        </c:if>
                        <c:if test="${empty memberRecipe.manual_img_12}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_12">
                        </c:if>
                    </div>
                    <!-- 완성사진 input-->
                    <div class="form-floating mb-3">
                        <c:if test="${not empty memberRecipe.completePicture}">
                            <img src="${pageContext.request.contextPath}/images/memberrecipe/${memberRecipe.completePicture }"
                                 style="width:200px;height:200px">
                            <input type="button" value="변경" class="imgedit" val="manual_img_13">
                            <input type="button" value="삭제" class="imgdel" val="manual_img_13">
                        </c:if>
                        <c:if test="${empty memberRecipe.completePicture}">
                            이미지 없음
                            <input type="button" value="이미지 추가" class="imgedit" val="manual_img_13">
                        </c:if>
                    </div>


                    <!-- 열량 input-->
                    <div class="form-floating mb-3">
                        <input class="form-control" id="calorie" value="${memberRecipe.calorie}" type="text"
                               name="calorie"
                               placeholder="Enter your calorie..." data-sb-validations="required"/>
                        <label for="calorie">칼로리</label>
                        <div class="invalid-feedback" data-sb-feedback="calorie:required">A calorie is required.</div>
                    </div>

                    <!-- Submit success message-->
                    <!---->
                    <!-- This is what your users will see when the form-->
                    <!-- has successfully submitted-->
                    <div class="d-none" id="submitSuccessMessage">
                        <div class="text-center mb-3">
                            <div class="fw-bolder">Form submission successful!</div>
                            To activate this form, sign up at
                            <br/>
                            <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                        </div>
                    </div>
                    <!-- Submit error message-->
                    <!---->
                    <!-- This is what your users will see when there is-->
                    <!-- an error submitting the form-->
                    <div class="d-none" id="submitErrorMessage">
                        <div class="text-center text-danger mb-3">Error sending message!</div>
                    </div>
                    <!-- Submit Button-->
                    <button class="btn btn-primary btn-xl" type="submit">Send</button>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- * *                               SB Forms JS                               * *-->
<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
