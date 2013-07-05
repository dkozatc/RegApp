define(['underscore',
		 'jquery', 
		 'backbone',
		 'tools',
		 'jsrender'
], function( _, $, Backbone, Tools, jsrender){

		var Event = _.extend(Backbone.Events);
		var SerchResultView = Backbone.View.extend({

				tagName: 'div',
				className: 'resultBlock',

				initialize: function () {

					console.log(this.options.model);
					this.render();
					Event.on('LoadTemplate', this.loadTemplate, this);
				},
				render: function () {
				console.log(Tools)
				 Tools.LoadTemplate("SearchResult");
					

				},
				 loadTemplate: function (template){
				 	$('body').append(template);
				 	console.log(this.model);
				 	console.log(jsrender);

				 	var template = $.templates("#SearchBlock");
					var htmlOutput = template.render(this.model.toJSON());
          			this.$el.html(htmlOutput);
            		Event.off('LoadTemplate');

         		}







		});


		return SerchResultView ;




});