/**
 * Created by ideapad on 2017-03-28.
 */
var offset=location.href.indexOf(location.host)+location.host.length;
var contextPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
$(document).ready(function(){
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
});