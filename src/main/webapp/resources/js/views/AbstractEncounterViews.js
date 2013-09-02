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
            _initialize: function(){
                Event.on('getValidationRulesSuccess', this.getValidationRules, this);
            },
            eventShot: function (event) {
                console.log($(event.target).attr("name"));
                console.log($(event.target).val());
                var valideteErrors = 0;
                if (this.validationRules === "") {
                    Tools.LoadValidationRules("encounters");
                } else {
                    if (Validate.checkForm1($(event.target).attr("name"), $(event.target).val(), this.validationRules.data)) {
                        $(event.target).parents('.control-group').removeClass('error');
                    } else {
                        valideteErrors++;
                        if (valideteErrors == 1) {
                            firstErrorElement = this;
                        }
                        $(event.target).parents('.control-group').addClass('error');
                    }
                }
            },
            getValidationRules: function (Rules) {
                this.validationRules = Rules;
                console.log("rules is sets");
            },
            addEncounterInformation: function () {
                var valideteErrors = 0;
                var Encounter = new Object();
                var that = this;
                if (this.validationRules != "") {
                    console.log(this.validationRules.date)
                    $("form[name='EncounterForm']").find('input').not('[type="button"]').each(function () {
                        if (Validate.checkForm1($(this).attr('name'), $(this).val(), that.validationRules.data)) {
                            Encounter[$(this).attr('name')] = $(this).val();
                            $(this).parents('.control-group').removeClass('error');
                        } else {
                            valideteErrors++;
                            $(this).parents('.control-group').addClass('error');
                        }
                    });

                Encounter['PatientID'] = that.model.get("PatientID");
                    if (valideteErrors == 0) {
                        Event.trigger('AddNewEncouter', Encounter);
                        $('.errorMessage').hide();
                    }
                }
            }
        });
        return AddEncouter;
});
