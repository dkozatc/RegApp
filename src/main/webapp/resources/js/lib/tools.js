/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
define(['underscore','jquery', 'backbone'], function( _, $, Backbone){

     var Event = _.extend(Backbone.Events);
     var Tools = {};
        Tools.SearchRequest  = function(request){

        $.ajax({
            type: "POST",
            dataType:'json',
            url: "/test",
            data:{requestString:request},
            success: function(msg){
                Event.trigger('SuccessSearch', msg);      
            }   
        });

        };

        

        Tools.LoadTemplate = function(name){

            $.ajax({
            type: "GET",
            url: "/resources/templates/"+name+".html",
            data:{},
            success: function(Data){
                Event.trigger(name, Data);   

            }   
            });




        };


    return Tools;


});















