define(['jquery',
		'underscore',
		'backbone',
		'Patients',
		'SearchPatients',
		'views/addPatients',
		'PatientsAll',
		'views/PatientAllView'
		 ], function($, _, Backbone, PatientsCollection, SearchPatientsView, AddPatientView, PatientAllCollection, AllPatientView){

		 var Event = _.extend(Backbone.Events);
		 var MainRouter = Backbone.Router.extend({
		 	initialize:function() {
		 	this.Patients =  new PatientsCollection;
		 	this.PatientAll = new AllPatientView({collection:new PatientAllCollection()});
		 	},
		 	routes:{

		 		'' : 'indexPage',
		 		'AddPatient': 'addNewPatient',
		 		'SearchPatients/:query' : 'SearchPatients'
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
		 	}
		 });

		 return MainRouter;
});