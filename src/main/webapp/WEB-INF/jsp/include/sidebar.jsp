<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar -->
<div id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                Napro Technology
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/np/napro_home">Napro Calendar</a>
        </li>
        <li>
            <a href="#">Napro Chart</a>
        </li>
    </ul>
    <div class="footer" style="padding: 5px;">
        <button id="logout" class="btn btn-default btn-sm btn-block">Logout</button>
    </div>
</div>

<!-- /#sidebar-wrapper -->