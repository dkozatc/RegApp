define([
    'jquery',
    'underscore',
    'backbone'
], function( $, _, Backbone){

    var Event = _.extend(Backbone.Events);
    var PatientModel = Backbone.Model.extend({
        defaults:{
            "FirstName":"s",
            "LastName" :"a",
            "SSN" :"123",
            "DateOfbirth" :"00.00.0000",
            "Gender" :"-",
            "MaritalStatus" :"xc", 
            "Race" :"asf",
            "Religion" :"asf",
            "Language" :"qw",
            "PatientAddress" :"ag",
            "PatientCity" :"asd",
            "PatientState" :"xcb",
            "PatientZip" :"e",
            "PatientPhone" :"cvz",
            "EmployerName" :"123",
            "EmployerAddress" :"abg",
            "EmployerCity" :"sdg",
            "EmployerState" :"ag",
            "EmployerZip" :"dsag",
            "EmployerPhone" :"dsag"
        },
        initialize: function (){

        
        }
        



    });

    return PatientModel;
});