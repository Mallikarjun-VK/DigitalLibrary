package com.jsp.lib.rep;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jsp.lib.model.Faculty;
import com.jsp.lib.model.Student;

public interface FacultyRepo extends CrudRepository<Faculty, Integer>{
	@Query(value="select * from Faculty where facultyid=?1 and password=?2",nativeQuery = true)
	List<Faculty> findByIdPassword(String facultyid,String password);
	@Query(value="select * from Faculty where facultyid=?1",nativeQuery = true)
	List<Faculty> findByFacId(String facultyid);
}
