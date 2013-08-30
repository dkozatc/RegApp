define(['jquery',
		'underscore',
		'backbone'
		], function($, _, Backbone, PatientEncounterView, ResourceView){

	var Event = _.extend(Backbone.Events);
	var ResourceView =  Backbone.View.extend({
		tegName:'div',
		className:'resorce',
		initialize: function(){

			this.render();
		},
		render: function(){
			 this.$el.draggable({
                            zIndex: 999,
                            revert: true,     
                            revertDuration: 0  
                        });
			this.$el.data('ResourcesId', this.model.get('resourceId'));
			console.log(this.$el.data());
			this.$el.css('background-color', this.model.get('color'));
			this.$el.html(this.model.get('name'));


		}
	});
	return ResourceView;
});

