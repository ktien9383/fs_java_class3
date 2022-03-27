package com.crud.model;

import java.util.Date;

public class Student {
	private int rollno;
	private String studname;
	private Date DOB;
	public Student(int rollno, String studname, Date dOB) {
		super();
		this.rollno = rollno;
		this.studname = studname;
		DOB = dOB;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	

}
