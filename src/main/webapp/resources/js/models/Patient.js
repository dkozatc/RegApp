define([
    'backbone'
], function(Backbone){

    var PatientModel = Backbone.Model.extend({

        FirstName:"",
        LastName:"",
        SSN:"",
        DateOfbirth:"00.00.0000",
        Gender:"-",
        MaritalStatus:"",
        Race:"",
        Religion:"",
        Language:"",
        PatientAddress:"",
        PatientCity:"",
        PatientState:"",
        PatientZip:"",
        PatientPhone:"",
        EmployerName:"",
        EmployerAddress:"",
        EmployerCity:"",
        EmployerState:"",
        EmployerZip:"",
        EmployerPhone:""


    });

    return PatientModel;
});