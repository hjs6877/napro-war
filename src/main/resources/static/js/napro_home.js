/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
    $('#calendar').fullCalendar({
        header: {
            left:   'today ',
            center: 'title',
            right:  'prev,next'
        },
        titleFormat: 'MMM YYYY',
        height: 'auto',
        events: [
            {
                id     : 1,
                title  : 'event1',
                start  : '2017-04-17',
                end     : '2017-04-17',
            },
            {
                id     : 2,
                title  : 'event2',
                start  : '2017-03-03',
                end    : '2017-03-03'
            },
            {
                id     : 3,
                title  : 'event3',
                start  : '2017-03-26',
                end  : '2017-03-26'
            }
        ],
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
            var eventSources = $('#calendar').fullCalendar('getEventSources');
            var events = eventSources[0].events;

            var existsEvent = false;
            for(var i in events){
                var startDate = events[i].start._i;
                if(startDate == clickedDate){
                    existsEvent = true;
                    break;
                }
            }

            if(!existsEvent){
                location.href = contextPath + '/np/registration?startDate=' + formattedDate;
            }else{
                alert("Napro 데이터를 추가 등록하시려면 Napro 이벤트를 클릭하세요.");
                return;
            }
        },
        eventClick: function(calEvent, jsEvent, view){
            var splitDate = calEvent.start.format().split("-");
            var formattedDate = splitDate[0] + splitDate[1] + splitDate[2];

            location.href = contextPath + '/np/registration?eventId=' + calEvent.id + '&startDate=' + formattedDate;
            //alert("event ID: " + calEvent.id);
            //alert("event title: " + calEvent.title);
            //alert("event start: " + calEvent.start.format());
        }
    })
});