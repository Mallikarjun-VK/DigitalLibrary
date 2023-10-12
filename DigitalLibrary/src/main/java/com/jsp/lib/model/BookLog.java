package com.jsp.lib.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class BookLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;

	private String dateTime;
	private String type;
	@OneToOne
	private Student s;
	@OneToOne
	private Faculty f;
	@OneToOne
	private Book b;
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public Student getS() {
		return s;
	}
	public void setS(Student s) {
		this.s = s;
	}
	public Faculty getF() {
		return f;
	}
	public void setF(Faculty f) {
		this.f = f;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BookLog [transactionId=" + transactionId + ", dateTime=" + dateTime + ", type=" + type + ", s=" + s
				+ ", f=" + f + ", b=" + b + "]";
	}
	
}
