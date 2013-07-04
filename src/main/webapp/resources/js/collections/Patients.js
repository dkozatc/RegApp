define([
		'backbone',
		'Patient'
	], function(Backbone, PatientModel){
		
	var PatientsCollection = Backbone.Collection.extend({

		model:PatientModel

		




	});



	return PatientsCollection;


});