/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
   bindEvent();
   init();

   function init(){

   }

   function bindEvent(){
      $("#btn_login").bind("click", function(){
         var id = $("#loginId").val();
         var password = $("#loginPassword").val();

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
               password : password
            },
            success:function(data){
               // TODO 로그인 해킹에 대한 보완 필요.
               if(data.code == "login-fail"){
                  alert(data.message);
                  $("#loginId").focus();
                  $("#loginId").val("");
                  $("#loginPassword").val("");
               }else if(data.code == "login-success"){
                  location.href = contextPath + "/np/napro_home";
               }
            },
            error:function(e){
               alert(e.responseText);
            }
         });
      });
   }


});