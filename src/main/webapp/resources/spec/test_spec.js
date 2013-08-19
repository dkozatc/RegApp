define([
	'jquery',
	'lib/validation'
	],
	function($, Validator){

		var first = function(){
				describe("Check validation ruls for text ", function(){
					it('Return True if input date is text', function(){
            				expect(Validator.checkText("same") ).toEqual(true);
 			       	});
 			       	it('Return false when validation rules for text came in not text information', function(){
 			       		expect(Validator.checkText("131?//?sfa")).toEqual(false);
 			       	});
				});
				describe("check validation rules for Numbers", function(){
					it('Return true if input numbers in fields', function(){
						expect(Validator.checkNumbers("1231321")).toEqual(true);
					});
					it('Return false when input not nambers ', function(){
						expect(Validator.checkNumbers("dag1412>as")).toEqual(false);
					});
 				});
				describe("Check validation rules for text and nambers inputs", function(){
					it('Return true if input text or number', function(){
						expect(Validator.checkTextNambers("some123")).toEqual(true);
					});
					it('Return felse if input not text or number', function(){
						expect(Validator.checkTextNambers("asdf321?|?|@##!")).toEqual(false);
					});
				});
				describe("Check validation email", function(){
					it('Return true if email is validate', function(){
						expect(Validator.checkEmail("Mirror@some.net")).toEqual(true);
					});
					it('Return false if email is not validate', function(){
						expect(Validator.checkEmail("Mir13orsome.net")).toEqual(false);
					});
				});
				describe("Check validation of SSN", function(){
					it('Return true if SSN is validate', function(){
						expect(Validator.checkSSN("111-11-1111")).toEqual(true);
					})
					it('Return false if SSN is not validate', function(){
						expect(Validator.checkSSN("1a1-111s11")).toEqual(false);
					})
				});
				describe("Check validetion of date", function(){
					it('Return true if date is validate', function(){
						expect(Validator.checkDate("11/11/2013")).toEqual(true);
					});
					it('Return false if date is not validate', function(){
						expect(Validator.checkDate("11/1sf2013")).toEqual(false);
					});



				});

		}
		return first;
});