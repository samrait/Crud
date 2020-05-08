package com.spring.CRUD.Crud.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String getName(@PathVariable(value = "name") String name) {
		//System.out.println("name: "+name);
		return name;
	}
	
	// Get All Notes
    @GetMapping("/books")
    public List<Book> getAllNotes() {
    	return bookService.getAllBooks();
    }

// Create a new Note
    @PostMapping("/books")
    public Book createNote(@Valid @RequestBody Book book) {
    	return bookService.saveBook(book);
    }
    
  //Get Book by isbn
    @GetMapping("/books/name/{isbn}")
    public Book getBookByIsbn(@PathVariable(value = "isbn") String isBn){
    	return bookService.getBookByIsbn(isBn);
    }
    
    @GetMapping("/name")
    public List<Employee> getTopName(){
    	
    	return bookService.getName();
    }
}
