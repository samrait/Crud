package com.spring.CRUD.Crud.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.spring.CRUD.Crud.TestServices.BookControllerNewTest;
import com.spring.CRUD.Crud.TestServices.BookServiceTest;
import com.spring.CRUD.Crud.TestServices.HelloResourceTest;

@RunWith(Suite.class)
@SuiteClasses({ BookControllerTest.class, BookRepositoryTest.class, BookServiceTest.class, BookControllerNewTest.class, HelloResourceTest.class })
public class AllTests {

}
