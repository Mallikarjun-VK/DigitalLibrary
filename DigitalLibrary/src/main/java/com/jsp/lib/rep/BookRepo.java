package com.jsp.lib.rep;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jsp.lib.model.Book;
import com.jsp.lib.model.Student;

public interface BookRepo extends CrudRepository<Book, Integer> {
	@Query(value="select * from Book where book_name=?1",nativeQuery = true)
	List<Book> findByName(String bookName);
	
//	@Query(value="update Book set no_of_books=?1 where id=?2",nativeQuery = true)
//	Book updateById(int no_of_books,int id);
}
