define([
    'underscore',
    'backbone',
    'Patient'
], function (_, Backbone, PatientModel) {

    var Event = _.extend(Backbone.Events);

    var PatientsCollection = Backbone.Collection.extend({
        url: 'test',
        model: PatientModel,

        initialize: function () {
            Event.on('SuccessSearch', this.addNew, this);
            Event.on('AddNewPatient', this.sendDataToDB, this);
            Event.on('updatePatient', this.updatePatient, this);
        },
        addNew: function (jsonObj) {
            this.url = 'test?requestString=' + jsonObj;
            this.fetch();
        },
        sendDataToDB: function (obj) {
            var model = new PatientModel(obj);
            model.url = "addPatient";
            model.set('PatientID', 0);
            var that = this;
            model.save(model.toJSON(), {data: model.toJSON(), processData: true,
                success: function (model, response) {
                    console.log("good response");
                    console.log(model);
                    var id = model.get("date")
                    model.set("PatientID", id);

                    console.log(response);
                    that.add(model);
                    Event.trigger('addPatientSuccess_addPatients', model);

                },
                error: function (model, response) {
                    console.log("error hendler");
                }
            });
            Event.trigger('AlertAddTrue');
        },
        updatePatient: function (object) {
            var model = new PatientModel(object);
            model.url = 'updatePatient';
            model.save(model.toJSON(), {data: model.toJSON(), processData: true});
            Event.trigger('AlertUpdateTrue');
        }
    });
    return PatientsCollection;


});