/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
   bindEvent();
   init();

   function init(){
      changeStateWhenManseElementState();
      changeStateWhenLevelElementState();
      changeStateWhenState1ElementState();
   }

   function bindEvent(){
      $("#btn_register_napro").bind("click", function(){
         $("#mode").val("register");
         changeButtonStateWhenModeState();

         $('#naproModal').modal();
      });

      $(".napro-data-row").bind("click", function(){
         $("#mode").val("modify");
         changeButtonStateWhenModeState();

         // TODO 폼에 데이터를 셋팅 함.
         // 폼 요소의 초기화
         changeStateWhenManseElementState();
         changeStateWhenLevelElementState();
         changeStateWhenState1ElementState();
         $('#naproModal').modal();
      });

      $("#sltMense").bind("change", function(){
         changeStateWhenManseElementState();
      });

      $("#sltLevel").bind("change", function(){
         changeStateWhenLevelElementState();
      });

      $(".chkState1").bind("change", function(event){
         changeStateWhenState1ElementState(event);
      });


      $("#btnRegister").bind("click", function(){
         /**
          * TODO
          * 1. 비활성화 되어 있는 상태의 요소들은 모두 빈값으로 처리한다.(이건 서버에서..)
          * 2. 폼 전송.
          * 3. 서버에서 전송된 데이터 확인하기
          */
         if(confirm("선택한 정보를 저장하시겠습니까?")){
            $("#naproDataForm").submit();
         }

      });
   }

   function changeStateWhenManseElementState(){
      var menseVal = $("#sltMense").val();
      if(menseVal == "M_NO"){
         $(".existMucus").attr("disabled", true);
         $("#sltLevel").attr("disabled", false);
      }else{
         $(".existMucus").attr("disabled", false);
         $("#sltLevel").attr("disabled", true);
      }
   }

   function changeStateWhenLevelElementState(){
      var levelVal = $("#sltLevel").val();

      if($("#sltLevel").is(":disabled") || levelVal == "" || levelVal == "0" ||
          levelVal == "2" || levelVal == "2W" || levelVal == "4"){
         $(".chkState1").attr("disabled", true);
         $(".chkState2").attr("disabled", true);
      }else{
         $(".chkState1").attr("disabled", false);
         $(".chkState2").attr("disabled", false);
      }
   }

   function changeStateWhenState1ElementState(event){
      if(event){
         if(event.currentTarget.id == "state1_d"){
            if($("#state1_d").is(":checked")){
               $("#state1_w").attr("disabled", true);
               $("#state1_s").attr("disabled", true);
            }else{
               $("#state1_w").attr("disabled", false);
               $("#state1_s").attr("disabled", false);
            }
         }else if(event.currentTarget.id == "state1_w"){
            if($("#state1_w").is(":checked")){
               $("#state1_d").attr("disabled", true);
               $("#state1_s").attr("disabled", true);
            }else{
               $("#state1_d").attr("disabled", false);
               $("#state1_s").attr("disabled", false);
            }
         }else if(event.currentTarget.id == "state1_s") {
            if($("#state1_s").is(":checked")){
               $("#state1_w").attr("disabled", true);
               $("#state1_d").attr("disabled", true);
            }else{
               $("#state1_w").attr("disabled", false);
               $("#state1_d").attr("disabled", false);
            }
         }
      }else{
         if($("#state1_d").is(":checked")){
            $("#state1_w").attr("disabled", true);
            $("#state1_s").attr("disabled", true);
         }else if($("#state1_w").is(":checked")){
            $("#state1_w").attr("disabled", false);
            $("#state1_s").attr("disabled", false);
         }else if($("#state1_s").is(":checked")){
            $("#state1_w").attr("disabled", false);
            $("#state1_d").attr("disabled", false);
         }
      }

   }

   function changeButtonStateWhenModeState(){
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
   }


});