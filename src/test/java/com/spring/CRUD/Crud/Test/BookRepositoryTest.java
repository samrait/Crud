package com.spring.CRUD.Crud.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.security.auth.message.AuthException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.repo.BookRepository;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {

	@Mock
	private BookRepository bookRepository;
	
	Book book = null;
	
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
	
	@Test
	public void getByIsbnTest()    {
	     
	     when(bookRepository.findBookByIsbn(book.getIsbn())).thenReturn(book);
	     
	     Book result = bookRepository.findBookByIsbn(book.getIsbn());
	     assertThat(result.getBook_name()).isEqualTo(book.getBook_name());
	}
	
	@Test
	public void getNameTest() {
		/*when(bookRepository.getName()).thenReturn(List<Object>);
		
		List<Object> result = bookRepository.getName();
		System.out.println(result);
		assertThat(result).isEqualTo(null);*/
		
		
	}
	
}
