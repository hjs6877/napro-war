<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Napro Login</title>
    <jsp:include page="include/header.jsp"/>
    <link href="${pageContext.request.contextPath}/css/napro_login.css" rel="stylesheet">
</head>
<body style="margin:5px;">
    <div id="wrapper">
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-11 text-center">
                        <h4><span class="glyphicon glyphicon-calendar" style="background-color: lightblue"></span> Na-Pro Login</h4>
                    </div>
                </div>
                <div class="row" style="margin-top: 20px;">

                    <div class="form-group">
                        <label for="loginId">ID</label>
                        <input type="text" id="loginId" class="form-control" placeholder="ID를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label for="loginPassword">PASSWORD</label>
                        <input type="password"  id="loginPassword" class="form-control" placeholder="Password를 입력하세요">
                    </div>

                    <div style="margin-top: 30px;margin-bottom: 30px;">
                        <input type="button" id="btn_login" class="btn btn-primary btn-lg btn-block" value="로그인"/>
                    </div>

                    <%--<div>--%>
                        <%--<div style="float: left"><a href="#">회원가입</a></div>--%>
                        <%--<div style="float: right"><a href="#"><a href="#">ID/PASSWORD 찾기</a></a></div>--%>
                    <%--</div>--%>

                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/napro_login.js"></script>
</body>
</html>