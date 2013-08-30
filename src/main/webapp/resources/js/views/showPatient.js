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
		 'tools'

		 ], function($, _, Backbone, inTemplate, jsrender, bootstrap, PatientEcounters, Fullcalender, Validate, inputmask, ModelWindow, Tools){
		var Event = _.extend(Backbone.Events);
		var ShowPatientView =  Backbone.View.extend({
			tabName: 'div',
			initialize: function(){
				console.log(this.model);
				if($('#showPatient').length==0 && $('#modelWindow').length==0){
					$('body').html();
					$('body').append(inTemplate);
					$('body').append(ModelWindow);
				}
				Event.on('getValidationRulesSuccess', this.getValidationRules, this);
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
			eventShot: function(event){
		            console.log($(event.target).attr("name"));
		            console.log($(event.target).val());
		                     var valideteErrors = 0;
		                     if(this.validationRules===""){
		                         Tools.LoadValidationRules("encounters");
		                     }else{
		                         if(Validate.checkForm1($(event.target).attr("name"), $(event.target).val(), this.validationRules.date)){
		                                 $(event.target).parents('.control-group').removeClass('error');
		                         }else{
		                                 valideteErrors++;
		                                 if(valideteErrors==1){
		                                     firstErrorElement =  this;
		                                 }
		                                     $(event.target).parents('.control-group').addClass('error');
		                         }
		                      }
      		},
			addEncounter: function() {
				$('.addEncouters').toggle();
			},
			getValidationRules: function(Rules){
		        this.validationRules =  Rules;
		        console.log("rules is sets");
	        },
			sendEncounters: function(){
			   var valideteErrors = 0;
		       var Encounter = new Object();
		       var that = this;
		       if(this.validationRules!=""){
		                console.log(this.validationRules.date)
		                $("form[name='EncounterForm']").find('input').not('[type="button"]').each(function(){
		                       if(Validate.checkForm1($(this).attr('name'), $(this).val(), that.validationRules.date)){
		                            Encounter[$(this).attr('name')] = $(this).val();
		                            $(this).parents('.control-group').removeClass('error');
		                        }else{
		                            valideteErrors++;
		                            $(this).parents('.control-group').addClass('error');
		                        }
		                });
		           
		            Encounter['PatientID'] = that.model.get("PatientID");
		            if(valideteErrors==0){
		                Event.trigger('AddNewEncouter', Encounter);
		                $('.errorMessage').hide();
		            }
		        }
           	}
		});
		return ShowPatientView;
});