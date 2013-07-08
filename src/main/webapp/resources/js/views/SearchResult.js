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
					'click' : 'PatientEdit',
					'mouseout .resultBlock' : 'PatientEdit'


				},
				render: function () {
					console.log(Tools)
				 	Tools.LoadTemplate("SearchResult");
					

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
         			if($('#addPatientForm').length !== 0){
         				$('#addPatientForm').remove();
         			}

         			if($('.editPatient').length == 0){
         				var EditPatientView = new EditPatient({model:this.model});
         				console.log(EditPatientView.el);
         				$(".container").append(EditPatientView.el);

         			}else{
         				console.log('change');
         				$('.editPatient').remove();
         				var template = $.templates("#EditForm");
                		var htmlOutput = template.render(this.model.toJSON());
            		     $('.container').append(htmlOutput);

	       			}
         		},
         		alertSome: function(){
         				console.log("enit click1")

         		}

		});


		return SerchResultView ;




});