define([
    'jquery',
    'underscore',
    'backbone'
], function( $, _, Backbone){

    var Event = _.extend(Backbone.Events);
    var PatientModel = Backbone.Model.extend({
        defaults:{
            "FirstName":"",
            "LastName" :"",
            "SSN" :"",
            "DateOfbirth" :"",
            "Gender" :"",
            "MaritalStatus" :"", 
            "Race" :"",
            "Religion" :"",
            "Language" :"",
            "PatientAddress" :"",
            "PatientCity" :"",
            "PatientState" :"",
            "PatientZip" :"",
            "PatientPhone" :"",
            "EmployerName" :"",
            "EmployerAddress" :"",
            "EmployerCity" :"",
            "EmployerState" :"",
            "EmployerZip" :"",
            "EmployerPhone" :""
        },
        initialize: function (){

        
        }
        



    });

    return PatientModel;
});