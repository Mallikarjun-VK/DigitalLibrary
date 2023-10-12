package com.jsp.lib.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.jsp.lib.model.Book;
import com.jsp.lib.model.BookLog;
import com.jsp.lib.model.Faculty;
import com.jsp.lib.model.Student;
import com.jsp.lib.rep.BookLogRepo;
import com.jsp.lib.rep.BookRepo;
import com.jsp.lib.rep.FacultyRepo;
import com.jsp.lib.rep.StudentRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class LibController {
	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private FacultyRepo facultyRepo; 

	@Autowired
	private StudentRepo StudentRepo;

	@Autowired
	private BookLogRepo bookLogRepo;

	private String regNo;
	LocalDateTime time=LocalDateTime.now();

	//	----Home-----------------
	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}
	//	----Register faculty-----
	@GetMapping("/addFaculty")
	public String registerFaculty(Faculty faculty, HttpSession h) {
		facultyRepo.save(faculty);
		h.setAttribute("facultyReg", "Succussfully Registered...!!!");
		return "home.jsp";
	}
	//	----Faculty homePage---------
	@GetMapping("/facultyLogIn")
	public String facultyLogIn(String facultyid,String password,HttpSession h) {
		List<Faculty> l=facultyRepo.findByIdPassword(facultyid, password);
		regNo=facultyid;
		if(l.size()==1) {
			h.setAttribute("value2", "");
			return "facultyHome.jsp";
		}
		else {
			h.setAttribute("value2", "Record not found, First register faculty!");
			return "home.jsp";
		}
	}
	//	----Register Student--------
	@GetMapping("/addStudent")
	public String registerStudent(Student student, HttpSession h) {
		StudentRepo.save(student);
		h.setAttribute("StudentReg", "Succussfully Registered...!!!");
		return "home.jsp";
	}
	//	----Student homePage---------
	@GetMapping("/studentLogIn")
	public String studentLogIn(String registerno,String password,HttpSession h) {
		List<Student> l=StudentRepo.findByIdPassword(registerno, password);
		regNo=registerno;
		if(l.size()==1) {
			h.setAttribute("value3","");
			return "studentHome.jsp";
		}
		else {
			h.setAttribute("value3", "Record not found, First register student!");
			return "home.jsp";
		}
	}
	//	****Faculty operation****
	//	----Add books------------
	@GetMapping("/book")
	public String dis() {
		return "addBook.jsp";
	}
	@GetMapping("/addBook")
	public String addBook(Book book,HttpSession h) {
		bookRepo.save(book);
		h.setAttribute("addedBook", "added books succusfully!!");
		return "facultyHome.jsp";
	}
	//	----See log-----------
	@GetMapping("/seeLog")
	public String seeLog(HttpSession h) {
		List<BookLog> l=(List<BookLog>) bookLogRepo.findAll();
//		List<BookLog> l=bookLogRepo.allLog();
		h.setAttribute("Log", l);
		return "facultyHome.jsp";
	}
	//	----Search book for ---
	@GetMapping("/serchBook")
	public String searchBook(String bookName,HttpSession h) {
		List<Book> l=bookRepo.findByName(bookName);
		if(l.size()!=0) {
			h.setAttribute("noRecordF1","");
			h.setAttribute("listBooks", l);
			return "facultyHome.jsp";
		}
		else {
			h.setAttribute("noRecordF1", "Book is not avalable!!");
			return "facultyHome.jsp";
		}
	}
	//	----Get By id----------
	@GetMapping("/getBookById")
	public String getBook(int id,HttpSession h) {
		try {
			Optional<Book> option= bookRepo.findById(id);
			Book book=option.get();
			System.out.println(book);
			book.setNoOfBooks(book.getNoOfBooks()-1);
			bookRepo.save(book);
			//			-----------------------
			BookLog bookLog=new BookLog();
			List<Faculty> faculty=facultyRepo.findByFacId(regNo);
			bookLog.setF(faculty.get(0));
			bookLog.setDateTime(time.toString());
			bookLog.setType("Issued");
			bookLog.setB(book);
			bookLogRepo.save(bookLog);
			h.setAttribute("Issued", "Good luck!");
			h.setAttribute("noRecordF2", "");
		}
		catch(Exception e) {
			h.setAttribute("noRecordF2", "Book is not avalable!!");
			h.setAttribute("Issued", "");
		}
		return "facultyHome.jsp";
	}
	//	----Return a book-------
	@GetMapping("/returnBookById")
	public String returnBook(int id,HttpSession h) {
		try {
			Optional<Book> option= bookRepo.findById(id);
			Book book=option.get();
			System.out.println(book);
			book.setNoOfBooks(book.getNoOfBooks()+1);
			bookRepo.save(book);
			//			-----------------------
			BookLog bookLog=new BookLog();
			List<Faculty> faculty=facultyRepo.findByFacId(regNo);
			bookLog.setF(faculty.get(0));
			bookLog.setDateTime(time.toString());
			bookLog.setType("Returned");
			bookLog.setB(book);
			bookLogRepo.save(bookLog);
			h.setAttribute("return2", "Returned Succusfully!");
			h.setAttribute("noRecordF3", "");
		}
		catch (Exception e) {
			h.setAttribute("noRecordF3", "This is not our book!!");
		}
		return "facultyHome.jsp";
	}
	//	****Student operation****
	//	----Search book---------
	@GetMapping("/serchBookStudent")
	public String searchBookStudent(String bookName,HttpSession h) {
		List<Book> l=bookRepo.findByName(bookName);
		if(l.size()!=0) {
			h.setAttribute("listBookSt", l);
			h.setAttribute("return1", "");
			return "studentHome.jsp";
		}
		else {
			h.setAttribute("return1", "Book is not avalable!!");
			h.setAttribute("listBookSt","");
			return "studentHome.jsp";
		}
	}
	//	----Get By id-----------
	@GetMapping("/getBookByIdStudent")
	public String getBookStudent(int id,HttpSession h) {
		try {
			Optional<Book> option= bookRepo.findById(id);
			Book book=option.get();
			System.out.println(book);
			book.setNoOfBooks(book.getNoOfBooks()-1);
			bookRepo.save(book);
			//			---------------------
			BookLog bookLog=new BookLog();
			List<Student> student=StudentRepo.findByRegno(regNo);
			bookLog.setS(student.get(0));
			bookLog.setDateTime(time.toString());
			bookLog.setType("Issued");
			bookLog.setB(book);
			bookLogRepo.save(bookLog);
			h.setAttribute("Issued", "Good luck!!..study makes you stronger!");
			h.setAttribute("noRecordS2", "");
		}
		catch(Exception e) {
			h.setAttribute("noRecordS2", "Book is not avalable!!");
			h.setAttribute("Issued", "");
		}

		return "studentHome.jsp";
	}
	//	----Return a book-------
	@GetMapping("/returnBookByIdStudent")
	public String returnBookStudent(int id,HttpSession h) {
		try {

			Optional<Book> option= bookRepo.findById(id);
			Book book=option.get();
			System.out.println(book);
			book.setNoOfBooks(book.getNoOfBooks()+1);
			bookRepo.save(book);
			//			-----------------------------
			BookLog bookLog=new BookLog();
			List<Student> student=StudentRepo.findByRegno(regNo);
			bookLog.setS(student.get(0));
			bookLog.setDateTime(time.toString());
			bookLog.setType("Returned");
			bookLog.setB(book);
			bookLogRepo.save(bookLog);
			h.setAttribute("return1", "Returned Succusfully!");
			h.setAttribute("noRecordS3", "");
		}
		catch (Exception e) {
			h.setAttribute("noRecordS3", "This is not our book!!");
			h.setAttribute("return1", "");
		}
		return "studentHome.jsp";
	}
}
