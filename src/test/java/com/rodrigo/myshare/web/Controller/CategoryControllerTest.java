package com.rodrigo.myshare.web.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

      private CategoryController controller;
      private MockMvc mockMvc;

      @Before
      public void setup() {
          controller = new CategoryController();
          mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
      }

      @Test
      public void shouldDisplayListOfCategoriesPage() throws Exception {
          mockMvc.perform(get("/categories")).andExpect(view().name("category/categories"));
      }
}