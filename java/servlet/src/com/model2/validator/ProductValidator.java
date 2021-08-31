package com.model2.validator;

import com.model2.model.Product;
import com.model2.model.ProductFrom;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-27 14:21
 **/
public class ProductValidator {
    public List<String> validate(ProductFrom productFrom){
        List<String> errors = new ArrayList<>();
        String name = productFrom.getName();
        if(name.trim().isEmpty() || name ==null){
            errors.add("Product must have a name");
        }

        String price = productFrom.getPrice();
        if(price.trim().isEmpty() || price ==null){
            errors.add("Product must have a price");
        }else {
            try {
                Float.parseFloat(price);
            }catch (Exception e){
                errors.add("Invalid price value");
            }
        }
        return errors;
    }
}
