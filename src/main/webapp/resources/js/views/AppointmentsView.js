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
            console.log(this.options.editable)

            console.log(that.options.editable)
				$('#myModal').on('shown', function(){
				        that.$el.fullCalendar({
		                     header:{
		                        left: 'prev,next ',
		                        center: 'title',
		                        right: 'month, agendaWeek, agendaDay'
		                     },
		                     weekends: false,
		                     droppable: that.options.editable,
		                     editable: that.options.editable,
                             resized: that.options.editable,
		                     events: FullCalenderEvents,
		                     drop: function (date, allDay, ui) {
                                 if(that.options.editable){
                                            var obj = {
                                                title:$(this).text(),
                                                start:date,
                                                allDay:false,
                                                backgroundColor:$(this).css('background-color')
                                            }
                                    console.log($(this).css('background-color'));
                                    console.log($(this).data("ResourcesId"));
                             
                                    var appointment = new AppointmentModel({StartDateTime:date, EndDateTime:date, EncounterId:that.model.get('id'), ResourcesId:$(this).data("ResourcesId"), CommentsText:$(this).text()});
                                    appointment.save(appointment.toJSON(), {processData:true,
                                        success:function(model, response){
                                              console.log(model);
                                              model.set("id", model.get("date"));
                                              obj.id =model.get("date");
 											$('#calendar').fullCalendar('renderEvent',  obj, true);
                                        }



                                    });
                                    console.log(appointment);
                                    console.log($(this));
                                    console.log(ui);
                                 }

		                    },
		                    eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc) {
                                if(that.options.editable){
                                    var appointment = new AppointmentModel({id:event.id, StartDateTime:event.start, EndDateTime:event.end, EncounterId:that.model.get('id'), ResourcesId:event.ResourcesId, CommentsText:event.title});
                                    appointment.url = "updateAppointment";
                                    console.log(appointment);
                                    console.log($(this));
                                    // console.log(ui);
                                    appointment.save(appointment.toJSON(), {processData:true});
                                }
		                    },
		                    eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
		                    	console.log(event);
		                    	console.log("execut");
						        var appointment = new AppointmentModel({id:event.id, StartDateTime:event.start, EndDateTime:event.end, EncounterId:that.model.get('id'), ResourcesId:event.ResourcesId, CommentsText:event.title});
		                    	appointment.url = "updateAppointment";
		                    	console.log(appointment);
		                  		appointment.save(appointment.toJSON(), {processData:true});
						    },
						    eventDragStop:function(event, jsEvent, ui, view, revertFunc){
						    	console.log(event);
						    	console.log($(this));
		                    	console.log(ui);

						    },
						    eventDragStart:function(event, jsEvent, ui, view ){
						    	$(".fc-view").css("overflow", "visible");
						    	$(".modal-body").css("overflow", "visible");
						    	$(".fc-event").draggable({
						    		revert:false
						    	})
						    	console.log(event);
						    	$(this)[0].id=event.id;
						    	$(this)[0].children[0].id=event.id;
						    	$(this)[0].children[1].id=event.id;
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
	        	$('.fc-header-left').append("<img class='shredder' src='/resources/img/icon-lg-shredder.png'>");
	        	$(".shredder").droppable({
	        		accept:'.fc-event',
	        		drop: function(event, ui){
	        			console.log("drop");
	        			console.log("drop");
	        			var el = $(event.toElement).parent();
	        			if(confirm("Do you wont delete event?")){
	        								console.log(event.id);
						    				$('#calendar').fullCalendar( 'removeEvents', el[0].id);
						    				Event.trigger("removeAppointment", el[0].id);
						}
	        	}
	        })
	      console.log(this.model.get('id'));
	     Event.off("bildedFullCalendarEvents"+this.model.get('id'));
		}
	});
	return AppointmentsView;
})