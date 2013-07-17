define(['jquery',
		'underscore',
		'backbone',
		'Patients',
		'SearchPatients'
		 ], function($, _, Backbone, PatientsCollection, SearchPatientsView){

		
		 var MainRouter = Backbone.Router.extend({



		 	routes:{

		 		'' : 'indexPage'



		 	},
		 	indexPage: function(){
		 		var Patients =  new PatientsCollection;
				var SearchView = new SearchPatientsView({collection:Patients});
				console.log("init require");
		 	}
		 });

		 return MainRouter;
});