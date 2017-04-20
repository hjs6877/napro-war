<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/lib/fullcalendar/fullcalendar.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/simple-sidebar.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/fullcalendar/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/fullcalendar/fullcalendar.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<input type="hidden" id="contextPath" name="contextPath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>