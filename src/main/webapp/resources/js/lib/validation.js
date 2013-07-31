define(['jquery'], function($){

	var Validate = {};


	Validate.checkNumbers = function(text){
		var Rules = /[^0-9]+/i;
		if(text.search(Rules)==-1 && text.length>0) return true;
		return false;
	};
	Validate.checkText = function(text){
		var Rules = /[^a-zA-ZА-Яа-яА-Яа-я]+/i;
		console.log(text);
		//console.log(text.search(Rules));
		if(text.search(Rules)==-1 && text.length>0) return true;
		return false;
	}
	Validate.checkTextNambers = function(text){
		var Rules = /[^a-zA-ZА-Яа-яА-Яа-я0-9]*/i;
		if(text.search(Rules)==-1) return true;
		return false;
	}
	Validate.checkEmail = function(text){
		var Rules = /[a-zA-Z]{1,}@[A-Za-z]{1,}.[A-Za-z]{3}/i;
		if(text.search(Rules)==-1) return false;
		return true;
	}
	Validate.checkSSN = function(text){
		var Rules = /[0-9]{3}-[0-9]{2}-[0-9]{4}/i;
		console.log(" ssn "+text.search(Rules) + " "+text.length);
		if(text.search(Rules)==-1){ return false;}

		return true;
	}
	Validate.checkDate = function(text){
		var Rules = /\d{1,2}\/\d{1,2}\/\d{1,4}/;
		if(text.search(Rules)==-1 ) return false;
		return true;
	}
	Validate.checkForm = function(fieldName, fieldValue){

		switch(fieldName){
			case "FirstName":
				if(Validate.checkText(fieldValue)){
					console.log("true  First");
						$('input[name="FirstName"]').parents('.controls').find('p').remove();
					return true;

				}else{
						$('.errorMessage').html("");
						$('.errorMessage').show();
					//	$('input[name="FirstName"]').addClass('error');
						$('input[name="FirstName"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong First Name! First name should have  only letters</p> ");
						$('input[name="FirstName"]').focus();
					return false;
				}
				break;
			case  "LastName":
				if(Validate.checkText(fieldValue)){
					console.log("true  Last");
						$('input[name="LastName"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="LastName"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Last Name! Last name should have  only letters</p> ");
						$('input[name="LastName"]').focus();
					return false;					
				}
				break;
			case "SSN":
				if(Validate.checkSSN(fieldValue)){
					console.log("true  SSN");
						$('input[name="SSN"]').parents('.controls').find('p').remove();
					return true;
				}else{
						
						$('.errorMessage').show();	
						$('input[name="SSN"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong type of SSN!</p>")
						$('input[name="SSN"]').focus();	
					return false;				
				}
				break;
			case "DateOfbirth":
				if(Validate.checkDate(fieldValue)){
					console.log("true  DOb");
						$('input[name="DateOfbirth"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').html("<p></p>");
						$('.errorMessage').show();
						$('input[name="DateOfbirth"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Date Of birth!</p>");
					    $('input[name="DateOfbirth"]').focus();	
					return false;				
				}
				break;
			case "Gender":
				if(Validate.checkText(fieldValue)){
						$('input[name="Gender"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="Gender"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Gender!</p>");
						$('input[name="Gender"]').focus();	
					return false;					
				}
				break 
			case "MaritalStatus":
				if(Validate.checkText(fieldValue)){
						$('input[name="MaritalStatus"]').parents('.controls').find('p').remove();
					return true;
				}else{
						
						$('.errorMessage').show();		
						$('input[name="MaritalStatus"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Marital Status!</p>");
						$('input[name="MaritalStatus"]').focus();	
					return false;			
				}
				break;
			case "Race":
				if(Validate.checkText(fieldValue)){
						$('input[name="Race"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();	
						$('input[name="Race"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Race!</p>");
						$('input[name="Race"]').focus();
					return false;				
				}
				break;
			case "Religion":
				if(Validate.checkText(fieldValue)){
						$('input[name="Religion"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').html("<p></p>");
						$('.errorMessage').show();
						$('input[name="Religion"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Religion!</p>");
						$('input[name="Religion"]').focus();
					return false;					
				}
				break;
			case "Language":
				if(Validate.checkText(fieldValue)){
						$('input[name="Language"]').parents('.controls').find('p').remove();
					return true;
				}else{
					
						$('.errorMessage').show();
						$('input[name="Language"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Language!</p>");
						$('input[name="Language"]').focus();
					return false;					
				}
				break;
			case "PatientAddress":
				if(Validate.checkText(fieldValue)){
						$('input[name="PatientAddress"]').parents('.controls').find('p').remove();
					return true;
				}else{
				
						$('.errorMessage').show();
						$('input[name="PatientAddress"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Patient Address!</p>");
						$('input[name="PatientAddress"]').focus();
					return false;					
				}
				break; 
			case "PatientCity":
				if(Validate.checkText(fieldValue)){
						$('input[name="PatientCity"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="PatientCity"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Patient City!</p>");
						$('input[name="PatientCity"]').focus();
					return false;					
				}
				break; 
			case "PatientState":
				if(Validate.checkText(fieldValue)){
						$('input[name="PatientState"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').html("<p></p>");
						$('.errorMessage').show();
						$('input[name="PatientState"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Patient State!</p>");
						$('input[name="PatientState"]').focus();
					return false;					
				}
				break; 
			case "PatientPhone":
				if(Validate.checkNumbers(fieldValue)){
						$('input[name="PatientPhone"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="PatientPhone"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Patient Phone!</p>");
						$('input[name="PatientPhone"]').focus();
					return false;					
				}
				break; 
			case "PatientZip":
				if(Validate.checkNumbers(fieldValue)){
						$('input[name="PatientZip"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="PatientZip"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Patient Zip!</p>");
						$('input[name="PatientZip"]').focus();
					return false;					
				}
				break; 
			case "EmployerName":
				if(Validate.checkText(fieldValue)){
						$('input[name="EmployerName"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="EmployerName"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Employer Name!</p>");
						$('input[name="EmployerName"]').focus();
					return false;					
				}
				break; 
			case "EmployerAddress":
				if(Validate.checkText(fieldValue)){
						$('input[name="EmployerAddress"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="EmployerAddress"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Employer Address!</p>");
						$('input[name="EmployerAddress"]').focus();
					return false;					
				}
				break;
			 case "EmployerCity":
				if(Validate.checkText(fieldValue)){
						$('input[name="EmployerCity"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="EmployerCity"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Employer City!</p>");
						$('input[name="EmployerCity"]').focus();
					return false;					
				}
				break;
			case "EmployerState":
				if(Validate.checkText(fieldValue)){
						$('input[name="EmployerState"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="EmployerState"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Employer State!</p>");
						$('input[name="EmployerState"]').focus();
					return false;					
				}
				break;
			case "EmployerPhone":
				if(Validate.checkNumbers(fieldValue)){
						$('input[name="EmployerPhone"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="EmployerPhone"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Employer Phone!</p>");
						$('input[name="EmployerPhone"]').focus();
						return false;					
				}
				break;
			case "EmployerZip":
				if(Validate.checkNumbers(fieldValue)){
						$('input[name="EmployerZip"]').parents('.controls').find('p').remove();
					return true;
				}else{
						$('.errorMessage').show();
						$('input[name="EmployerZip"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Employer Zip!</p>");
						$('input[name="EmployerZip"]').focus();
					return false;					
				}
				break;
			case "Diagnose":
					if(Validate.checkText(fieldValue)){
						$('input[name="Diagnose"]').parents('.controls').find('p').remove();
					return true;
					}else{
						$('.errorMessage').show();
						$('input[name="Diagnose"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Diagnosis!</p>");
						$('input[name="Diagnose"]').focus();
					return false;					
					}
					break;
			case "Status":
					if(Validate.checkText(fieldValue)){
						$('input[name="Status"]').parents('.controls').find('p').remove();
					return true;
					}else{
						$('.errorMessage').show();
						$('input[name="Status"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Status!</p>");
						$('input[name="Status"]').focus();
					return false;					
					}
					break;
			case "TimeIn":
					if(Validate.checkDate(fieldValue)){
						$('input[name="TimeIn"]').parents('.controls').find('p').remove();
					return true;
					}else{
						$('.errorMessage').show();
						$('input[name="TimeIn"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Time in!</p>");
						$('input[name="TimeIn"]').focus();
					return false;					
					}
					break;
			case "TimeOut":
					if(Validate.checkDate(fieldValue)){
						$('input[name="TimeOut"]').parents('.controls').find('p').remove();
					return true;
					}else{
						$('.errorMessage').show();
						$('input[name="TimeOut"]').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong Time out!</p>");
						$('input[name="TimeOut"]').focus();
					return false;					
					}
					break;
		}	
		return false;
		
	}
	return Validate;
	
	
} );