package com.springapp.service.impl;

import com.springapp.service.ValidationServices;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/28/13
 * Time: 1:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ValidationServicesImpl implements ValidationServices {
    private JsonFactory jsonFactory;
    private JSONParser jp = new JSONParser();

    @Override
    public Object getFieldRulesByModelName(String ModelName){
        Object one = null;
        try {
            try {
                System.out.println(System.getProperty("user.dir"));
                System.out.println(System.getProperty("classpath"));
                one = jp.parse(new FileReader("c:/Users/dkozar/RegProject/src/main/resources/validationRules.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) one;
        return jsonObject.get(ModelName);
    }

    @Override
    public boolean doValidationOfModel(String ModelName, Object model) {
         /*      Object models;
        models = (Object) model.getClass().newInstanc();

        Field[] ModelFields= model.getClass().getDeclaredFields();
       JSONObject ValidationRules = (JSONObject) getFieldRulesByModelName(ModelName);

       //Field[] ValidationFields = ValidationRules.getClass().getDeclaredFields();

       for(int i=0; i<ModelFields.length; i++){

       System.out.println(ValidationRules.get(ModelFields[i].getName()));
           try {
               Field one = model.getClass().getDeclaredField(ModelFields[i].getName());
               System.out.print(one.get());
           } catch (NoSuchFieldException e) {
               e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
           }
       }    */
       return false;
    }
}
