package com.home.projects.groceriesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping
    public String test(Model model){
        model.addAttribute("string", "rrr");
        return "test";
    }
}
