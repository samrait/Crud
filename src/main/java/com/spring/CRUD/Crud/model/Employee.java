package com.spring.CRUD.Crud.model;


public class Employee {

	private String name;
	private int salary;
	private String sname;
	public Employee() {
		super();
	}
	
	public Employee(String name, int salary, String sname) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.salary = salary;
		this.sname = sname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", sname=" + sname + "]";
	}
	
	
	
}
