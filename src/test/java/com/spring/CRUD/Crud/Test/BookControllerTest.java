package com.spring.CRUD.Crud.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.CRUD.Crud.model.Book;
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
	
	@BeforeEach
	public void initEach() {
		book1 = new Book(1L, "ABC", "ABC1", "ABC004");
		book2 = new Book(2L, "ABCD", "ABCD2", "ABC005");
	}
	
	@Test
	public void GetNameTest() {
		String name = "Shishir M.";
		String response = bookController.getName(name);
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
}
