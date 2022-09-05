package com.dhruba.student.valueObject;

public class College {

	private long c_id;
	private String c_name;
	private int totalStudents;
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int noOfStud) {
		this.totalStudents = noOfStud;
	}
	public College(long c_id, String c_name, int noOfStud) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.totalStudents = noOfStud;
	}
	public College() {
		super();

	}
	@Override
	public String toString() {
		return "College [c_id=" + c_id + ", c_name=" + c_name + ", noOfStud=" + totalStudents + "]";
	}
	
	

	
	}

