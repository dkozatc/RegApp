define([
		'underscore',
		'backbone',
		'Patient'
	], function( _, Backbone, PatientModel){
	
	var Event = _.extend(Backbone.Events);

	var PatientsCollection = Backbone.Collection.extend({
		url:'/test',
		model:PatientModel,

		initialize: function (){
			Event.on('SuccessSearch', this.addNew, this);
			Event.on('AddNewPatient', this.sendDataToDB, this);
		},
		addNew: function (jsonObj) {
			var patientInfo =JSON.parse(jsonObj);
			this.add(new PatientModel(patientInfo));
		},
		sendDataToDB: function(obj){


			$.ajax({
            	type: "POST",
            	url: "/addPatient",
            	data:{requestString:obj},
            	success: function(msg){
                	console.log(msg)
            	}   
        	});
	    }
    
	});

	return PatientsCollection;


});