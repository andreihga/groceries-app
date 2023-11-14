package com.home.projects.groceriesapp.api.controller;

import com.home.projects.groceriesapp.api.model.ShoppingListDto;
import com.home.projects.groceriesapp.api.model.ShoppingListItemRequest;
import com.home.projects.groceriesapp.service.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1/shopping-list")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PatchMapping
    public ResponseEntity<ShoppingListDto> createShoppingList(@RequestBody ShoppingListItemRequest request) {
        return new ResponseEntity<>(shoppingListService.addToShoppingList(request), HttpStatus.OK);
    }

    @GetMapping
    public String getShoppingList(Model model) {
        var shoppingList = shoppingListService.getActiveShoppingList();
        model.addAttribute("shoppingList", shoppingList);
        return "index";
    }
}
