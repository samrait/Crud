package com.spring.CRUD.Crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.CRUD.Crud.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "SELECT * FROM Books1 b WHERE b.isbn = :isbn", nativeQuery=true)
	public Book findBookByIsbn(@Param("isbn") String isBn);

	@Query(value = "SELECT e.name, e.salary, s.sname FROM emp e INNER JOIN skill s INNER JOIN emp_skill es ON e.id=es.emp_id AND s.id=es.skill_id ORDER BY e.salary DESC LIMIT 5", nativeQuery=true)
	List<Object[]> getName();
	
}
