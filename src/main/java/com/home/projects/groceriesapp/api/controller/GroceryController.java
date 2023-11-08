package com.home.projects.groceriesapp.api.controller;

import com.home.projects.groceriesapp.api.model.GroceryDto;
import com.home.projects.groceriesapp.api.model.GroceryRequest;
import com.home.projects.groceriesapp.service.GroceryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @PostMapping
    public String saveGrocery(@RequestBody GroceryRequest request, Model model) {
        var grocery = groceryService.saveGrocery(request);
        model.addAttribute("grocery", grocery);
        model.addAttribute("groceries", List.of());
        return "test";
    }

    @GetMapping
    public String getGroceries(Model model) {
        List<GroceryDto> groceries = groceryService.getGroceries();
        model.addAttribute("groceries", groceries);
        return "test";
    }
}
