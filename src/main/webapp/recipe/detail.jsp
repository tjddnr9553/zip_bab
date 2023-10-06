<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>${r.title }</h2><br/><br/>
  <h4>🔘 조 리 방 법</h4>
  <img src="${r.manual_img_01}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_01}<br/><br/>
  <img src="${r.manual_img_02}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_02}<br/><br/>
  <img src="${r.manual_img_03}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_03}<br/><br/>
  <img src="${r.manual_img_04}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_04}<br/><br/>
  <img src="${r.manual_img_05}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_05}<br/><br/>
  <img src="${r.manual_img_06}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_06}<br/><br/>
  <img src="${r.manual_img_07}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_07}<br/><br/>
  <img src="${r.manual_img_08}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_08}<br/><br/>
  <img src="${r.manual_img_09}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_09}<br/><br/>
  <img src="${r.manual_img_10}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_10}<br/><br/>
  <img src="${r.manual_img_11}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_11}<br/><br/>
  <img src="${r.manual_img_12}" class="img-rounded" alt="Cinque Terre">&emsp; ${r.manual_12}<br/><br/>
  <h4>🔘 완 성 사 진</h4>
  <img src="${r.completePicture}" class="img-rounded" alt="Cinque Terre" style="width:600px; height:450px;">
</div>
</body>
</html>