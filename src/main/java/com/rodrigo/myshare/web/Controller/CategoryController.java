package com.rodrigo.myshare.web.Controller;

import com.rodrigo.myshare.model.Category;
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
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createCriteria(Category.class).list();
        model.addAttribute("categories", categories);
        return "category/categories";
    }
}
