define(['jquery'], function(){

	var Validate = {};


	Validate.checkNumbers = function(text){

		var Rules = /[^0-9]*/i;
		if(text.search(Rules)==0) return true;
		return false;
	};
	Validate.checkText = function(text){
		var Rules = /[^a-zA-ZА-Яа-яА-Яа-я]*/i;
		if(text.search(Rules)==0) return true;
		return false;
	}
	Validate.checkTextNambers = function(text){
		var Rules = /[^a-zA-ZА-Яа-яА-Яа-я0-9]*/i;
		if(text.search(Rules)==0) return true;
		return false;
	}
	Validate.checkEmail = function(text){
		var Rules = /[a-zA-Z]{1,}@[A-Za-z]{1,}.[A-Za-z]{3}/i;
		if(text.search(Rules)==0) return false;
		return true;
	}
	Validate.checkSSN = function(text){
		var Rules = /[0-9]{3}-[0-9]{2}-[0-9]{4}/i;
		if(text.search(Rules)==0 && text.length>11) return false;
		return true;
	}
	Validate.checkDate = function(text){
		var Rules = /\d{1,2}\/\d{1,2}\/\d{1,4}/;
		if(text.search(Rules)==0 ) return false;
		return true;
	}
	


	
} );