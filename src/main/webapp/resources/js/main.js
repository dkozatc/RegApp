require.config({
	path:{
		"jquery" : '/resourse/js/lib/jquery-1.10.1.min',
		"underscore" : '/resourse/js/lib/underscore',
		"backbone" : '/resourse/js/lib/backbone',
		"bootstrap" : '/resourse/js/lib/bootstrap',
		"Patients" : '/resourse/js/collections/Patients',
		"Patient:" '/resourse/js/models/Patient',
		"tools": '/resourse/js/lib/tools',
		"SearchPatients" : '/resourse/js/views/SearchPatients'




	},
	shim:{
		jquery : {
			deps : [],
			exports: '$'
		},
		underscore : {
			deps: [],
			exports: '_'
		},
		backbone : {
			deps: ['jquery', 'underscore'],
			exports: 'Backbone'
		},
		bootstrap : {
			deps: ['jquery']
		}


	}






});

require(['Patients', 'SearchPatients', 'tools'], function(PatientsCollection, SearchPatientsView, Tools){

	var Patients =  new PatientsCollection;
	var SearchView = new SearchPatientsView({collection:Patients});
	console.log("init require");


});


