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
});