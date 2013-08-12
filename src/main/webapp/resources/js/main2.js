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
        'patientRouter' : 'routers/patientRouter',
        'Validate' : 'lib/validation',
        'inputMask' : 'lib/jquery.inputmask',
        'text' :'lib/text',
        'PatientEncounter' : 'views/PatientEncounter',
        'PatientEncounters': 'views/PatientEncounters',
        'Fullcalender':'lib/fullcalendar.min'

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
        },
        Fullcalender:{
            deps:['jquery']
        }
    }

});

require(['patientRouter', 'backbone' ], function(Router, Backbone){
    var patientRouter = new Router();
    Backbone.history.start();
});



