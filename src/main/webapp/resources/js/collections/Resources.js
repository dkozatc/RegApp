define([
		'underscore',
		'backbone',
		'models/Resource'
	], function( _, Backbone, resourceModel){
	
	var Event = _.extend(Backbone.Events);
	var resourceCollection = Backbone.Collection.extend({
		url:'/resources/JSONS/Resources.json',
		model:resourceModel,


	});
	return resourceCollection;
});



