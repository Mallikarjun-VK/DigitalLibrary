package com.jsp.lib.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String registerno;
	private String name;
	private String password;
	private String branch;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegisterno() {
		return registerno;
	}
	public void setRegisterno(String registerno) {
		this.registerno = registerno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", registerno=" + registerno + ", name=" + name + ", password=" + password
				+ ", branch=" + branch + "]";
	}
}
