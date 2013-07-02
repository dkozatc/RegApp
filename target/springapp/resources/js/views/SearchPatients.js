var App = App || {};

(function(){
	
	App.Views.SearchPatients =  Backbone.View.extend({

	el:'.container',

	initialize: function(){

      this.render();

	},
    events:{
		'mouseover #inputSearch': 'showAutocomplete',
        'mouseout #inputSearch ': 'hideAutocomplete',
        'keypress #inputSearch':'searchSend'


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


    }






	});








})();