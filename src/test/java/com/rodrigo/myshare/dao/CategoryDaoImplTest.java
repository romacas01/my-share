package com.rodrigo.myshare.dao;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.rodrigo.myshare.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@DatabaseSetup(value= "/categories.xml")
@DatabaseTearDown(value= "/categoriesin.xml")
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class
})
public class CategoryDaoImplTest {

    @Autowired
    private CategoryDao dao;

    @Test
    public void findAllShouldReturnTwo() throws Exception {
        assertThat(dao.findAll(), hasSize(2));
        assertEquals(dao.findAll().get(0).getName(), "Italian");
        assertEquals(dao.findAll().get(1).getName(), "Japanese");

    }

}