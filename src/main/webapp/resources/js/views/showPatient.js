define(['jquery', 'underscore',
		 'backbone',
		 'text!../../templates/showPatient.html',
		 'jsrender',
		 'bootstrap'

		 ], function($, _, Backbone, inTemplate, jsrender, bootstrap){

		var Event = _.extend(Backbone.Events);
		var ShowPatientView =  Backbone.View.extend({

			tabName: 'div',
			initialize: function(){
				console.log(this.model);
				this.render();
			},
			render: function(){
				if($('#showPatient').length==0){
					$('body').html();
					$('body').append(inTemplate);
				}
				var  Encounters = this.collection.at(0);
				var InformationALL = $.extend({},this.model.toJSON(), Encounters.toJSON()) 
				console.log(this.model);
				console.log(InformationALL);
				var template = $.templates('#showPatient');
				var htmlOutput = template.render(InformationALL);
				this.$el.html(htmlOutput);
			}
		});
		return ShowPatientView;
});