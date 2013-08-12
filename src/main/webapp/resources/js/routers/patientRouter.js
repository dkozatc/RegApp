define(['jquery',
    'underscore',
    'backbone',
    'Patients',
    'SearchPatients',
    'views/addPatients',
    'PatientsAll',
    'views/PatientAllView',
    'jsrender',
    'editPatient',
    'views/addEncounter',
    'collections/Encounts',
    'Patient',
    'views/showPatient'
], function($, _, Backbone, PatientsCollection, SearchPatientsView,
            AddPatientView,
            PatientAllCollection,
            AllPatientView,
            jsrender,
            EditPatient,
            EncounterView,
            EncoutersCollection,
            PatientModel,
            showPatient
    ){

    var Event = _.extend(Backbone.Events);
    var MainRouter = Backbone.Router.extend({
        initialize:function() {
            this.Encounters = new EncoutersCollection;
            this.Patients =  new PatientsCollection;

        },
        routes:{

            '' : 'showPatient',
            'AddPatient': 'addNewPatient',
            'SearchPatients/:query' : 'SearchPatients',
            'EditPatient/:id' : 'editPatient',
            'addEncounter/:id': 'addEncounter',


        },
        indexPage: function(){
            $('#navElements').html("");
            $('#container').html("");
            var  SearchView = new SearchPatientsView({collection:this.Patients});
            console.log("init require");
        },
        showPatient: function(){
            console.log("SAme execut showns");
            var patient = new PatientModel();
            this.Encounters.url = "/Patient/patientEncounts";
            patient.url = "/Patient/showPatient";
            var that = this;
            patient.fetch({
                success: function(model, response, options){
                    console.log(model);
                    console.log(response);

                    that.Encounters.url = "/Patient/patientEncounts?id="+model.get("PatientID");
                    that.Encounters.fetch({
                        success: function(){

                            console.log(that.Encounters);
                            var ShowPatientViews = new showPatient({model:patient, collection:that.Encounters, editable:false});
                            $("#content").html(ShowPatientViews.el);

                        }
                    });


                }

            });

        }
    });
    return MainRouter;
});
