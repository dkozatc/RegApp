define([
    'jquery',
    'underscore',
    'backbone'
], function( $, _, Backbone){

    var Event = _.extend(Backbone.Events);
    var Encount = Backbone.Model.extend({
    	 defaults:{
    	 	"Diagnosis" : "none",
    	 	"Status"    : "checkout",
    	 	"PatientID" : 0,
    	 	"TimeIn"    : "00/00/0000",
    	 	"TimeOut"   : "00/00/0001"
    	 }
    	 


    });

    return Encount;
});