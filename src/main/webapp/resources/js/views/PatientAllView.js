define(['jquery', 'underscore', 'backbone', 'SinglePatient'], function($, _, Backbone, PatientView){
	
	var PatientAllView = Backbone.View.extend({
		tagName:'div',
		className:'PatientAll',
		initialize: function (){
			this.render();
			this.collection.on('add', this.addOne, this);
		},
		render: function (){
			console.log("init PatientAll");

		},
		addOne: function(model){
			var SinglePatient = new PatientView({model:model});
			this.$el.append(SinglePatient.el);
			console.log(this.collection);
		}
	});
	return PatientAllView;

});