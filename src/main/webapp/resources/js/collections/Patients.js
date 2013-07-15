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
				this.reset();
			console.log(jsonObj);
			//var patientInfo =JSON.parse(jsonObj);
			this.add(jsonObj);
		},
		sendDataToDB: function(obj){
		
			var model = new PatientModel(obj);
			
			$.ajax({
            	type: "POST",
            	dataType:'json',
            	url: "/addPatient",
            	data:model.toJSON(),
            	success: function(msg){
                	console.log(msg)
            	}   
        	});
	    }
    
	});

	return PatientsCollection;


});