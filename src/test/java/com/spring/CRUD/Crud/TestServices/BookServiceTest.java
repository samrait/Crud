package com.spring.CRUD.Crud.TestServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.model.Employee;
import com.spring.CRUD.Crud.repo.BookRepository;
import com.spring.CRUD.Crud.service.BookService;
import org.mockito.junit.MockitoJUnitRunner;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	@InjectMocks
	BookService bookService;
	
	@Mock
	BookRepository bookRepository;
	
	Book book1 = null; 
	Book book2 = null;
	Object[] emp1 = new Object[3];
	Object[] emp2 = new Object[3];
	Object[] emp3 = {"Shishir", new Integer(25), "QA"};
	Object[] emp4 = {"Sam", new Integer(45), "UI"};
	
	@Before
	public void initEach() {
		book1 = new Book(1L, "ABC", "ABC1", "ABC004");
		book2 = new Book(2L, "ABCD", "ABCD2", "ABC005");
		emp1[0] = "Shishir";
		emp1[1] = "";
		emp1[2] = "Java";
		emp2[0] = "Sam";
		emp2[1] = "";
		emp2[2] = ".Net";
	
	}
	
	@Test
	public void HelloTest() {
		String result = bookService.hello();
		assertThat(result).isEqualTo("Shishir M.");
	}
	
	@Test
	public void getAllBooksTest() {
		List<Book> book = new ArrayList<Book>();
		book.addAll(Arrays.asList(book1, book2));
		
		when(bookRepository.findAll()).thenReturn(book);
		
		List<Book> result = bookService.getAllBooks();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getAuthor_name()).isEqualTo(book1.getAuthor_name());
		
		verify(bookRepository).findAll();
	}
	
	@Test
	public void saveBookTest() {
		when(bookRepository.save(book1)).thenReturn(book1);
		
		Book result = bookService.saveBook(book1);
		
		assertThat(result.getAuthor_name()).isEqualTo(book1.getAuthor_name());
		verify(bookRepository).save(book1);
	}
	
	@Test
	public void getBookByIsbnTest() {
		when(bookRepository.findBookByIsbn(book1.getIsbn())).thenReturn(book1);
		
		Book result = bookService.getBookByIsbn(book1.getIsbn());
		
		assertThat(result.getIsbn()).isEqualTo(book1.getIsbn());
		verify(bookRepository).findBookByIsbn(book1.getIsbn());
	}
	
	@Test
	public void getNameTest() {
		List<Object[]> list = new ArrayList<Object[]>();
		list.addAll(Arrays.asList(emp3, emp4));
		
		when(bookRepository.getName()).thenReturn(list);
		
		List<Employee> result = bookService.getEmployeeName();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getName()).isEqualTo(emp3[0]);
		
		verify(bookRepository).getName();
	}
}
