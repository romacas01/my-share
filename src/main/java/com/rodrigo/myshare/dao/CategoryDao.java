package com.rodrigo.myshare.dao;


import com.rodrigo.myshare.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Category category);
}
