define([
    'underscore',
    'jquery',
    'backbone',
    'tools',
    'views/addPatients',
    'views/SearchResult',
    'views/PatientAllView',
    'PatientsAll'
    
  ], function( _, $, Backbone, Tools, AddPatientView, SearchResultView, AllPatientView, PatientAllCollection){
        var Event = _.extend(Backbone.Events);
	      var SearchPatientsView =  Backbone.View.extend({
	          el:'.container',
            activeBlock: 0,
            cursoreFocus:false,
	          initialize: function(){

                this.PatientAll = new AllPatientView({collection:new PatientAllCollection()});
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
               'click #searchBtn' : 'SearchPatients'

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
                     var findedPatientVeiew = new SearchResultView({model:model})
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
              
                if(!this.cursoreFocus){
                    $('.autocompleteSearch').hide();
                    var position = $('#inputSearch').offset();
                    $('.autocompleteSearch').css('left', position.left);
                }
           },
           searchSend: function(e){
                
                if(e.keyCode >= 48 && e.keyCode <= 90 || e.keyCode == 8 ){
                        $(".autocompleteSearch").html("");
                        this.activeBlock=0;
                       $('.autocompleteSearch').show();
                       Event.trigger('SuccessSearch', $("#inputSearch").val());
                       
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
                     this.$el.append(AddView.el);
               }
            },
            SearchPatients: function(){
                $('#addPatientForm').remove();
                $('.editPatient').remove();
                $('.PatientAll').html("");
                Event.trigger("SuccessALL", $("#inputSearch").val());

                this.$el.append(this.PatientAll.el);
                
            }


	});

  return SearchPatientsView;

});