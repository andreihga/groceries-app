package com.home.projects.groceriesapp.api.model;

import com.home.projects.groceriesapp.data.model.Grocery;
import com.home.projects.groceriesapp.data.model.ShoppingList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingListItemRequest {

    Grocery grocery;

    Integer quantity;

    /*

    */
}
