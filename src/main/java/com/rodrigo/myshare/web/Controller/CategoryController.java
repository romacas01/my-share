package com.rodrigo.myshare.web.Controller;

import com.rodrigo.myshare.model.Category;
import com.rodrigo.myshare.service.CategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService service;

    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = service.findAll();
        model.addAttribute("categories", categories);
        return "category/categories";
    }


}
