define(['jquery',
		'underscore',
		'backbone',
		'PatientEncounter'
		], function($, _, Backbone, PatientEncounterView){

	var Event = _.extend(Backbone.Events);
	var PatientEncountersView =  Backbone.View.extend({
		el:'#encountersTab',
		initialize: function(){
			this.collection.on('add', this.addOne, this);
			this.render();
		},
		render: function(){
			console.log("reder");
			this.collection.each(this.addOne, this);
		},
		addOne: function(model){
				var tabEncoutersView = new PatientEncounterView({model:model});
				console.log(tabEncoutersView.el);
				this.$el.append(tabEncoutersView.el);
		}

	});
	return PatientEncountersView;
});