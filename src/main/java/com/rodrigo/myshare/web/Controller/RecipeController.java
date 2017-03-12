package com.rodrigo.myshare.web.Controller;

import com.rodrigo.myshare.model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RecipeController {

    @RequestMapping("/")
    public String listRecipes(Model model) {
       // List<Recipe> recipes = Arrays.asList(new Recipe(), new Recipe(), new Recipe(),new Recipe(),new Recipe());
        List<Recipe> recipes = new ArrayList<>();
        model.addAttribute("recipes", recipes);
        return "recipe/index";
    }
}
