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
			Event.on('SuccessALL', this.addNew, this);
		},
		addNew: function (jsonObj) {
			this.url= '/test?requestString='+jsonObj;
			this.fetch();
			this.reset();
		},
		
   });
	return PatientsCollection;

});