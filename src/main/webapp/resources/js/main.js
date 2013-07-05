require.config({
	baseUrl:'/resources/js/',
	paths:{
		'jquery': 'lib/jquery-1.10.1.min',
		'underscore' : 'lib/underscore',
		'backbone' : 'lib/backbone',
		'bootstrap' : 'lib/bootstrap',
		'Patients' : 'collections/Patients',
		'Patient':  'models/Patient',
		'tools': 'lib/tools',
		'SearchPatients' : 'views/SearchPatients',
		'jsrender' : 'lib/jsrender',
		'text' : 'lib/text'




	},
	shim:{
		jquery : {
			deps : [],
			exports: '$'
		},
		jsrender : {
			deps : ['jquery'],
			exports: 'jsrender'
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

require(['Patients', 'SearchPatients'], function(PatientsCollection, SearchPatientsView){

	var Patients =  new PatientsCollection;
	var SearchView = new SearchPatientsView({collection:Patients});
	console.log("init require");


});


