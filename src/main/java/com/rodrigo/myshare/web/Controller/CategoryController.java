package com.rodrigo.myshare.web.Controller;

import com.rodrigo.myshare.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @RequestMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = new ArrayList<>();
        model.addAttribute("categories", categories);
        return "category/categories";
    }
}
