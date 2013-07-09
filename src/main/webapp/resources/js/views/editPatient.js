/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/8/13
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
 define(['underscore',
         'jquery',
         'backbone',
         'tools',
         'jsrender'


 ], function(_, $, Backbone, Tools, jsrende){



           var Event = _.extend(Backbone.Events);
           var EditPatientView = Backbone.View.extend({
               tagName:'div',
               className:'editPatient',

               initialize: function(){



               Event.on('LoadTemplate', this.loadTemplate, this);
               this.render();
               },
              render: function () {
                  if($('#EditForm').length == 0){
                  Tools.LoadTemplate("PatientEditForm");
                  }else{
                  var template = $.templates("#EditForm");
                  var htmlOutput = template.render(this.model.toJSON());
                  this.$el.html(htmlOutput);


                  }
              },
              loadTemplate: function (inTemplate){
                  
                  $('body').append(inTemplate);
                  var template = $.templates("#EditForm");
                  var htmlOutput = template.render(this.model.toJSON());
                  this.$el.html(htmlOutput);
                  Event.off('LoadTemplate');

             }
           });

           return EditPatientView;

 });