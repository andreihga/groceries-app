package com.home.projects.groceriesapp.service;

import com.home.projects.groceriesapp.api.model.ShoppingListDto;
import com.home.projects.groceriesapp.api.model.ShoppingListItemRequest;
import com.home.projects.groceriesapp.data.model.ShoppingListItem;
import com.home.projects.groceriesapp.data.repository.GroceryRepository;
import com.home.projects.groceriesapp.data.repository.ShoppingListRepository;
import com.home.projects.groceriesapp.mapper.ShoppingListItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final GroceryRepository groceryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private final ShoppingListItemMapper shoppingListItemMapper = new ShoppingListItemMapper();

    public ShoppingListService(ShoppingListRepository shoppingListRepository, GroceryRepository groceryRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.groceryRepository = groceryRepository;
    }

    public ShoppingListDto addToShoppingList(ShoppingListItemRequest request) {
        var shoppingList = shoppingListRepository.findShoppingListByActive(true)
                .orElseThrow(() -> new RuntimeException("No active shopping list found."));
        var grocery = groceryRepository.findById(request.getGroceryId())
                .orElseThrow(() -> new RuntimeException("No grocery found with this id."));
        var shoppingListItem = ShoppingListItem.builder()
                .grocery(grocery)
                .active(true)
                .quantity(request.getQuantity())
                .shoppingList(shoppingList)
                .build();

            shoppingList.getGroceries().add(shoppingListItem);
            shoppingListRepository.save(shoppingList);


        return modelMapper.map(shoppingList, ShoppingListDto.class);
    }

    public ShoppingListDto getActiveShoppingList() {
        var shoppingList = shoppingListRepository.findShoppingListByActive(true)
                .orElseThrow(() -> new RuntimeException("No active Shopping List found."));

        var shoppingListItemsDto = shoppingList.getGroceries().stream()
                .map(shoppingListItemMapper::listToDto)
                .toList();

        return ShoppingListDto.builder()
                .name(shoppingList.getName())
                .creationDate(shoppingList.getCreationDate())
                .groceries(shoppingListItemsDto)
                .build();
    }
}
