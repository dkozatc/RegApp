define(['jquery', 'underscore','backbone'], function($, _, Backbone){

		var Event = _.extend(Backbone.Events);
		var resourceModel = Backbone.Model.extend({
			defaults:{
				"resourceId": 0,
				"name": "reabilitation",
				"color" : "#FFB700",
			}



		});


	


		return resourceModel;

});