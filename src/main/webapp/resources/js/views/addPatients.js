/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/4/13
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
define(['underscore','jquery','backbone'], function( _, $, Backbone){

    var AddPatientsView =  Backbone.View.extend({

       tagName: 'div',
       id: 'addPatientForm',

        initialize: function (){


          this.render();
        },
        render: function() {
            this.$el.html($('#PatientsForm').html());



         }










    });



    return AddPatientsView;






});
