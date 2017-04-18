<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                </div>
                <div class="row" style="margin-top: 10px; border-top: 1px solid #e1e1e1">
                    <table class="table">
                        <thead class="text-center">
                        <th>기록 내용</th>
                        <th>기록 일시</th>
                        <th>점수</th>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${naproDataList == null}">
                                <tr><td colspan="3" class="text-center">기록한 내용이 없습니다.</td></tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="naproData" items="${naproDataList}" >
                                    <tr class="napro-data-row">
                                        <td>${naproData.totalCode}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                            value="${naproData.createDate}" /></td>
                                        <td class="text-center">${naproData.score}</td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="naproModal" role="dialog">
                    <form name="naproDataForm" action="${pageContext.request.contextPath}/np/registration" method="POST" id="naproDataForm" >
                        <input type="hidden" name="mode" id="mode" value="${mode}"/>
                        <input type="hidden" name="id" value="${id}"/>
                        <input type="hidden" name="start" value="${start}"/>

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
                                            <select id="sltMense" name="mense" class="form-control">
                                                <option value="M_NO">생리 없음</option>
                                                <option value="M_H">생리량이 많은 날</option>
                                                <option value="M_M">생리량이 보통인 날</option>
                                                <option value="M_L">생리량이 적은 날</option>
                                                <option value="M_VL">생리량이 아주 적은 날(묻어나는 정도)</option>
                                                <option value="M_B">갈색 혹은 검은색 생리혈</option>
                                            </select>
                                            <div class="text-center" style="margin-top: 10px;">
                                                <label>
                                                    <input type="radio" name="existMucus" value="Y" class="existMucus"/>
                                                    점액 있음
                                                </label>
                                                &nbsp;&nbsp;&nbsp;
                                                <label>
                                                    <input type="radio" name="existMucus" value="N" class="existMucus"/>
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
                                            <select id="sltLevel" name="vaginaLevel" class="form-control">
                                                <option value="">- 선택 -</option>
                                                <option value="L_ZERO">건조</option>
                                                <option value="L_TWO">미끈거리지 않는 눅눅함</option>
                                                <option value="L_TWO_W">미끈거리지 않는 젖음</option>
                                                <option value="L_FOUR">미끈거리지 않는 빛남</option>
                                                <option value="L_SIX">0.5cm 까지 늘어남</option>
                                                <option value="L_EIGHT">0.5 ~ 2.5Cm 사이의 길이로 늘어남</option>
                                                <option value="L_TEN">2.5cm 이상 늘어남</option>
                                            </select>

                                            <div class="checkbox" style="margin-top: 25px;">
                                                <span>State 1:</span><br/>
                                                <label>
                                                    <input type="checkbox" name="state1D" value="S1_D" id="state1_d" class="chkState1"/>
                                                    D(눅눅함)
                                                </label>
                                                &nbsp;&nbsp;&nbsp;
                                                <label>
                                                    <input type="checkbox" name="state1W" value="S1_W" id="state1_w" class="chkState1"/>
                                                    W(젖음)
                                                </label>
                                                &nbsp;&nbsp;&nbsp;
                                                <label>
                                                    <input type="checkbox" name="state1S" value="S1_S" id="state1_s" class="chkState1"/>
                                                    S(빛남)
                                                </label>
                                            </div>
                                            <div class="checkbox" style="margin-top: 25px;">
                                                <span>State 2:</span><br/>
                                                <div>
                                                    <label>
                                                        <input type="checkbox" name="state2C" value="S2_C" class="chkState2"/>
                                                        C(혼탁)
                                                    </label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <label>
                                                        <input type="checkbox" name="state2CK" value="S2_CK" class="chkState2">
                                                        C/K(일부혼탁/일부투명)
                                                    </label>
                                                </div>
                                                <div>
                                                    <label>
                                                        <input type="checkbox" name="state2G" value="S2_G" class="chkState2"/>
                                                        G(쫀득쫀득한)
                                                    </label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <label>
                                                        <input type="checkbox" name="state2K" value="S2_K" class="chkState2"/>
                                                        K(투명한)
                                                    </label>
                                                </div>
                                                <di>
                                                    <label>
                                                        <input type="checkbox" name="state2L" value="S2_L" class="chkState2"/>
                                                        L(미끈거리는)
                                                    </label>
                                                    &nbsp;&nbsp;&nbsp;
                                                    <label>
                                                        <input type="checkbox" name="state2P" value="S2_P" class="chkState2"/>
                                                        P(크림같은)
                                                    </label>
                                                </di>
                                                <div>
                                                    <label>
                                                        <input type="checkbox" name="state2Y" value="S2_Y" class="chkState2"/>
                                                        Y(노랑색)
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" id="btnRegister" class="btn btn-primary">등록</button>
                                    <button type="button" id="btnModify" class="btn btn-success">수정</button>
                                    <button type="button" id="btnDelete" class="btn btn-danger">삭제</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/napro_register.js"></script>
</body>
</html>