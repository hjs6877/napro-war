/**
 * Created by kjs on 2017-03-27.
 */
//[
//    {
//        id     : 1,
//        title  : 'event1',
//        start  : '2017-04-17',
//        end     : '2017-04-17',
//    },
//    {
//        id     : 2,
//        title  : 'event2',
//        start  : '2017-03-03',
//        end    : '2017-03-03'
//    },
//    {
//        id     : 3,
//        title  : 'event3',
//        start  : '2017-03-26',
//        end  : '2017-03-26'
//    }
//]
[
    {"eventId":1,"title":"10D","startDate":"20170418","endDate":"20170418","naproDataList":null}]
$(document).ready(function(){
    $('#calendar').fullCalendar({
        header: {
            left:   'today ',
            center: 'title',
            right:  'prev,next'
        },
        titleFormat: 'MMM YYYY',
        height: 'auto',
        events: contextPath + '/np/events',
        dayClick: function(date, jsEvent, view) {
            var splitDate = date.format().split("-");
            var formattedDate = splitDate[0] + splitDate[1] + splitDate[2];

            /**
             * - 날짜에 해당하는 이벤트가 있는지 확인하고 없으면, mode : new 로 해서 팝업만 띄운다.
             * - 날짜에 해당하는 이벤트가 있으면, 이벤트를 클릭하여 mode : modify로 해서 팝업을 띄우고
             * 데이터를 조회한다.
             * @type {*|jQuery}
             */
            var clickedDate = date.format();


            // DOM에서 직접 탐색하여 확인하도록 수정함.
            var clickedIndex = $('td[data-date=' + clickedDate + ']')
                                                    .eq(1).parent("tr")
                                                    .find($('td[data-date=' + clickedDate + ']')).index();

            var existsEvent = $('td[data-date=' + clickedDate + ']').eq(1).parents("thead").siblings("tbody")
                                    .find("tr").find("td").eq(clickedIndex).hasClass("fc-event-container");

            if(!existsEvent){
                location.href = contextPath + '/np/registration?start=' + formattedDate;
            }else{
                alert("Napro 데이터를 추가 등록하시려면 Napro 이벤트를 클릭하세요.");
                return;
            }
        },
        eventClick: function(calEvent, jsEvent, view){
            var splitDate = calEvent.start.format().split("-");
            var formattedDate = splitDate[0] + splitDate[1] + splitDate[2];

            location.href = contextPath + '/np/registration?id=' + calEvent.id + '&start=' + formattedDate;
            //alert("event ID: " + calEvent.id);
            //alert("event title: " + calEvent.title);
            //alert("event start: " + calEvent.start.format());
        }
    })
});