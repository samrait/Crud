package com.spring.CRUD.Crud.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.model.Employee;
import com.spring.CRUD.Crud.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/test/{name}")
	public String getStringName(@PathVariable(value = "name") String name) {
		//System.out.println("name: "+name);
		return name;
	}
	
	@GetMapping("/test")
    public String helloWorld() {
        return bookService.hello();
    }
	
	// Get All Notes
    @GetMapping("/books")
    public List<Book> getAllNotes() {
    	Book book = new Book(1L, "ABC", "ABC1", "ABC004");
		System.out.println("Book######################## "+String.valueOf(book));
    	return bookService.getAllBooks();
    }

    // Create a new Note
    @PostMapping(value = "/books/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book createNote(@Valid @RequestBody Book book) {
    	return bookService.saveBook(book);
    }
    
  //Get Book by isbn
    @GetMapping(value ="/books/name/{isbn}")
    public Book getBookByIsbn(@PathVariable(value = "isbn") String isBn){
    	return bookService.getBookByIsbn(isBn);
    	//return new Book();
    }
    
    @GetMapping("/name")
    public List<Employee> getTopName(){
    	return bookService.getEmployeeName();
    }
}
