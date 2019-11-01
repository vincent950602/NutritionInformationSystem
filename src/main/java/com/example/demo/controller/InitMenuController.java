package com.example.demo.controller;

import com.example.demo.service.MaterialRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitMenuController {
    @Autowired
    MaterialRecipeService materialRecipeService;

    @RequestMapping("/initList")
    public int initMenu(){

        int abc = materialRecipeService.initMaterialRecipe();

        return abc;
    }

}


