package com.example.demo.controller;

import com.example.demo.entity.MaterialRecipe;
import com.example.demo.entity.Recipes;
import com.example.demo.repository.MaterialRecipeRepository;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @Autowired
    MaterialRecipeRepository materialRecipeRepository;

    @RequestMapping("/")
    public String index(){return "login";}

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "5") Integer size){

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<MaterialRecipe> recipeList = materialRecipeRepository.findList(pageable);
        model.addAttribute("recipe",recipeList);

        return "Index";
    }
}
