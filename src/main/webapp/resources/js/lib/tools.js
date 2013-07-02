/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
var App = App || {};

(function(){

    App.Tool.SearchRequest  = function(request){

        $.ajax({
            type: "POST",
            url: "/some/",
            data:{requestString:request},
            success: function(msg){

            }
        });








    };















}());