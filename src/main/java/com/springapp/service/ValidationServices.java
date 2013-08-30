package com.springapp.service;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/28/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */

public interface ValidationServices {
    Object getFieldRulesByModelName(String ModelName);
    boolean doValidationOfModel(String ModelName, Object model);
}
