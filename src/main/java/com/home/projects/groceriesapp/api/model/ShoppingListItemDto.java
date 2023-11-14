package com.home.projects.groceriesapp.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingListItemDto {

    UUID id;

    String name;

    Integer quantity;

    Boolean active;
}
