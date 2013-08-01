define(['jquery',
		'underscore',
		'backbone',
		'jsrender',
		'text!../templates/PatientEncounters.html',
		'Fullcalender',
		'lib/jquery-ui',
		'models/Appointment',
		'tools'
		], function($, _, Backbone, jsReder, inTemplate, Callendar, ui, AppointmentModel,  Tools){

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
			console.log(this.model);
			Tools.Calendar(this.model);
		},
	});
	return PatientEncouterView;
});