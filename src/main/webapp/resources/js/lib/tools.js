/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
define(['underscore','jquery', 'backbone', 'models/Appointment'], function( _, $, Backbone, AppointmentModel){

     var Event = _.extend(Backbone.Events);
     var Tools = {};
        Tools.SearchRequest  = function(request){
            $.ajax({
                type: "POST",
                dataType:'json',
                url: "/test",
                data:{requestString:request},
                success: function(msg){
                    Event.trigger('SuccessSearch', msg);      
                }   
            });
        };
        Tools.LoadTemplate = function(name){
            $.ajax({
                type: "GET",
                url: "/resources/templates/"+name+".html",
                data:{},
                success: function(Data){
                    Event.trigger(name, Data);   
                }   
            });
        };
        Tools.Calendar = function(model) {
            $('#myModal').on('shown', function(){
                $("#calendar").fullCalendar({
                     header:{
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month, agendaWeek, agendaDay'
                     },
                     weekends: false,
                     droppable: true,
                     editable: true,
                     resized:true,
                     events:[{
                        title: "test Event",
                        start: new Date(2013, 6, 1)
                     }],
                     drop: function (date, allDay) {
                            var obj = {
                                title:$(this).text(),
                                start:date,
                                allDay:true,
                                backgroundColor:$(this).find('div').css('background-color')
                            }  
                         $('#calendar').fullCalendar('renderEvent',  obj, true);
                         var appointment = new AppointmentModel({StartDateTime:date, EndDateTime:date, EncounterId:model.get('id'), CommentsText:$(this).text()});
                         appointment.save(appointment.toJSON(), {data:appointment.toJSON(), processData:true});
                    },
                    eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc) { 
                        console.log(event);
                        console.log(dayDelta);
                        console.log(minuteDelta);
                        console.log(allDay);
                    }
                });
            });
            $('.d').each(function() {
                        $(this).draggable({
                            zIndex: 999,
                            revert: true,     
                            revertDuration: 0  
                        });
            });
        };
    return Tools;
});















