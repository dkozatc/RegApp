define([
    'jquery',
    'backbone',
    'tools',
    'views/addPatients'
  ], function( $, Backbone, SearchRequest, AddPatientView){

	     var SearchPatientsView =  Backbone.View.extend({

	          el:'.container',

	          initialize: function(){

                this.render();

	           },
            events:{
		            'mouseover #inputSearch': 'showAutocomplete',
                'mouseout #inputSearch ': 'hideAutocomplete',
                'keyup #inputSearch':'searchSend',
                'click #addPatient' : 'addNewPatient'


	           },
            render: function(){
                 this.$el.append($('#navBarTemplate').html());
                 this.$el.append("<div class='autocompleteSearch'></div>");
                 $('.autocompleteSearch').hide();
            },
            searchPatients: function(){
                console.log("click");
           	},
            showAutocomplete: function(){
                console.log("showAutocomplite")
                $('.autocompleteSearch').show();


            },
            hideAutocomplete: function(){
                setTimeout(function(){ $('.autocompleteSearch').hide();}, 2000);

            },
            searchSend: function(){
                $('.autocompleteSearch').show();
                $('.autocompleteSearch').append("<p class='serchBars'>"+$('#inputSearch').val()+"</p>");
                SearchRequest($("#inputSearch").val());

            },
            addNewPatient: function(){
              console.log($('#addPatientForm').length);
                if($('#addPatientForm').length == 0){
                  
                  var AddView = new AddPatientView;
                  console.log(AddView.el);
                  this.$el.append(AddView.el);



                }





            }



   


	});


   return SearchPatientsView;





});