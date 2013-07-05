define([
		'underscore',
		'backbone',
		'Patient'
	], function( _, Backbone, PatientModel){
	
	var Event = _.extend(Backbone.Events);

	var PatientsCollection = Backbone.Collection.extend({
		url:'/test',
		model:PatientModel,

		initialize: function (){
		Event.on('SuccessSearch', this.addNew, this);


		},
		addNew: function (jsonObj) {
			var a =JSON.parse(jsonObj);
			console.log(a);
			var model1 = new PatientModel({

				FirstName:"s",
        		LastName :"a",
        		SSN :"123",
        		DateOfbirth :"00.00.0000",
        		Gender :"-",
        		MaritalStatus :"xc",
        		Race :"asf",
        		Religion :"asf",
        		Language :"qw",
        		PatientAddress :"ag",
        		PatientCity :"asd",
        		PatientState :"xcb",
        		PatientZip :"e",
        		PatientPhone :"cvz",
        		EmployerName :"123",
        		EmployerAddress :"abg",
        		EmployerCity :"sdg",
        		EmployerState :"ag",
        		EmployerZip :"dsag",
        		EmployerPhone :"dsag"
			});
			console.log(model1);
			this.add(new PatientModel(a));
			
			




		}




	});



	return PatientsCollection;


});