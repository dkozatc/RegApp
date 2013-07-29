require.config({
	baseUrl:'/resources/js/',
	paths:{
		'jquery': 'lib/jquery-1.10.1.min',
		'underscore' : 'lib/underscore',
		'backbone' : 'lib/backbone',
		'bootstrap' : 'lib/bootstrap',
		'Patients' : 'collections/Patients',
		'PatientsAll': 'collections/PatientsAll',
		'Patient':  'models/Patient',
		'tools': 'lib/tools',
		'SearchPatients' : 'views/SearchPatients',
		'jsrender' : 'lib/jsrender',
		'text' : 'lib/text',
		'editPatient' : 'views/editPatient',
		'SinglePatient' : 'views/PatientView',
		'MainRouter' : 'routers/MainRouter',
		'Validate' : 'lib/validation',
		'inputMask' : 'lib/jquery.inputmask',
		'text' :'lib/text'
		
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
		},
		inputMask :{
			deps: ['jquery']

		}
	}

});

require(['MainRouter', 'backbone' ], function(Router, Backbone){
	var MainRouter = new Router;
	Backbone.history.start();

});


