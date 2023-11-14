package com.home.projects.groceriesapp.api.model;

import com.home.projects.groceriesapp.data.model.ShoppingList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroceryDto {

    UUID id;

    String name;
}
