package com.spring.CRUD.Crud.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.model.Employee;
import com.spring.CRUD.Crud.service.BookService;
import com.spring.CRUD.Crud.web.BookController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BookControllerTest {
	
	@InjectMocks
	BookController bookController;
	
	@Mock
	BookService bookService;
	
	Book book1 = null; 
	Book book2 = null;
	Employee emp1 = null;
	Employee emp2 = null;
	
	@BeforeEach
	public void initEach(){
		book1 = new Book(1L, "ABC", "ABC1", "ABC004");
		book2 = new Book(2L, "ABCD", "ABCD2", "ABC005");
		emp1 = new Employee("Shishir", 20, "Java");
		emp2 = new Employee("Sam", 40, ".Net");
	}
	
	@Test
	public void GetNameTest() throws Exception {
		String name = "Shishir M.";
		String response = bookController.getStringName(name);
		assertThat(response.equals(name));
	}
	
	@Test
	public void GetAllNotesTest() {
		List<Book> book = new ArrayList<Book>();
		book.addAll(Arrays.asList(book1, book2));
		
		when(bookService.getAllBooks()).thenReturn(book);
		
		List<Book> result = bookController.getAllNotes();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getAuthor_name()).isEqualTo(book1.getAuthor_name());
	}
	
	@Test
	public void CreateNoteTest() {
		
		when(bookService.saveBook(book1)).thenReturn(book1);
		
		Book result = bookController.createNote(book1);
		assertThat(result.getId()).isEqualTo(book1.getId());
	}
	
	@Test
	public void getBookByIsbnTest() {
		when(bookService.getBookByIsbn(book1.getIsbn())).thenReturn(book1);
		
		Book result = bookController.getBookByIsbn(book1.getIsbn());
		
		assertThat(result.getIsbn()).isEqualTo(book1.getIsbn());
		assertThat(result).isEqualTo(book1);
		
	}
	
	@Test
	public void getTopNameTest() {
		List<Employee> emp = new ArrayList<Employee>();
		emp.addAll(Arrays.asList(emp1, emp2));
		
		when(bookService.getEmployeeName()).thenReturn(emp);
		
		List<Employee> result = bookController.getTopName();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getName()).isEqualTo(emp1.getName());
	}
}
