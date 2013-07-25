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
		 'collections/Encounts'
		 ], function($, _, Backbone, PatientsCollection, SearchPatientsView, 
		 			AddPatientView,
		 			PatientAllCollection,
		 			AllPatientView,
		 			jsrender,
		 			EditPatient,
		 			EncounterView,
		 			EncoutersCollection
		 ){

		 var Event = _.extend(Backbone.Events);
		 var MainRouter = Backbone.Router.extend({
		 	initialize:function() {
		 	this.Encouners = new EncoutersCollection;
		 	this.Patients =  new PatientsCollection;
		 	this.PatientAll = new AllPatientView({collection:new PatientAllCollection()});
		 	},
		 	routes:{

		 		                     '' : 'indexPage',
		 		            'AddPatient': 'addNewPatient',
		 		'SearchPatients/:query' : 'SearchPatients',
		 		      'EditPatient/:id' : 'editPatient',
		 		      'addEncounter/:id'  : 'addEncounter'

		 	},
		 	indexPage: function(){
		 		$('.container').html("");
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
                     $('.container').append(AddView.el);
               }
		 	},
		 	SearchPatients: function(query){
		 		$('#addPatientForm').remove();
                $('.editPatient').remove();
                $('.PatientAll').html("");
                Event.trigger("SuccessALL", query);
                $('.container').append(this.PatientAll.el);
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
	        				$(".container").append(EditPatientView.el);
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
		 				console.log("2")
		 				var AddEncounterView = new EncounterView({model:model});
		 				console.log(AddEncounterView.el);
		 				$('.container').append(AddEncounterView.el);
		 			}
    	 		
    	 	}
		 });

		 return MainRouter;
});