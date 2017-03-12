package com.rodrigo.myshare.web.Controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;


public class RecipeControllerTest {

    private MockMvc mockMvc;
    private RecipeController controller;

    @Before
    public void setup() {
        controller = new RecipeController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void homeShouldRenderIndexPage() throws Exception {
        mockMvc.perform(get("/")).andExpect(view().name("recipe/index"));
    }

}