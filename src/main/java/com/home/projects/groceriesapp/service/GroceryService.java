package com.home.projects.groceriesapp.service;

import com.home.projects.groceriesapp.api.model.GroceryDto;
import com.home.projects.groceriesapp.api.model.GroceryRequest;
import com.home.projects.groceriesapp.data.model.Grocery;
import com.home.projects.groceriesapp.data.repository.GroceryRepository;
import com.home.projects.groceriesapp.validator.GroceryValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;
    private final ModelMapper mapper = new ModelMapper();

    private final GroceryValidator groceryValidator;

    public GroceryService(GroceryRepository groceryRepository, GroceryValidator groceryValidator) {
        this.groceryRepository = groceryRepository;
        this.groceryValidator = groceryValidator;
    }

    public Grocery saveGrocery(GroceryRequest request) {

        groceryValidator.validateGroceryRequest(request);

        var grocery = mapper.map(request, Grocery.class);

        groceryRepository.save(grocery);

        return grocery;
    }

    public List<GroceryDto> getGroceries() {
        return groceryRepository.findAll().stream()
                .map(grocery -> mapper.map(grocery, GroceryDto.class))
                .collect(Collectors.toList());
    }
}
