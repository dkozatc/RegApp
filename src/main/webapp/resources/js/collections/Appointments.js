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
			Event.on("removeAppointment", this.removeApppointment, this);
		},
		fetchAppointments: function(object){
			this.url ="getAppointmentList?id="+object.model.get("id");
			console.log(object);
			this.fetch({
				success: function(collection){
					console.log(collection);
					var fullCalendarEvents = Array();
					collection.each(function(model){
						var resourceModel = object.resources.where({resourceId:model.get("ResourcesId")})
						if(resourceModel.length != 0){
			        	fullCalendarEvents.push({id:model.get("id"), title:model.get("CommentsText"), start:new Date(model.get("StartDateTime")), end:new Date(model.get("EndDateTime")), allDay:false, backgroundColor:resourceModel[0].get("color"),
						ResourcesId:model.get("ResourcesId")});
						}else{
							fullCalendarEvents.push({});
						}
					});
					console.log(fullCalendarEvents);
					Event.trigger("bildedFullCalendarEvents"+object.model.get("id"), fullCalendarEvents);	
				},
				error: function(){
					console.log("error");
				}
			});
			console.log(this);
		},
		removeApppointment: function(id) {
				console.log(id);
				var model =  new AppointmentModel({id:id});
				model.url = "deleteAppointment?id="+id;
				model.destroy();
		}
	});
	return AppointmentsCollection;
});