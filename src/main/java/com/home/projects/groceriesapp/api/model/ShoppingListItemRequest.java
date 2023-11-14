package com.home.projects.groceriesapp.api.model;

import com.home.projects.groceriesapp.data.model.Grocery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingListItemRequest {

    UUID groceryId;

    Integer quantity;
}
