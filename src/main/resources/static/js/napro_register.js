/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
   bindEvent();
   init();



   function init(){

   }

   function bindEvent(){
      $("#btn_register_napro").bind("click", function(){
         $("#mode").val("register");
         $('#naproModal').modal();
      });

      $("#sltMense").bind("change", function(){
         var menseVal = $(this).val();

         if(menseVal == "NO"){
            $(".existMucus").attr("disabled", true);
            $("#sltLevel").attr("disabled", false);
            $(".chkState1").attr("disabled", false);
            $(".chkState2").attr("disabled", false);
         }else{
            $(".existMucus").attr("disabled", false);
            $("#sltLevel").attr("disabled", true);
            $(".chkState1").attr("disabled", true);
            $(".chkState2").attr("disabled", true);
         }
      });

      $('#naproModal').on('show.bs.modal', function (e) {
         var mode = $("#mode").val();
         if(mode == "register"){
            $("#btnRegister").attr("disabled", false);
            $("#btnModify").attr("disabled", true);
            $("#btnDelete").attr("disabled", true);
         }else{
            $("#btnRegister").attr("disabled", true);
            $("#btnModify").attr("disabled", false);
            $("#btnDelete").attr("disabled", false);
         }
      })
   }
});