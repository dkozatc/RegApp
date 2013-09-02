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
    'tools'

], function ($, _, Backbone, inTemplate, jsrender, bootstrap, PatientEcounters, Fullcalender, Validate, inputmask, ModelWindow, Tools) {
    var Event = _.extend(Backbone.Events);
    var ShowPatientView = Backbone.View.extend({

        _initialize: function () {
            Event.on('getValidationRulesSuccess', this.getValidationRules, this);
        },
        eventShot: function (event) {
            console.log($(event.target).attr("name"));
            console.log($(event.target).val());
            var valideteErrors = 0;
            if (this.validationRules == null) {
                Tools.LoadValidationRules("patient");
            } else {
                if (Validate.checkForm1($(event.target).attr("name"), $(event.target).val(), this.validationRules.data)) {
                    $(event.target).parents('.control-group').removeClass('error');
                } else {
                    $(event.target).parents('.control-group').addClass('error');
                }
            }
        },
        getValidationRules: function (Rules) {
            this.validationRules = Rules;
            console.log("rules is sets");
        },
        sendData: function () {
            var valideteErrors = 0;
            var Patient = new Object();
            var firstErrorElement;
            console.log("same hendler");
            var that = this;
            if (this.validationRules != "") {
                $("form[name='PatientForm']").find('input,select').not('[type="button"]').each(function () {
                    if (Validate.checkForm1($(this).attr('name'), $(this).val(), that.validationRules.data)) {
                        Patient[$(this).attr('name')] = $(this).val();
                        $(this).parents('.control-group').removeClass('error');
                    } else {
                        valideteErrors++;
                        if (valideteErrors == 1) {
                            firstErrorElement = this;
                        }
                        $(this).parents('.control-group').addClass('error');
                    }
                });
                if (valideteErrors == 0) {
                    Event.trigger('AddNewPatient', Patient);
                    $('.errorMessage').hide();
                    $('#addPatientForm').remove();
                } else {
                    $(firstErrorElement).focus();
                }
            }
        }
    });

    return  ShowPatientView;
});