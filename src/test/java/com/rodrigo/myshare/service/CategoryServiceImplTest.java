package com.rodrigo.myshare.service;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.rodrigo.myshare.dao.CategoryDao;
import com.rodrigo.myshare.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryDao dao;

    @InjectMocks
    private CategoryService service = new CategoryServiceImpl();

    @Test
    public void findAllShoudReturnTwo() throws Exception {

        //arrenge
        List<Category> categories = Arrays.asList(
            new Category(),
            new Category()
        );
        when(dao.findAll()).thenReturn(categories);

        //act and assert
        assertEquals("findAll should return two objects", 2, service.findAll().size());
        verify(dao).findAll();
    }

    @Test
    public void saveShouldSaveNewCategory() throws Exception {

        //arrange
        Category cat = new Category(6L, "Spanish");

        //act
        service.save(cat);

        //assert that the method save in the dao was called
        verify(dao).save(cat);
    }

}