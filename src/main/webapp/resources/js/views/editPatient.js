/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/8/13
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
 define(['underscore',
         'jquery',
         'backbone',
         'tools',
         'jsrender',
         'Validate',
         'inputMask'


 ], function(_, $, Backbone, Tools, jsrende, Validate, Mask){

           var Event = _.extend(Backbone.Events);
           var EditPatientView = Backbone.View.extend({
               tagName:'div',
               className:'editPatient',

               initialize: function(){
               Event.on('PatientForm', this.loadTemplate, this);
               Event.on('AlertUpdateTrue', this.alertUpdateTrue, this);
               this.render();
               },
               events:{
                  'click .btn-info': 'updatePatient'
               },
              render: function () {
                console.log('render editViews');
                  if($('#PatientForm').length == 0){

                  Tools.LoadTemplate("PatientForm");
                  }else{
                  var template = $.templates("#PatientForm");
                  var htmlOutput = template.render(this.model.toJSON());
                  this.$el.html(htmlOutput);


                  }
              },
              loadTemplate: function (inTemplate){
                  $('body').append(inTemplate);
                  var template = $.templates("#PatientForm");
                  var htmlOutput = template.render(this.model.toJSON());
                  this.$el.html(htmlOutput);
                  $('#SSN').inputmask("999-99-9999");
                  $('#dataofbirth').inputmask("99/99/9999");
                  Event.off('PatientForm');
             },
             updatePatient: function (){
                   var valideteErrors = 0;
                   var Patient = new Object();
                   $("form[name='PatientForm']").find('input,select').not('[type="button"]').each(function(){
                         if(Validate.checkForm($(this).attr('name'), $(this).val())){
                             Patient[$(this).attr('name')] = $(this).val();
                         }else{
                             valideteErrors++;
                         }
                   });
                   if(valideteErrors==0){
                         Patient['PatientID'] = this.model.get('PatientID');
                         Event.trigger('updatePatient', Patient);
                         $('.errorMessage').hide();
                    }       
             },
             alertUpdateTrue: function (){
                     $('.container').append("<div class='alert alert-success alertMessage'><button type='button' class='close' data-dismiss='alert'>&times;</button><h4>Success!</h4>Update Patient informaton success!!</div>");
                     setTimeout(function(){ $('.alert').remove();}, 3000);
             }
           });
           return EditPatientView;

 });