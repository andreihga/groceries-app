package com.home.projects.groceriesapp.api.model;

import com.home.projects.groceriesapp.data.model.Grocery;
import com.home.projects.groceriesapp.data.model.ShoppingListItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingListDto {

    UUID id;

    String name;

    Date creationDate;

    List<ShoppingListItem> groceries;
}
