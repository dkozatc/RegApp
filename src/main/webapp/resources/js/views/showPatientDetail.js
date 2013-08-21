define(['jquery', 'underscore',
    'backbone',
    'text!../../templates/showPatient.html',
    'jsrender',
    'bootstrap',
    'PatientEncounters',
    'Fullcalender',
    'Validate',
    'inputMask',
    'text!../../templates/ModelWindow.html',



], function($, _, Backbone, inTemplate, jsrender, bootstrap, PatientEcounters, Fullcalender, Validate, inputmask, ModelWindow){

    var Event = _.extend(Backbone.Events);
    var ShowPatientView =  Backbone.View.extend({

        tabName: 'div',
        initialize: function(){
            console.log(this.model);
            if($('#showPatient').length==0 && $('#modelWindow').length==0){
                $('body').html();
                $('body').append(inTemplate);
                $('body').append(ModelWindow);
            }
            this.render();
        },
        events:{
            'click #addEncountersBtn':'addEncounter',
            'click #sendEncounters' : 'sendEncounters'

        },
        render: function(){
            var template = $.templates('#showPatient');
            var htmlOutput = template.render(this.model.toJSON());
            this.$el.html(htmlOutput);
            console.log($('#encountersTab').html());
            var that =this;
            setTimeout(function(){
                var PatientEncoutersView = new PatientEcounters({collection:that.collection, editable:that.options.editable});
                $('#TimeIn').inputmask("99/99/9999");
                $('#TimeOut').inputmask("99/99/9999");
                if(that.options.editable == "false"){
                    console.log( $("#addEncountersBtn").length);
                    $("#addEncountersBtn").hide();
                    $("#addEncountersBtn").remove();
                }
            }, 0);
        },
        addEncounter: function() {
            $('.addEncouters').toggle();
        },
        sendEncounters: function(){
            console.log("click1");
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
    return ShowPatientView;
});