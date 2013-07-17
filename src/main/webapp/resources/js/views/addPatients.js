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

         Event.off('LoadTemplate');
          this.render();
          Event.on('LoadTemplate', this.loadTemplate, this);
          Event.on('AlertAddTrue', this.alerAddTrue, this);
        },
        events:{
            'click .btn': 'sendData',
        },
        render: function() {
            Tools.LoadTemplate("PatientAddForm");
         },
         loadTemplate: function (template){
            this.$el.html(template);
            Event.off('LoadTemplate');
            },
         sendData: function (){
            var Patient = new Object();
            $("form[name='addPatientForm']").find('input,select').not('[type="button"]').each(function(){
              console.log(this);
              Patient[$(this).attr('name')] = $(this).val();
            });
            console.log('execut');
            Event.trigger('AddNewPatient', Patient);

            $("form[name='addPatientForm']")[0].reset();
         },
         alerAddTrue: function (){
              $('.container').append("<div class='alert alert-success alertMessage'><button type='button' class='close' data-dismiss='alert'>&times;</button><h4>Success!</h4>Added Patient success!!</div>");
              setTimeout(function(){ $('.alert').remove();}, 3000);
         }










    });



    return AddPatientsView;






});
