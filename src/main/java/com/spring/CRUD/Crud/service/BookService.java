package com.spring.CRUD.Crud.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.CRUD.Crud.model.Book;
import com.spring.CRUD.Crud.model.Employee;
import com.spring.CRUD.Crud.repo.BookRepository;

@Service
public class BookService {

	@Autowired
    BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public Book saveBook(@Valid Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	public Book getBookByIsbn(String isBn) {
		// TODO Auto-generated method stub
		return bookRepository.findBookByIsbn(isBn);
	}

	public List<Employee> getName() {
		// TODO Auto-generated method stub
		List<Object[]> list = bookRepository.getName();
		List<Employee> employee = new ArrayList<Employee>();
		for(Object[] emp : list) {
			Employee e = new Employee();
			e.setName(emp[0].toString());
			e.setSalary((int)emp[1]);
			e.setSname(emp[2].toString());
			employee.add(e);
		}
		return employee;
	}

}
