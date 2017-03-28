package com.rodrigo.myshare.web.Controller;

import com.rodrigo.myshare.model.Category;
import com.rodrigo.myshare.service.CategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        Category category = service.findById(id);
        model.addAttribute("category", category);
        return "category/details";
    }

    @RequestMapping("/categories/new")
    public String displayForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String addCategory(Category category) {
        service.save(category);
        return "redirect:/categories/" + category.getId();
    }
}
