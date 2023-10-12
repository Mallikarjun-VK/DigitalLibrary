package com.jsp.lib.rep;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jsp.lib.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{
	@Query(value="select * from Student where registerno=?1 and password=?2",nativeQuery = true)
	List<Student> findByIdPassword(String registerno,String password);
	@Query(value="select * from Student where registerno=?1",nativeQuery = true)
	List<Student> findByRegno(String registerno);
}
