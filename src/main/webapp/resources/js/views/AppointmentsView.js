define([
	'jquery',
	'underscore',
	'backbone',
	'tools',
	'jsrender',
	'models/Appointment'
  	
],
function($, _, Backbone, Tools, Jsrender, AppointmentModel){

	var Event = _.extend(Backbone.Events);
	var AppointmentsView = Backbone.View.extend({
		el:'#calendar',
		initialize: function(){


			this.render();

		},
		render: function(){
				var that = this
				$('#myModal').on('shown', function(){
				
		                that.$el.fullCalendar({
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
		                         console.log($(this).data("ResourcesId"));
		                         $('#calendar').fullCalendar('renderEvent',  obj, true);
		                         var appointment = new AppointmentModel({StartDateTime:date, EndDateTime:date, EncounterId:that.model.get('id'), ResourcesId:$(this).data("ResourcesId"), CommentsText:$(this).text()});
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
		},
		addEvents: function(){
			 
		}




	});
	return AppointmentsView;
})