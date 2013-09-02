define(['jquery', 'underscore',
		 'backbone',
		 'text!../../templates/showPatient.html',
		 'jsrender',
		 'bootstrap',
		 'PatientEncounters',
		 'Fullcalender',
		 'Validate',
		 'inputMask',
		 'text!../../templates/ModelWindow.html',
		 'tools',
        'views/AbstractEncounterViews'

		 ], function($, _, Backbone, inTemplate, jsrender, bootstrap, PatientEcounters, Fullcalender, Validate, inputmask, ModelWindow, Tools, AbstractEncounterViews){
		var Event = _.extend(Backbone.Events);
		var ShowPatientView =  AbstractEncounterViews.extend({
			tabName: 'div',
			initialize: function(){
				console.log(this.model);
				if($('#showPatient').length==0 && $('#modelWindow').length==0){
					$('body').html();
					$('body').append(inTemplate);
					$('body').append(ModelWindow);
				}
				this._initialize();
				this.render();
			},
			events:{
				'click #addEncountersBtn':'addEncounter',
				'click #sendEncounters' : 'sendEncounters',
				'change form' : 'eventShot'
			},
			render: function(){
				var template = $.templates('#showPatient');
				var htmlOutput = template.render(this.model.toJSON());
				this.$el.html(htmlOutput);
				console.log($('#encountersTab').html());
				var that =this;
				Tools.LoadValidationRules("encounters");
				setTimeout(function(){
				var PatientEncoutersView = new PatientEcounters({collection:that.collection, editable:that.options.editable});
				$('#TimeIn').inputmask("99/99/9999");
				$('#TimeOut').inputmask("99/99/9999");
                    if(!that.options.editable){
                        console.log( $("#addEncountersBtn").length);
                        $("#addEncountersBtn").hide();
                        $("#addEncountersBtn").remove();
                    }
		 		}, 0);
                console.log(this.options.editable);
				console.log($('#encountersTab').html());
			},
			addEncounter: function() {
				$('.addEncouters').toggle();
			}
		});
		return ShowPatientView;
});