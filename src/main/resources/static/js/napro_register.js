/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
   $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
   });

   $("#btn_register_napro").bind("click", function(){
      $('#myModal').modal();
   });
});