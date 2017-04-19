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
            url : contextPath + 'np/login'
            ,method : 'POST'
            ,data : {
               id : id,
               password : password
            }
         }).success(function(data, status, xhr){

         });
      });
   }


});