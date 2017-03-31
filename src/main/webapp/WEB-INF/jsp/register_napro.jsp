<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Napro Registration</title>
    <jsp:include page="include/header.jsp"/>

</head>
<body style="margin:5px;">
    <div id="wrapper">
        <jsp:include page="include/sidebar.jsp"/>

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-1" style="padding-left: 0px">
                        <jsp:include page="include/sidebar_toggle_button.jsp"/>
                    </div>
                    <div class="col-xs-11 text-center">
                        <h4><span class="glyphicon glyphicon-registration-mark"></span> Napro Registration</h4>
                    </div>
                </div>
                <div class="row text-right" style="margin-top: 20px;">
                    <button type="button" class="btn btn-default btn-primary" id="btn_register_napro">등록</button>
                    <button type="button" class="btn btn-default btn-success">수정</button>
                    <button type="button" class="btn btn-default btn-danger">삭제</button>
                </div>
                <div class="row" style="margin-top: 10px; border-top: 1px solid #e1e1e1">
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
                                <h4 class="modal-title">Napro Registration Form</h4>
                            </div>
                            <div class="modal-body">
                                <%--mense panel--%>
                                <div class="panel panel-warning">
                                    <div class="panel-heading">
                                        mense
                                    </div>
                                    <div class="panel-body">
                                        <select class="form-control">
                                            <option value="NO">생리 없음</option>
                                            <option value="H">생리량이 많은 날</option>
                                            <option value="M">생리량이 보통인 날</option>
                                            <option value="L">생리량이 적은 날</option>
                                            <option value="VL">생리량이 아주 적은 날(묻어나는 정도)</option>
                                            <option value="B">갈색 혹은 검은색 생리혈</option>
                                        </select>
                                        <div class="text-center" style="margin-top: 10px;">
                                            <label>
                                                <input type="radio" name="existMucus" value="Y"/>
                                                점액 있음
                                            </label>
                                            &nbsp;&nbsp;&nbsp;
                                            <label>
                                                <input type="radio" name="existMucus" value="N"/>
                                                점액 없음
                                            </label>
                                        </div>

                                    </div>
                                </div>
                                <%--vagina panel--%>
                                <div class="panel panel-warning">
                                    <div class="panel-heading">
                                        vagina
                                    </div>
                                    <div class="panel-body">
                                        <span>Level:</span>
                                        <select class="form-control">
                                            <option value="0">건조</option>
                                            <option value="2">미끈거리지 않는 눅눅함</option>
                                            <option value="2W">미끈거리지 않는 젖음</option>
                                            <option value="4">미끈거리지 않는 빛남</option>
                                            <option value="6">0.5cm 까지 늘어남</option>
                                            <option value="8">0.5 ~ 2.5Cm 사이의 길이로 늘어남</option>
                                            <option value="10">2.5cm 이상 늘어남</option>
                                        </select>

                                        <div class="checkbox" style="margin-top: 25px;">
                                            <span>State 1:</span><br/>
                                            <label>
                                                <input type="checkbox" name="state1[]" value=""/>
                                                D(눅눅함)
                                            </label>
                                            &nbsp;&nbsp;&nbsp;
                                            <label>
                                                <input type="checkbox" name="state1[]" value=""/>
                                                W(젖음)
                                            </label>
                                            &nbsp;&nbsp;&nbsp;
                                            <label>
                                                <input type="checkbox" name="state1[]" value=""/>
                                                S(빛남)
                                            </label>
                                        </div>
                                        <div class="checkbox" style="margin-top: 25px;">
                                            <span>State 2:</span><br/>
                                            <div>
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="C"/>
                                                    C(혼탁)
                                                </label>
                                                &nbsp;&nbsp;&nbsp;
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="CK"/>
                                                    C/K(일부혼탁/일부투명)
                                                </label>
                                            </div>
                                            <div>
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="G"/>
                                                    G(쫀득쫀득한)
                                                </label>
                                                &nbsp;&nbsp;&nbsp;
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="G"/>
                                                    K(투명한)
                                                </label>
                                            </div>
                                            <di>
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="L"/>
                                                    L(미끈거리는)
                                                </label>
                                                &nbsp;&nbsp;&nbsp;
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="P"/>
                                                    P(크림같은)
                                                </label>
                                            </di>
                                            <div>
                                                <label>
                                                    <input type="checkbox" name="state2[]" value="Y"/>
                                                    Y(노랑색)
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary">등록</button>
                                <button type="button" class="btn btn-success">수정</button>
                                <button type="button" class="btn btn-danger">삭제</button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/napro_register.js"></script>
</body>
</html>