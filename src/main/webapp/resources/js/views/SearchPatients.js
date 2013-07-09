define([
    'underscore',
    'jquery',
    'backbone',
    'tools',
    'views/addPatients',
    'views/SearchResult'
    
  ], function( _, $, Backbone, Tools, AddPatientView, SearchResultView){

        var Event = _.extend(Backbone.Events);

	      var SearchPatientsView =  Backbone.View.extend({

	          el:'.container',
            activeBlock: 0,
	          initialize: function(){

                this.render();
                Event.on('LoadTemplate', this.loadTemplate, this);
                this.collection.on('add', this.addOne, this);


	           },
            events:{
		        'focus #inputSearch': 'showAutocomplete',
                'click .container': 'hideAutocomplete',
                'keyup #inputSearch':'searchSend',
                'click #addPatient' : 'addNewPatient',
                'resize window': 'showAutocomplete'


	           },
            render: function(){
                  Tools.LoadTemplate("navTemplate");
                
            },
            loadTemplate: function (template){
                this.$el.append(template);
                this.$el.append("<div class='autocompleteSearch'></div>");
                $('.autocompleteSearch').hide();
                Event.off('LoadTemplate');

            },
            addOne: function (model){
                if($('.resultBlock').length < 7 ){
                     console.log($('.resultBlock').length);
                     var findedPatientVeiew = new SearchResultView({model:model})
                     console.log(findedPatientVeiew.$el);
                     $(".autocompleteSearch").append(findedPatientVeiew.el);
                }

            },
            showAutocomplete: function(){

                var position = $('#inputSearch').offset();
                $('.autocompleteSearch').css('left', position.left);
                $('.autocompleteSearch').show();


            },
            hideAutocomplete: function(){

                $('.autocompleteSearch').hide();
                var position = $('#inputSearch').offset();
                $('.autocompleteSearch').css('left', position.left);
           },
            searchSend: function(e){
                console.log(e.keyCode);
                if(e.keyCode >= 48 && e.keyCode <= 90 || e.keyCode == 8 ){
                      $('.autocompleteSearch').show();
                      var b = Tools.SearchRequest($("#inputSearch").val());
                      console.log(b);
                };
                if(e.keyCode == 38){
                  


                }
               
            },
            addNewPatient: function(){
                if ($('.editPatient').length !== 0) {
                  $('.editPatient').remove();
                 };

                if($('#addPatientForm').length == 0){
                     var AddView = new AddPatientView;
                     console.log(AddView.el);
                     this.$el.append(AddView.el);
               }
            }

	});

  return SearchPatientsView;





});