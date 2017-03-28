/**
 * Created by kjs on 2017-03-27.
 */
$(document).ready(function(){
    $('#calendar').fullCalendar({
        header: {
            left:   'title',
            center: 'prevYear, nextYear',
            right:  'today prev,next'
        },
        events: [
            {
                id     : 1,
                title  : 'event1',
                start  : '2017-03-02'
            },
            {
                id     : 2,
                title  : 'event2',
                start  : '2017-03-03',
                end    : '2017-03-10'
            },
            {
                id     : 3,
                title  : 'event3',
                start  : '2017-03-26'
            }
        ],
        dayClick: function(date, jsEvent, view) {
            alert(date.format());
            /**
             * - 날짜에 해당하는 이벤트가 있는지 확인하고 없으면, mode : new 로 해서 팝업만 띄운다.
             * - 날짜에 해당하는 이벤트가 있으면, 이벤트를 클릭하여 mode : modify로 해서 팝업을 띄우고
             * 데이터를 조회한다.
             * @type {*|jQuery}
             */
            var eventSources = $('#calendar').fullCalendar('getEventSources');
            console.log(eventSources[0].events[0].start._i);
        },
        eventClick: function(calEvent, jsEvent, view){
            alert("event ID: " + calEvent.id);
            alert("event title: " + calEvent.title);
            alert("event start: " + calEvent.start.format());
        }
    })
});