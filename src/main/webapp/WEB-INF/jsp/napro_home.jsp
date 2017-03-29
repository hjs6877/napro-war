<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Napro Calendar</title>
    <jsp:include page="include/header.jsp"/>
    <link href="${pageContext.request.contextPath}/css/napro_home.css" rel="stylesheet">
</head>
<body style="margin:5px;">
    <div id="wrapper">
        <jsp:include page="include/sidebar.jsp"/>
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <jsp:include page="include/sidebar_toggle_button.jsp"/>
                <div class="row"  style="margin-top: 20px;">
                    <h4><span class="glyphicon glyphicon-calendar" style="background-color: lightblue"></span> Na-Pro Technology 캘린더</h4>
                </div>
                <div class="row text-center" id="calendar"></div>
                <div class="row">
                    <a href="${pageContext.request.contextPath}/np/registration">Move to Napro registration page.</a>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/napro_home.js"></script>
</body>
</html>