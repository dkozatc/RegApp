define([
		'underscore',
		'backbone',
		'models/Appointment'
	], function( _, Backbone, AppointmentModel){
	
	var Event = _.extend(Backbone.Events);

	var AppointmentsCollection = Backbone.Collection.extend({
		model:AppointmentModel,
		initialize: function() {
			Event.on('fetchAppointments', this.fetchAppointments, this);
		},
		fetchAppointments: function(object){
			this.url ="/getAppointmentList?id="+object.model.get("id");
			console.log(object);
			this.fetch({
				success: function(collection){
					console.log(collection);
					var fullCalendarEvents = Array();
					collection.each(function(model){

						fullCalendarEvents.push({title:model.get("CommentsText"), start:model.get("StartDateTime"), end:model.get("EndDateTime"), allDay:true, })



					});

				}
			});
			console.log(this);
		}

	});
	return AppointmentsCollection;
});