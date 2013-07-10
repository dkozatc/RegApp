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
            cursoreFocus:false,

	          initialize: function(){

                this.render();
                Event.on('LoadTemplate', this.loadTemplate, this);
                this.collection.on('add', this.addOne, this);


	           },
            events:{
		        'focus #inputSearch': 'showAutocomplete',
            'mouseover .autocompleteSearch' : 'checkCursorPosition',
            'mouseout .autocompleteSearch' : 'unchekCursorePosition',
            'blur  #inputSearch': 'hideAutocomplete',
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
            checkCursorPosition: function(){
                this.cursoreFocus =true;


            },
            unchekCursorePosition: function(){
                this.cursoreFocus =false;


            },
            showAutocomplete: function(){

                var position = $('#inputSearch').offset();
                $('.autocompleteSearch').css('left', position.left);
                $('.autocompleteSearch').show();


            },
            hideAutocomplete: function(){
              console.log(this.cursoreFocus);
                if(!this.cursoreFocus){
                    $('.autocompleteSearch').hide();
                    var position = $('#inputSearch').offset();
                    $('.autocompleteSearch').css('left', position.left);
                }
           },
           searchSend: function(e){
                console.log(e.keyCode);
                if(e.keyCode >= 48 && e.keyCode <= 90 || e.keyCode == 8 ){
                       $('.autocompleteSearch').show();
                       var b = Tools.SearchRequest($("#inputSearch").val());
                       console.log(b);
                };

                //------cursor navigation ivents-------------
                if(e.keyCode == 38 || e.keyCode == 40 ){
                        $('.autocompleteSearch').show();
                        var coutResultBlocks = $('.autocompleteSearch').find('.resultBlock');
                        console.log("active block: " + this.activeBlock);
                        console.log("cout element: " + coutResultBlocks.length);
                        if(e.keyCode == 38){
                                if(this.activeBlock >= 0 && this.activeBlock <= coutResultBlocks.length){
                                       var coutResultBlocks = $('.autocompleteSearch').find('.resultBlock');
                                       console.log();
                                       if(coutResultBlocks.length>1 && this.activeBlock !=0){
                                            $(coutResultBlocks[this.activeBlock]).removeClass('selected');
                                            this.activeBlock--;
                                            $(coutResultBlocks[this.activeBlock]).addClass('selected');
                                        }else{
                                            $(coutResultBlocks[this.activeBlock]).addClass('selected');
                                        }
                                }
                   }
                        if(e.keyCode == 40){
                          var coutResultBlocks = $('.autocompleteSearch').find('.resultBlock');
                              if(this.activeBlock >=0 && this.activeBlock < coutResultBlocks.length){
                                        
                                        console.log($(coutResultBlocks[this.activeBlock]).addClass('selected'));
                                        console.log(this.activeBlock);
                                        if(coutResultBlocks.length>1 && this.activeBlock < coutResultBlocks.length-1){
                                           $(coutResultBlocks[this.activeBlock]).removeClass('selected');
                                           this.activeBlock++;
                                           $(coutResultBlocks[this.activeBlock]).addClass('selected');
                                        }else{
                                          $(coutResultBlocks[this.activeBlock]).addClass('selected');
                                        }
                                }
                        }
                }
              //---------------------------------------------------------------------------------------------
              //----Press enter Event for Cursor-------------------------------------------------------------
              if(e.keyCode == 13){
                   var coutResultBlocks = $('.autocompleteSearch').find('.resultBlock');
                   console.log("Enter Press"+coutResultBlocks.length);
                  if(coutResultBlocks.length>=1){
                    $(coutResultBlocks[this.activeBlock]).click();

                  }               



              }

              //---------------------------------------------------------------------------------------------


               
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