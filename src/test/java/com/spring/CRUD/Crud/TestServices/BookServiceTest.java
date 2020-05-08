package com.spring.CRUD.Crud.TestServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.CRUD.Crud.model.Book;
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
	
	@Before
	public void initEach() {
		book1 = new Book(1L, "ABC", "ABC1", "ABC004");
		book2 = new Book(2L, "ABCD", "ABCD2", "ABC005");
	}
	
	@Test
	public void getAllBooksTest() {
//		Book book1 = new Book(1L, "ABC", "ABC1", "ABC004");
//		Book book2 = new Book(2L, "ABCD", "ABCD2", "ABC005");
		
		List<Book> book = new ArrayList<Book>();
		book.addAll(Arrays.asList(book1, book2));
		
		when(bookRepository.findAll()).thenReturn(book);
		
		List<Book> result = bookService.getAllBooks();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getAuthor_name()).isEqualTo(book1.getAuthor_name());
	}
	
	@Test
	public void saveBookTest() {
//		Book book1 = new Book(1L, "ABC", "ABC1", "ABC004");
		when(bookRepository.save(book1)).thenReturn(book1);
		
		Book result = bookService.saveBook(book1);
		
		assertThat(result.getAuthor_name()).isEqualTo(book1.getAuthor_name());
	}
	
	@Test
	public void getBookByIsbnTest() {
		when(bookRepository.findBookByIsbn(book1.getIsbn())).thenReturn(book1);
		
		Book result = bookService.getBookByIsbn(book1.getIsbn());
		
		assertThat(result.getIsbn()).isEqualTo(book1.getIsbn());
	}
}
