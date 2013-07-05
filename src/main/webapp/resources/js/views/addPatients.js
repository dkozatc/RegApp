/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/4/13
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
define(['underscore',
        'jquery',
        'backbone',
        'tools'],
        
        function( _, $, Backbone, Tools){

    var Event = _.extend(Backbone.Events);
    var AddPatientsView =  Backbone.View.extend({

       tagName: 'div',
       id: 'addPatientForm',

        initialize: function (){


          this.render();
          Event.on('LoadTemplate', this.loadTemplate, this);
        },
        render: function() {
            Tools.LoadTemplate("PatientAddForm");



         },
         loadTemplate: function (template){
            this.$el.html(template);
            Event.off('LoadTemplate');





         }










    });



    return AddPatientsView;






});
