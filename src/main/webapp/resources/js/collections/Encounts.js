define([
		'underscore',
		'backbone',
		'models/Encount'
	], function( _, Backbone, EncountModel){
	
	var Event = _.extend(Backbone.Events);

	var EncountsCollection = Backbone.Collection.extend({
		url:'AddEncout',
		model:EncountModel,

    	 });
	return EncountsCollection;


	});