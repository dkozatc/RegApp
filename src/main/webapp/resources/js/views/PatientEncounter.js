define(['jquery',
		'underscore',
		'backbone',
		'jsrender',
		'text!../templates/PatientEncounters.html',
		'Fullcalender',
		'lib/jquery-ui'
		], function($, _, Backbone, jsReder, inTemplate, Callendar, ui){

	var Event = _.extend(Backbone.Events);
	var PatientEncouterView = Backbone.View.extend({
		tagName:'tr',
		className:'encoutersRow',
		initialize: function() {
			this.render();
			
		},
		events:{
			'click .appImg' : 'modelWindowOn'
		},
		render: function(){
			if($('#PatientEncouters').length===0){
				$('body').append(inTemplate);
			}
			var template = $.templates("#PatientEncouters");
			var htmlOutput = template.render(this.model.toJSON());
         	this.$el.html(htmlOutput);
		},
		modelWindowOn: function(){
			console.log("click123");
			var template = $.templates("#modelWindow");
			var htmlOutput = template.render(this.model.toJSON());
			$('#modelContent').html(htmlOutput);
			$('.modal').css( "width", "+=250");
			$('.modal-body').css( "max-height", "+=200");
			$('#myModal').on('shown', function(){
				$("#calendar").fullCalendar({
					 header:{
						left: 'prev,next today',
						center: 'title',
						right: 'month,basicWeek,basicDay'
					 },
					 weekends: false,
					 droppable: true,
					 editable: true,
					 events:[
					 {
					 	title: "test Event",
					 	start: new Date(2013, 6, 1)
					 }
					 ],
					 drop: function (date, allDay) {
							var obj = {
								title:$(this).text(),
								start:date,
								allDay:true
							}
						 $('#calendar').fullCalendar('renderEvent',  obj, true);
					console.log(obj);
					}
				});
			});
					$('.d').each(function() {
				  					
					// make the event draggable using jQuery UI
					$(this).draggable({
						zIndex: 999,
						revert: true,      // will cause the event to go back to its
						revertDuration: 0  //  original position after the drag
					});
					
				});

			
		
			

		},
		


	});
	return PatientEncouterView;
});