package com.home.projects.groceriesapp.data.repository;

import com.home.projects.groceriesapp.data.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroceryRepository extends JpaRepository<Grocery, UUID> {
}
