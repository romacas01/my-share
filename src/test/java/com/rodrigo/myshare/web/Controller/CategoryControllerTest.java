package com.rodrigo.myshare.web.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.rodrigo.myshare.dao.CategoryDao;
import com.rodrigo.myshare.model.Category;
import com.rodrigo.myshare.service.CategoryService;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CategoryController controller;

    @Mock
    private CategoryService service;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

      @Test
      public void shouldDisplayListOfCategoriesPage() throws Exception {
          //arrange behaviour
          List<Category> categories = Arrays.asList(
              new Category(1L, "Korean"),
              new Category(2L, "Med")
          );
          when(service.findAll()).thenReturn(categories);

          mockMvc.perform(get("/categories"))
              .andExpect(status().isOk())
              .andExpect(view().name("category/categories"))
              .andExpect(model().attribute("categories",categories));
          verify(service).findAll();
      }
}