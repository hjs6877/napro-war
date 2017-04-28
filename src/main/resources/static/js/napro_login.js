/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
   bindEvent();
   init();

   function init(){
      $("#loginId").focus();
   }

   function bindEvent(){
      $("#btn_login").bind("click", function(){
         var id = $("#loginId").val();
         var password = $("#loginPassword").val();
         var allowAutoLogin = "";
         if($("#allowAutoLogin").is(":checked")){
            allowAutoLogin = "Y";
         }else{
            allowAutoLogin = "N";
         }

         if(!id){
            alert("ID를 입력하세요.");
            return;
         }

         if(!password){
            alert("패스워드를 입력하세요.");
            return;
         }

         $.ajax({
            type:"POST",
            url: contextPath + '/np/login',
            data: {
               id : id,
               password : password,
               allowAutoLogin : allowAutoLogin
            },
            success:function(data){
               // TODO 로그인 해킹에 대한 보완 필요.
               if(data.code == "login-fail"){
                  alert(data.message);
                  $("#loginId").focus();
                  $("#loginId").val("");
                  $("#loginPassword").val("");
               }else if(data.code == "login-success"){
                  if(data.resultData.allowAutoLogin && data.resultData.userId && data.resultData.salt){
                     $.cookie("allowAutoLogin", data.resultData.allowAutoLogin, {expires: 14, path: '/'});
                     $.cookie("userId", data.resultData.userId, {expires: 14, path: '/'});
                     $.cookie("salt", data.resultData.salt, {expires: 14, path: '/'});
                  }else{
                     $.removeCookie("allowAutoLogin", {path: '/'});
                     $.removeCookie("userId", {path: '/'});
                     $.removeCookie("salt", {path: '/'});
                  }
                  location.href = contextPath + "/np/napro_home";
               }
            },
            error:function(e){
               alert("접속 중 에러가 발생하였습니다. 다시 시도해주세요.");
               //alert(e.responseText);
            }
         });
      });
   }
});