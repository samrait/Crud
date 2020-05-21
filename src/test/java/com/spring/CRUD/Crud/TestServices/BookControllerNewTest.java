package com.spring.CRUD.Crud.TestServices;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.model.Employee;
import com.spring.CRUD.Crud.service.BookService;
import com.spring.CRUD.Crud.web.BookController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerNewTest {
	
	private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;
    
//    @Rule
//    public Timeout globalTimeout = Timeout.seconds(1);
    
    Book book1 = null; 
	Book book2 = null;
	Employee emp1 = null;
	Employee emp2 = null;
	
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .build();
        book1 = new Book(1L, "ABC", "ABC1", "ABC004");
		book2 = new Book(2L, "ABCD", "ABCD2", "ABC005");
		emp1 = new Employee("Shishir", 20, "Java");
		emp2 = new Employee("Sam", 40, ".Net");
    }

    @Test
    public void GetStringNameTest() throws Exception{
    	String name= "Shishir";
    	mockMvc.perform(get("/test/"+name))
    	.andExpect(content().string(name));
    }
    
    @Test
    public void GetHelloTest() throws Exception {
    	when(bookService.hello()).thenReturn("Shishir M.");
    	
    	mockMvc.perform(get("/test"))
    	.andExpect(status().isOk())
    	.andExpect(content().string("Shishir M."));
    	
    	verify(bookService).hello();
    }
    
    
    @Test
	public void GetAllNotesTest() throws Exception{
		List<Book> book = new ArrayList<Book>();
		book.addAll(Arrays.asList(book1, book2));
		
		when(bookService.getAllBooks()).thenReturn(book);
		
		mockMvc.perform(get("/books"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].book_name", Matchers.is(book1.getBook_name())))
		.andExpect(jsonPath("$.*", Matchers.hasSize(2)));
		
		verify(bookService).getAllBooks();
	}
    
    
    @Test
	public void CreateNoteTest() throws Exception{
		Book book = new Book(1L, "ABC", "ABC1", "ABC004");
//		Book bk = new Book();
//		bk.setAuthor_name("ABC1");
//		bk.setBook_name("ABC");
//		bk.setIsbn("ABC004");
		
		when(bookService.saveBook(any(Book.class))).thenReturn(book);
//		
		mockMvc.perform(post("/books/post")
				   .contentType(MediaType.APPLICATION_JSON)
				   .content(TestUtil.convertObjectToJsonBytes(book))
				   .accept(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.book_name", Matchers.is("ABC")))
				   .andExpect(jsonPath("$.isbn", Matchers.is("ABC004")));
		
		verify(bookService).saveBook(any(Book.class));
	}
	
    @Test
	public void getBookByIsbnTest() throws Exception{
    	
		when(bookService.getBookByIsbn(book1.getIsbn())).thenReturn(book1);
		
		mockMvc.perform(get("/books/name/"+book1.getIsbn())
				   .contentType(MediaType.APPLICATION_JSON)
				   .content(book1.getIsbn()))
				   .andExpect(jsonPath("$.isbn", Matchers.is(book1.getIsbn())));
		
		verify(bookService).getBookByIsbn(book1.getIsbn());
	}
    
	@Test
	public void GetTopNameTest() throws Exception{
		List<Employee> emp = new ArrayList<Employee>();
		emp.addAll(Arrays.asList(emp1, emp2));
		
		when(bookService.getEmployeeName()).thenReturn(emp);
		
		List<Employee> result = bookController.getTopName();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getName()).isEqualTo(emp1.getName());
		
		mockMvc.perform(get("/name"))
		.andExpect(jsonPath("$.*", Matchers.hasSize(2)))
		.andExpect(jsonPath("$[0].name", Matchers.is(emp1.getName())));
		
		verify(bookService, atLeast(2)).getEmployeeName();
	}
	
}
