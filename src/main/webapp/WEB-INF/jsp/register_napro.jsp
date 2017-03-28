<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Napro Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"/>
</head>
<body style="margin:5px;">
    <div class="container-fluid">
        <div class="row">
            <h3><span class="glyphicon glyphicon-registration-mark"></span>Napro Registration</h3>
        </div>
        <div class="row text-right">
            <button type="button" class="btn btn-default" id="btn_register_napro">신규</button>
            <button type="button" class="btn btn-default">수정</button>
            <button type="button" class="btn btn-default">삭제</button>
        </div>
        <div>
            <table class="table">
                <thead>
                    <th>라디오박스</th>
                    <th>기록 내용</th>
                    <th>우선순위</th>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="radio" name="rdo_napro_list"/></td>
                        <td>10LDP</td>
                        <td>1</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <p>Some text in the modal.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <h5>This is napro registration page.</h5>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/napro_register.js"></script>
</body>
</html>