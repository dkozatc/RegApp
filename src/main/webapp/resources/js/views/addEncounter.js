define([
    'jquery',
    'underscore',
    'backbone',
    'tools',
    'jsrender',
    'Validate',
    'views/AbstractEncounterViews'
],
    function ($, _, Backbone, Tools, Jsrender, Validate, AbstractEncounterViews) {
        var Event = _.extend(Backbone.Events);
        var AddEncouter = AbstractEncounterViews.extend({
            tagName: 'div',
            className: 'addEncounter',
            validationRules: '',
            initialize: function () {
                Event.on('EncounterForm', this.loadTemplate, this);
                this._initialize();
                this.render();
            },
            events: {
                'click .btn': 'addEncounterInformation',
                'change form': 'eventShot'
            },
            render: function () {
                console.log('render AddEncounter');
                Tools.LoadTemplate("EncounterForm");
                Tools.LoadValidationRules("encounters");
            },
            loadTemplate: function (inTemplate) {
                console.log(inTemplate);
                $('body').append(inTemplate);
                var template = $.templates("#EncounterForm");
                var htmlOutput = template.render(this.model.toJSON());
                this.$el.html(htmlOutput);
                $('#TimeIn').inputmask("99/99/9999");
                $('#TimeOut').inputmask("99/99/9999");
                Event.off('EncounterForm');
            }
        });
        return AddEncouter;
    });