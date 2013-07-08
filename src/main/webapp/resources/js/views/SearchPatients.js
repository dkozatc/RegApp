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

	          initialize: function(){

                this.render();
                Event.on('LoadTemplate', this.loadTemplate, this);
                this.collection.on('add', this.addOne, this);


	           },
            events:{
		            'mouseover #inputSearch': 'showAutocomplete',
                'mouseout #inputSearch ': 'hideAutocomplete',
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
                  console.log(model);
                  var findedPatientVeiew = new SearchResultView({model:model})
                  console.log(findedPatientVeiew.$el);
                  $(".autocompleteSearch").append(findedPatientVeiew.el);



            },
            showAutocomplete: function(){

                var position = $('#inputSearch').offset();
                $('.autocompleteSearch').css('left', position.left);
                $('.autocompleteSearch').show();


            },
            hideAutocomplete: function(){

                setTimeout(function(){ $('.autocompleteSearch').hide();}, 2000);
                 var position = $('#inputSearch').offset();
                $('.autocompleteSearch').css('left', position.left);
           },
            searchSend: function(){
                $('.autocompleteSearch').show();
                //$('.autocompleteSearch').append("<p class='serchBars'>"+$('#inputSearch').val()+"</p>");
                 var b = Tools.SearchRequest($("#inputSearch").val());
                 console.log(b);

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