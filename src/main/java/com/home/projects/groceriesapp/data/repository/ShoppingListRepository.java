package com.home.projects.groceriesapp.data.repository;

import com.home.projects.groceriesapp.data.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {
    Optional<ShoppingList> findShoppingListByActive(Boolean active);
}
