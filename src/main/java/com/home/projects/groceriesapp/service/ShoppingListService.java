package com.home.projects.groceriesapp.service;

import com.home.projects.groceriesapp.data.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public void addToShoppingList(){

    }
}
