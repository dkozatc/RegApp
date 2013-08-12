define(['jquery',
		'underscore',
		'backbone',
		'jsrender',
		'text!../templates/PatientEncounters.html',
		'Fullcalender',
		'lib/jquery-ui',
		'models/Appointment',
		'tools',
		'collections/Resources',
		'collections/Appointments',
		'views/ResourcesView',
		'views/AppointmentsView'
		], function($, _, Backbone, jsReder, inTemplate, Callendar, ui, AppointmentModel,  Tools, ResourcesCollection, AppointmentsCollections, ResourcesView, AppointmentsView){

	var Event = _.extend(Backbone.Events);
	var PatientEncouterView = Backbone.View.extend({
		tagName:'tr',
		className:'encoutersRow',
		initialize: function() {
			this.render();
			
		},
		events:{
			'click .appImg' : 'modelWindowOn'
		},
		render: function(){
			if($('#PatientEncouters').length===0){
				$('body').append(inTemplate);
			}
			var template = $.templates("#PatientEncouters");
			var htmlOutput = template.render(this.model.toJSON());
         	this.$el.html(htmlOutput);
		},
		modelWindowOn: function(){
			console.log("click123");
			var template = $.templates("#modelWindow");
			var htmlOutput = template.render(this.model.toJSON());
			$('#modelContent').html(htmlOutput);
			$('.modal').css( "width", "+=300");
			$('.modal-body').css( "max-height", "+=200");

			var that = this;
			var Resources = new ResourcesCollection();
			Resources.fetch({
				success:function(){
					console.log(Resources);
					var Appointments = new AppointmentsCollections();
					Event.trigger('fetchAppointments', {model:that.model, resources:Resources});

					var ResourcesViews = new ResourcesView({collection:Resources});
					var Calender = new AppointmentsView({model:that.model, collection: new AppointmentsCollections(), editable:that.options.editable});
				},
				error: function(){
					console.log("error execut");
				}
			});
			
		},
	});
	return PatientEncouterView;
});