define(['jquery'], function ($) {
    var Validate = {};
    Validate.checkField = function (fieldValue, validateRules) {
        switch (validateRules.Rule) {
            case "Max":
            {
                if (fieldValue.length <= validateRules.param) return true;
                return false;
                break;
            }
            case "Required":
            {
                if ((fieldValue.length > 0) == validateRules.param) return true;
                return false;
                break;
            }
            case "RegularExpression":
            {
                var Rules = new RegExp(validateRules.param, "i");
                console.log(Rules);
                if (fieldValue.search(Rules) == -1) return true;
                return false;
            }

        }
    }
    Validate.checkForm1 = function (fieldName, fieldValue, validateRules) {
        var errors = 0;
        for (var i = 0; i < validateRules[fieldName].length; i++) {
            if (Validate.checkField(fieldValue, validateRules[fieldName][i])) {
                console.log("true  First");
                $('input[name=' + fieldName + ']').parents('.controls').find('p').remove();
            } else {
                $('.errorMessage').html("");
                $('.errorMessage').show();
                $('input[name=' + fieldName + ']').parents('.controls').find('.validateMessage').html("<p class='label label-important'>Wrong " + fieldName + "</p> ");
                $('input[name=' + fieldName + ']').focus();
                errors++
            }
        }
        if (errors > 0) return false;
        return true;
    }
    return Validate;


});