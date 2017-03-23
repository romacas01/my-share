package com.rodrigo.myshare.service;

import com.rodrigo.myshare.dao.CategoryDao;
import com.rodrigo.myshare.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao dao;

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findById(Long id) {
      return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Category category) {

    }
}
