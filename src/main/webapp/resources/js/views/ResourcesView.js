define(['jquery',
		'underscore',
		'backbone',
		'views/ResourceView'
		], function($, _, Backbone, ResourceView){

	var Event = _.extend(Backbone.Events);
	var ResourcesView =  Backbone.View.extend({
		el:'#resDraggable',
		initialize: function(){
			this.collection.on('add', this.addOne, this);
			this.render();
		},
		render: function(){
			this.collection.each(this.addOne, this)
		},
		addOne: function(model){

			var Resource = new ResourceView({model:model});
			this.$el.append(Resource.el);
		}
	});

	return ResourcesView;
});