define(['underscore',
		 'jquery', 
		 'backbone',
		 'tools',
		 'jsrender',
		 'editPatient'
], function( _, $, Backbone, Tools, jsrender, EditPatient){

		var Event = _.extend(Backbone.Events);
		var SerchResultView = Backbone.View.extend({

				tagName: 'div',
				className: 'resultBlock',

				initialize: function () {
					
					this.render();
					Event.off('LoadTemplate');
					Event.on('LoadTemplate', this.loadTemplate, this);
				},
				events:{
					'click ' : 'PatientEdit'
					
				},
				render: function () {
					if($('#SearchBlock').length == 0){
				 		Tools.LoadTemplate("SearchResult");
					}else{
						var template = $.templates("#SearchBlock");
						var htmlOutput = template.render(this.model.toJSON());
	          			this.$el.html(htmlOutput);	
					}
				},
				loadTemplate: function (inTemplate){
				 	$('body').append(inTemplate);
				 	var template = $.templates("#SearchBlock");
					var htmlOutput = template.render(this.model.toJSON());
          			this.$el.html(htmlOutput);
            		Event.off('LoadTemplate');
         		},
         		PatientEdit: function(model){
         	
        			if($('#addPatientForm').length !== 0){
         				$('#addPatientForm').remove();
         			}
         			if($('.editPatient').length == 0 && $('#PatientsEditForm').length == 0){
         				var EditPatientView = new EditPatient({model:this.model});
        				$(".container").append(EditPatientView.el);
         			}else{
         				var template = $.templates("#PatientForm");
                		var htmlOutput = template.render(this.model.toJSON());
            		     $('.editPatient').html(htmlOutput);
	       			}
	       			$('#inputSearch').val(this.model.get('FirstName')+" "+ this.model.get('LastName'));
	       			$('.autocompleteSearch').hide();
         		},
        });


		return SerchResultView ;




});