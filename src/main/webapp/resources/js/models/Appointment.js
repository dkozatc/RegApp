define([
    'jquery',
    'underscore',
    'backbone'
], function( $, _, Backbone){

    var Event = _.extend(Backbone.Events);
    var Appointment = Backbone.Model.extend({
        url:'addAppointment',
    	 initialize: function(){
           
         }
    });
    return Appointment;
});