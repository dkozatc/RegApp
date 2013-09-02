define(['underscore',
        'jquery',
        'backbone',
        'tools',
        'Patient',
        'jsrender',
        'Validate',
        'inputMask',
        'views/AbstractPatientView'
       ],  
        function( _, $, Backbone, Tools, PatientModel, JsRender, Validate, Mask, AbstractPatientView){

            var Event = _.extend(Backbone.Events);
            var AddPatientsView =  AbstractPatientView.extend({
                tagName: 'div',
                id: 'addPatientForm',
                validationRules:null,
                initialize: function (){
                   Event.on('PatientForm', this.loadTemplate, this);
                   Event.on('AlertAddTrue', this.alerAddTrue, this);
                   Event.on('addPatientSuccess_addPatients', this.addEncounter, this);
                   this._initialize();
                   this.render();
                },
                events:{
                    'click .btn': 'sendData',
                    'change form' : 'eventShot'
                },
                render: function() {
                    console.log("render Add patient");
                    Tools.LoadTemplate("PatientForm");
                    Tools.LoadValidationRules("patient");
                },
                loadTemplate: function (inTemplate){
                    $('body').append(inTemplate);
                    var template = $.templates("#PatientForm");
                    var model = new PatientModel();
                    var htmlOutput = template.render(model.toJSON());
                    this.$el.html(htmlOutput);
                    $('h3').html("Add New Patient");
                    $('#SSN').inputmask("999-99-9999");
                    $('#dataofbirth').inputmask("99/99/9999");
                    Event.off('PatientForm');     
                },
                alerAddTrue: function (){
                    $('.container').append("<div class='alert alert-success alertMessage'><button type='button' class='close' data-dismiss='alert'>&times;</button><h4>Success!</h4>Added Patient success!!</div>");
                    setTimeout(function(){ $('.alert').remove();}, 3000);
                },
                addEncounter: function(model){
                    window.location.href = "#addEncounter/"+model.cid;
                 }
            });
            console.log(new AddPatientsView());
            return AddPatientsView;
});
