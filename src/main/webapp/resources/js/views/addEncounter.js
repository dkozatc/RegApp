define([
	'jquery',
	'underscore',
	'backbone',
	'tools',
	'jsrender',
  'Validate'
],
function($, _, Backbone, Tools, Jsrender, Validate){

	var Event = _.extend(Backbone.Events);
	var AddEncouter = Backbone.View.extend({

    		tagName:'div',
    		className:'addEncounter',
    		initialize: function() {
    		Event.on('EncounterForm', this.loadTemplate, this);
    		this.render();
       	},
    		events:{
    			'click .btn' : 'addEncounterInformation'

    		},
    		render: function() {
                console.log('render AddEncounter');
              	Tools.LoadTemplate("EncounterForm");
        },
        loadTemplate: function(inTemplate){
          console.log(inTemplate);
          $('body').append(inTemplate);
          var template = $.templates("#EncounterForm");
          var htmlOutput = template.render(this.model.toJSON());
          this.$el.html(htmlOutput);
          Event.off('EncounterForm');
        },
        addEncounterInformation: function(){
             	 var valideteErrors = 0;
                var Encounter = new Object();
                $("form[name='EncounterForm']").find('input').not('[type="button"]').each(function(){
                      if(Validate.checkForm($(this).attr('name'), $(this).val())){
                          Encounter[$(this).attr('name')] = $(this).val();
                          $(this).parents('.control-group').removeClass('error');
                      }else{
                          valideteErrors++;
                          $(this).parents('.control-group').addClass('error');
                      }
                });
                Encounter['PatientID'] = this.model.get("PatientID");
                if(valideteErrors==0){
                       Event.trigger('AddNewEncouter', Encounter);
                       $('.errorMessage').hide(); 
                }
        }
	});
	return AddEncouter;



});