package com.spring.CRUD.Crud.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.spring.CRUD.Crud.TestServices.BookServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ BookControllerTest.class, BookRepositoryTest.class, BookServiceTest.class })
public class AllTests {

}
