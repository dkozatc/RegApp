/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
define(['jquery'], function($){


     var SearchRequest  = function(request){

        $.ajax({
            type: "POST",
            url: "/test",
            data:{requestString:request},
            success: function(msg){
               console.log(msg);
            }
        });
    }



    return SearchRequest;


});















}());