define(['jquery',
		'underscore',
		'backbone',
		'Patients',
		'SearchPatients',
		'views/addPatients',
		'PatientsAll',
		'views/PatientAllView',
		 'jsrender',
		 'editPatient',
		 'views/addEncounter',
		 'collections/Encounts',
		 'Patient',
		 'views/showPatient'
		 ], function($, _, Backbone, PatientsCollection, SearchPatientsView, 
		 			AddPatientView,
		 			PatientAllCollection,
		 			AllPatientView,
		 			jsrender,
		 			EditPatient,
		 			EncounterView,
		 			EncoutersCollection,
		 			PatientModel,
		 			showPatient
		 ){

		 var Event = _.extend(Backbone.Events);
		 var MainRouter = Backbone.Router.extend({
		 	initialize:function() {
		 	this.Encounters = new EncoutersCollection;
		 	this.Patients =  new PatientsCollection;
		 	
		 	},
		 	routes:{

		 		                     '' : 'indexPage',
		 		            'AddPatient': 'addNewPatient',
		 		'SearchPatients/:query' : 'SearchPatients',
		 		      'EditPatient/:id' : 'editPatient',
		 		      'addEncounter/:id': 'addEncounter',
		 		      'showPatient/:id' : 'showPatient'

		 	},
		 	indexPage: function(){
		 		$('#navElements').html("");
		 		$('#container').html("");
		 	 	var  SearchView = new SearchPatientsView({collection:this.Patients});
				console.log("init require");
		 	},
		 	addNewPatient: function(){
		 		console.log("Rout 1");
		 		if($('.editPatient').length !== 0) {
                     $('.editPatient').remove();
                };
                $('.PatientAll').remove();
                if($('#addPatientForm').length == 0){
                     var AddView = new AddPatientView;
                     $('#content').html(AddView.el);
               }
		 	},
		 	SearchPatients: function(query){
		 		var PatientAll = new AllPatientView({collection:new PatientAllCollection()});
		 		$('#addPatientForm').remove();
                $('.editPatient').remove();
                $('.PatientAll').html("");
                Event.trigger("SuccessALL", query);
                console.log(PatientAll.el);
                $('#content').html(PatientAll.el);
		 	},
		 	editPatient: function(id){
		 			var model = this.Patients.get(id);
		 			console.log(model);
		 			if(model){
				 		if($('#addPatientForm').length !== 0){
	         				$('#addPatientForm').remove();
	         			}
	         			if($('.editPatient').length == 0 && $('#PatientsEditForm').length == 0){
	         				var EditPatientView = new EditPatient({model:model});
	        				$("#content").html(EditPatientView.el);
	         			}else{
	         				var template = $.templates("#PatientForm");
	                		var htmlOutput = template.render(model.toJSON());
	            		     $('.editPatient').html(htmlOutput);
		       			}
		       			$('#inputSearch').val(model.get('FirstName')+" "+ model.get('LastName'));
	 	      			$('.autocompleteSearch').hide();
 	      			}else{
 	      				window.location.href = "http://localhost:8080/";
 	      			}
    	 	},
    	 	addEncounter: function(id){
    	 			var model = this.Patients.get(id);
		 			console.log(model);
		 			if(model){
		 				
		 				var AddEncounterView = new EncounterView({model:model});
		 				console.log(AddEncounterView.el);
		 				$('#content').html(AddEncounterView.el);
		 			}
    	 	},
    	 	showPatient: function(id){
    	 			var patient = new PatientModel();
    	 			this.Encounters.url = '/patientEncounts?id='+id;
    	 			patient.url = "/showPatient?id="+id;
    	 			var that = this;
	   	 			patient.fetch({
	   	 			success: function(){
	   	 				that.Encounters.fetch({
	   	 					success: function(){

				   	 			console.log(that.Encounters);
				   	 			var ShowPatientViews = new showPatient({model:patient, collection:that.Encounters});
				   	 			$("#content").html(ShowPatientViews.el);

	   	 					}
	   	 				});


	   	 			}

	   	 			});
	
    	 	}	
		 });
		 return MainRouter;
});