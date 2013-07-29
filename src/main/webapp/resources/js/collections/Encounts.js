define([
		'underscore',
		'backbone',
		'models/Encounter'
	], function( _, Backbone, EncountModel){
	
	var Event = _.extend(Backbone.Events);

	var EncountsCollection = Backbone.Collection.extend({
		url:'AddEncout',
		model:EncountModel,
		initialize: function() {
			Event.on('AddNewEncouter' , this.insertEncounter, this);
			
		},
		insertEncounter: function(Encount){
			var model = new EncountModel(Encount);
			model.url = "addEncounter";
			console.log(model);
		    var that = this;
			model.save(model.toJSON(), {data:model.toJSON(), processData:true,
				success:function(model, response){
				console.log("good response");
					console.log(model);
					console.log(response);	
				    that.add(model);
				   
				},
				error: function(model, response){
					console.log("error hendler");
				}
			});
			Event.trigger('AlertAddTrue');
		}

    	 });
	return EncountsCollection;


	});