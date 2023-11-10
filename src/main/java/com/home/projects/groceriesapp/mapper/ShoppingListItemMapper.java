package com.home.projects.groceriesapp.mapper;

import com.home.projects.groceriesapp.api.model.ShoppingListItemDto;
import com.home.projects.groceriesapp.data.model.ShoppingListItem;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingListItemMapper {

    public ShoppingListItemDto listToDto(ShoppingListItem shoppingListItem) {
        return ShoppingListItemDto.builder()
                .quantity(shoppingListItem.getQuantity())
                .name(shoppingListItem.getGrocery().getName())
                .active(shoppingListItem.getActive())
                .build();
    }
}
