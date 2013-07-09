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

					console.log(this.options.model);
					this.render();
					Event.on('LoadTemplate', this.loadTemplate, this);
				},
				events:{
					'click ' : 'PatientEdit'
					
				},
				render: function () {
					console.log(Tools)
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
				 	console.log(this.model);
				 
				 	var template = $.templates("#SearchBlock");
					var htmlOutput = template.render(this.model.toJSON());
          			this.$el.html(htmlOutput);
            		Event.off('LoadTemplate');

         		},
         		PatientEdit: function(model){
         			console.log("click");
         			if($('#addPatientForm').length !== 0){
         				$('#addPatientForm').remove();
         			}

         			if($('.editPatient').length == 0 && $('#PatientsEditForm').length == 0){
         				var EditPatientView = new EditPatient({model:this.model});
         				console.log(EditPatientView.el);
         				$(".container").append(EditPatientView.el);

         			}else{
         				console.log('change');
         				
         				var template = $.templates("#EditForm");
                		var htmlOutput = template.render(this.model.toJSON());
            		     $('.editPatient').html(htmlOutput);

	       			}
         		},
         		alertSome: function(){
         				console.log("enit click1")

         		}

		});


		return SerchResultView ;




});