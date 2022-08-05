package com.revature.models;

//This Class models the employees table in our database
public class Employee {

	
	private int employee_id;
	private String first_name;
	private String last_name;
	
	private Role role;
	

	private int role_id_fk;

	
	
	
	public int getRole_id_fk() {
		return role_id_fk;
	}

	public void setRole_id_fk(int role_id_fk) {
		this.role_id_fk = role_id_fk;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int employee_id, String first_name, String last_name, Role role) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
	}

	
	public Employee(String first_name, String last_name, Role role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
	}

	
	public Employee(String first_name, String last_name, int role_id_fk) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.role_id_fk = role_id_fk;
	}
	
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", role=" + role + "]";
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
