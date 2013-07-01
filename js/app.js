var App = App || {};

(function (){

	 App.Patients = new App.Collections.Patients;
	 App.SearchPatients  = new App.Views.SearchPatients({collection:App.Patients});
	console.log("init");



}());




