<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Napro Home</title>

    <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" />
</head>
<body style="margin:5px;">
    <div class="container-fluid">
        <div class="row">
            <h4><span class="glyphicon glyphicon-calendar" style="background-color: lightblue"></span> Na-Pro Technology 캘린더</h4>
        </div>
        <div class="row text-center">
            캘린더 영역
        </div>
        <div class="row">
            <a href="${pageContext.request.contextPath}/np/registration">Move to Napro registration page.</a>
        </div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/napro_home.js"></script>
</body>
</html>