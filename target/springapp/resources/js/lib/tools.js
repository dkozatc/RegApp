/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
var App = App || {};

(function(){

    App.Tools.SearchRequest  = function(request){

        $.ajax({
            type: "POST",
            url: "/test",
            data:{requestString:request},
            success: function(msg){
               console.log(msg);
            }
        });








    };















}());