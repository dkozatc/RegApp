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
					Event.on('SearchResult', this.loadTemplate, this);
					this.render();
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
				loadTemplate: function (intemplate){
				 	$('body').append(intemplate);
				 	var template = $.templates("#SearchBlock");
					var htmlOutput = template.render(this.model.toJSON());
          			this.$el.html(htmlOutput);
            		Event.off('SearchResult');
         		},
         		PatientEdit: function(){
         			console.log(this.model.cid);
         			window.location.href = "#EditPatient/"+this.model.cid;
         		}
        });
		return SerchResultView ;

});