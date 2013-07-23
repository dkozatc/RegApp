define(['underscore',
		 'jquery', 
		 'backbone',
		 'tools',
		 'jsrender',
		 'editPatient'
], function( _, $, Backbone, Tools, jsrender, EditPatient){

		var Event = _.extend(Backbone.Events);
		var SerchResultView = Backbone.View.extend({

				tagName: 'div',
				className: 'resultBlock',

				initialize: function () {
					Event.off('LoadTemplate');
					this.render();
					Event.off('LoadTemplate');
					Event.on('LoadTemplate', this.loadTemplate, this);
				},
				events:{
					'click ' : 'PatientEdit'
					
				},
				render: function () {
					if($('#SearchBlock').length == 0){
				 		Tools.LoadTemplate("SearchResult");
					}else{
						var template = $.templates("#SearchBlock");
						var htmlOutput = template.render(this.model.toJSON());
	          			this.$el.html(htmlOutput);	
					}
				},
				loadTemplate: function (inTemplate){
				 	$('body').append(inTemplate);
				 	var template = $.templates("#SearchBlock");
					var htmlOutput = template.render(this.model.toJSON());
          			this.$el.html(htmlOutput);
            		Event.off('LoadTemplate');
         		},
         		PatientEdit: function(){
         			console.log(this.model.cid);
         			window.location.href = "http://localhost:8080/#EditPatient/"+this.model.cid;
         		}
        			
        });
		return SerchResultView ;




});