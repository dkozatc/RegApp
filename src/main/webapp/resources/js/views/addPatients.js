define(['underscore',
        'jquery',
        'backbone',
        'tools',
        'Patient',
        'jsrender',
        'Validate',
        ],
        
        function( _, $, Backbone, Tools, PatientModel, JsRender, Validate){

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
                 // $('#dataofbirth').datepicker();
            },
         sendData: function (){
            var valideteErrors = 0;
            var Patient = new Object();
            $("form[name='PatientForm']").find('input,select').not('[type="button"]').each(function(){
                  if(Validate.checkForm($(this).attr('name'), $(this).val())){
                      Patient[$(this).attr('name')] = $(this).val();
                      $(this).parents('.control-group').removeClass('error');
                  }else{
                      valideteErrors++;
                      $(this).parents('.control-group').addClass('error');
                  }
            });
            if(valideteErrors==0){
                   Event.trigger('AddNewPatient', Patient);

                   //$("form[name='PatientForm']")[0].reset();
                   $('.errorMessage').hide();
            }
        },
         alerAddTrue: function (){
              $('.container').append("<div class='alert alert-success alertMessage'><button type='button' class='close' data-dismiss='alert'>&times;</button><h4>Success!</h4>Added Patient success!!</div>");
              setTimeout(function(){ $('.alert').remove();}, 3000);
         }
    });

    return AddPatientsView;






});
