package com.jsp.lib.rep;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jsp.lib.model.BookLog;

public interface BookLogRepo extends CrudRepository<BookLog, Integer> {
//	@Query(value="select * from book_log",nativeQuery = true)
//	List<BookLog> allLog();
}
