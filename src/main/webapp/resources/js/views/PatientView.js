define(['jquery',
		 'underscore',
		  'backbone',
		  'tools',
		 'jsrender'],

 function($, _, Backbone, Tools, JsRnder){

 	var Event = _.extend(Backbone.Events);
 	var SinglePatientView =  Backbone.View.extend({
 		tagName:'div',
 		className:'patientBlock',
 		initialize: function(){

 			Event.on('LoadTemplate', this.loadTemplate, this);
 			this.render();

 		},
 		render: function(){
 			Tools.LoadTemplate("SinglePatientTmpl");
 		},
 		loadTemplate: function(inTemplate) {
 			$('body').append(inTemplate);
			var template = $.templates("#SinglePatientBlock");
			var htmlOutput = template.render(this.model.toJSON());
          	this.$el.html(htmlOutput);
            Event.off('LoadTemplate');
 		}



 	});
 	return SinglePatientView;



});