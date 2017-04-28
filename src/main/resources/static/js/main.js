/**
 * Created by kjs on 2017-03-28.
 */
$(document).ready(function(){
    var allowAutoLogin = $.cookie("allowAutoLogin");
    var userId = $.cookie("userId");
    var salt = $.cookie("salt");

    if(allowAutoLogin && userId && salt){
        $.ajax({
            type:"POST",
            url: contextPath + '/np/login/auto',
            data: {
                id : userId,
                salt : salt
            },
            dataType:'json',
            success:function(data){
                console.log(data);
                if(data.code == "login-auto-deny"){
                    localStorage.clear();
                    location.href = contextPath + "/np/login";
                }else if(data.code == "login-auto-allow"){
                    location.href = contextPath + "/np/napro_home";
                }
            },
            error:function(e){
                console.log(e.responseText);
                alert("서버와의 통신 중 에러가 발생했습니다. 다시 시도해주세요.");
            }
        });
    }else{
        location.href = contextPath + "/np/login";
    }
});
