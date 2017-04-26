/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
   init();
   bindEvent();


   function init(){

   }

   function bindEvent(){
      $("#btn_register_napro").bind("click", function(){
         $("#mode").val("register");

         // 모달 열기전에 초기화.
         initState();
         changeButtonStateWhenModeState();

         $('#naproModal').modal();
      });

      /**
       * 수정 모드
       */
      $(".napro-data-row").bind("click", function(){
         $("#mode").val("modify");
         changeButtonStateWhenModeState();

         // TODO 폼에 데이터를 셋팅 함.
         var naproDataId = $(this).attr("data-id");
         var mense = $(this).attr("data-mense");
         var existMucus = $(this).attr("data-existMucus");
         var vaginaLevel = $(this).attr("data-vaginaLevel");
         var state1D = $(this).attr("data-state1D");
         var state1W = $(this).attr("data-state1W");
         var state1S = $(this).attr("data-state1S");
         var state2C = $(this).attr("data-state2C");
         var state2CK = $(this).attr("data-state2CK");
         var state2G = $(this).attr("data-state2G");
         var state2K = $(this).attr("data-state2K");
         var state2L = $(this).attr("data-state2L");
         var state2P = $(this).attr("data-state2P");
         var state2Y = $(this).attr("data-state2Y");

         $("#naproDataId").val(naproDataId);
         $("#sltMense").val(mense);

         if(existMucus == 'Y'){
            $(".existMucus").eq(0).attr("checked", true);
         }else if(existMucus == 'N'){
            $(".existMucus").eq(1).attr("checked", true);
         }else{
            $(".existMucus").attr("checked", false);
         }

         $("#sltLevel").val(vaginaLevel);

         if(state1D){
            $("#state1_d").trigger("click");
         }

         if(state1W){
            $("#state1_w").trigger("click");
         }

         if(state1S){
            $("#state1_s").trigger("click");
         }



         if(state2C){
            $("#state2C").trigger("click");
         }
         if(state2CK){
            $("#state2CK").trigger("click");
         }
         if(state2G){
            $("#state2G").trigger("click");
         }
         if(state2K){
            $("#state2K").trigger("click");
         }
         if(state2L){
            $("#state2L").trigger("click");
         }
         if(state2P){
            $("#state2P").trigger("click");
         }
         if(state2Y){
            $("#state2Y").trigger("click");
         }

         // 폼 요소의 상태 변경
         changeStateWhenMenseElementState();
         changeStateWhenLevelElementState();
         $('#naproModal').modal();
      });

      $("#sltMense").bind("change", function(){
         changeStateWhenMenseElementState();
      });

      $("#sltLevel").bind("change", function(){
         changeStateWhenLevelElementState();
      });

      $(".chkState1").bind("click", function(event){
         setTimeout(function(){
            changeStateWhenState1ElementState(event.currentTarget.id);
         }, 10);

      });


      $("#btnRegister").bind("click", function(){
         if(validateNaproData()){
            // TODO mense일때, mucus 필수 체크 해야됨.
            if(confirm("선택한 정보를 저장하시겠습니까?")){
               $("#naproDataForm").attr("action", contextPath + "/np/registration");
               $("#naproDataForm").submit();
            }
         }

      });

      $("#btnModify").bind("click", function(){
        if(validateNaproData()){
           if(confirm("선택한 정보를 수정하시겠습니까?")){
              $("#naproDataForm").attr("action", contextPath + "/np/modify")
              $("#naproDataForm").submit();
           }
        }
      });

      $("#btnDelete").bind("click", function(){
         var eventId = $("#eventId").val();
         var naproDataId = $("#naproDataId").val();
         var start = $("#start").val();
         if(confirm("선택한 Napro 데이터를 삭제하시겠습니까?")){
            location.href = contextPath + "/np/delete?eventId=" + eventId + "&naproDataId=" +
                naproDataId + "&start=" + start;
         }
      });

      $('#naproModal').on('hidden.bs.modal', function (e) {
         location.reload();
      })
   }

   function validateNaproData(){
      var menseVal = $("#sltMense").val();
      if(menseVal != "M_NO"){
         if(!$(".existMucus").is(":checked")){
            alert("점액 상태를 선택하세요.");
            return false;
         }
      }
      return true;
   }
   function initState(){
      // TODO 폼 요소들 상태 초기화 하기. 화면 reload하면 필요 없음.
      changeStateWhenMenseElementState();
      changeStateWhenLevelElementState();
   }
   function changeStateWhenMenseElementState(){
      var menseVal = $("#sltMense").val();
      if(menseVal == "M_NO"){
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
   }

   function changeStateWhenLevelElementState(){
      var levelVal = $("#sltLevel").val();
      if($("#sltLevel").is(":disabled") || levelVal == "" || levelVal == "L_ZERO" ||
          levelVal == "L_TWO" || levelVal == "L_TWO_W" || levelVal == "L_FOUR"){
         $(".chkState1").attr("disabled", true);
         $(".chkState2").attr("disabled", true);
      }else{
         $(".chkState1").attr("disabled", false);
         $(".chkState2").attr("disabled", false);
      }
   }

   function changeStateWhenState1ElementState(id){
      if(id == "state1_d"){
         if($("#state1_d").is(":checked")){
            $("#state1_w").attr("disabled", true);
            $("#state1_s").attr("disabled", true);
         }else{
            $("#state1_w").attr("disabled", false);
            $("#state1_s").attr("disabled", false);
         }
      }else if(id == "state1_w"){
         if($("#state1_w").is(":checked")){
            $("#state1_d").attr("disabled", "disabled");
            $("#state1_s").attr("disabled", "disabled");
         }else{
            $("#state1_d").attr("disabled", false);
            $("#state1_s").attr("disabled", false);
         }
      }else if(id == "state1_s") {
         if($("#state1_s").is(":checked")){
            $("#state1_w").attr("disabled", true);
            $("#state1_d").attr("disabled", true);
         }else{
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