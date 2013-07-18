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
        'tools',
        'Patient',
        'jsrender'],
        
        function( _, $, Backbone, Tools, PatientModel, JsRender){

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
            Tools.LoadTemplate("PatientForm");
         },
         loadTemplate: function (inTemplate){
                  $('body').append(inTemplate);
                  var template = $.templates("#PatientForm");
                  var model = new PatientModel();
                  var htmlOutput = template.render(model.toJSON());
                  this.$el.html(htmlOutput);
                    $('h3').html("Add New Patient");
            Event.off('LoadTemplate');
            },
         sendData: function (){

            var Patient = new Object();
            $("form[name='PatientForm']").find('input,select').not('[type="button"]').each(function(){
              console.log(this);
              Patient[$(this).attr('name')] = $(this).val();
            });
            console.log(Patient);
            Event.trigger('AddNewPatient', Patient);

            $("form[name='PatientForm']")[0].reset();
         },

         alerAddTrue: function (){
              $('.container').append("<div class='alert alert-success alertMessage'><button type='button' class='close' data-dismiss='alert'>&times;</button><h4>Success!</h4>Added Patient success!!</div>");
              setTimeout(function(){ $('.alert').remove();}, 3000);
         }
    });



    return AddPatientsView;






});
