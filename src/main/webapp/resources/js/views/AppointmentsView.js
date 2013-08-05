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
			Event.off("bildedFullCalendarEvents"+this.model.get('id'));
			Event.on("bildedFullCalendarEvents"+this.model.get('id'), this.bildFullCalendar, this);
			this.render();
		},
		render: function(){
			console.log("render appointments");
			this.$el.html("");
		},
		bildFullCalendar: function(FullCalenderEvents){
			console.log("Event Shot");
			var that = this
			this.$el.html("");
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
		                     events: FullCalenderEvents,
		                     drop: function (date, allDay) {
		                            var obj = {
		                                title:$(this).text(),
		                                start:date,
		                                allDay:false,
		                                backgroundColor:$(this).css('background-color')
		                            } 
		                    console.log($(this).css('background-color')); 
		                    console.log($(this).data("ResourcesId"));
		                    $('#calendar').fullCalendar('renderEvent',  obj, true);
		                    var appointment = new AppointmentModel({StartDateTime:date, EndDateTime:date, EncounterId:that.model.get('id'), ResourcesId:$(this).data("ResourcesId"), CommentsText:$(this).text()});
		                    appointment.save(appointment.toJSON(), {processData:true});
		                    console.log(appointment);
		                    },
		                    eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc) { 
		                    	var appointment = new AppointmentModel({id:event.id, StartDateTime:event.start, EndDateTime:event.end, EncounterId:that.model.get('id'), ResourcesId:event.ResourcesId, CommentsText:event.title});
		                    	appointment.url = "/updateAppointment";
		                    	console.log(appointment);
		                  		appointment.save(appointment.toJSON(), {processData:true});
		                    },
		                    eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
		                    	console.log(event);
		                    	console.log("execut");
						        var appointment = new AppointmentModel({id:event.id, StartDateTime:event.start, EndDateTime:event.end, EncounterId:that.model.get('id'), ResourcesId:event.ResourcesId, CommentsText:event.title});
		                    	appointment.url = "/updateAppointment";
		                    	console.log(appointment);
		                  		appointment.save(appointment.toJSON(), {processData:true});
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
	      console.log(this.model.get('id'));
	     Event.off("bildedFullCalendarEvents"+this.model.get('id'));
		}
	});
	return AppointmentsView;
})