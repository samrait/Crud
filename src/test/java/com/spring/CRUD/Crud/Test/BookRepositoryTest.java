package com.spring.CRUD.Crud.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.repo.BookRepository;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Mock
	private BookRepository bookRepository;
	
	Book book = null;
	Object[] emp3 = {"Shishir", new Integer(25), "QA"};
	Object[] emp4 = {"Sam", new Integer(45), "UI"};
	
	@Before
	public void initEach() {
		book =  new Book();
		book.setAuthor_name("AB");
		book.setBook_name("AB1");
		book.setIsbn("AB00");
	}
	
	@Test
	public void saveBookTest() {
		
		when(bookRepository.save(any(Book.class))).thenReturn(book);
		
		Book result = bookRepository.save(book);
		assertThat(result.getAuthor_name()).isEqualTo(book.getAuthor_name());
	}
	
	@Test(timeout=900)
	public void getByIsbnTest()    {
	     
	     when(bookRepository.findBookByIsbn(book.getIsbn())).thenReturn(book);
	     
	     Book result = bookRepository.findBookByIsbn(book.getIsbn());
	     assertThat(result.getBook_name()).isEqualTo(book.getBook_name());
	}
	
	@Test(timeout=20)
	public void getNameTest() {
		List<Object[]> list = new ArrayList<Object[]>();
		list.addAll(Arrays.asList(emp3, emp4));
		
		when(bookRepository.getName()).thenReturn(list);
		
		List<Object[]> result = bookRepository.getName();
		
		assertThat(result.size()).isEqualTo(2);
	}
	
}
