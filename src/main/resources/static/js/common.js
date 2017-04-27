/**
 * Created by ideapad on 2017-03-28.
 */

var contextPath = "";


$(document).ready(function(){
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    contextPath = $("#contextPath").val();

    $("#logout").bind("click", function(){
        if(confirm("로그아웃 하시겠습니까?")){
            $.ajax({
                type:"POST",
                url: contextPath + '/np/logout',
                data: {

                },
                success:function(data){
                    // TODO 로그인 해킹에 대한 보완 필요.
                    if(data.code == "logout-success"){
                        localStorage.clear();
                        location.href = contextPath + "/";
                    }
                },
                error:function(e){
                    alert("접속 중 에러가 발생하였습니다. 다시 시도해주세요.");
                    //alert(e.responseText);
                }
            });
        }
    });
});