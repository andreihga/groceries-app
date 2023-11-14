package com.home.projects.groceriesapp.validator;

import com.home.projects.groceriesapp.api.model.GroceryRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class GroceryValidator {

    public void validateGroceryRequest(GroceryRequest request) {
        if (!Strings.isNotBlank(request.getName())) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }
}
