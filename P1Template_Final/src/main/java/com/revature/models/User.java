package com.revature.models;

//Having this User Class ALMOST defeats the purpose of a LoginDTO...
//but in your projects, Users will have way more fields than just username/password
public class User {

	private int user_id;
	private String username;
	private String password;
	private Role role; 
	
	private int role_id_fk;
	

	public int getRole_id_fk() {
		return role_id_fk;
	}

	public void setRole_id_fk(int role_id_fk) {
		this.role_id_fk = role_id_fk;
	}

	
	public User(int user_id, String username, String password, Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(int user_id, String username, String password, int role_id_fk) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role_id_fk = role_id_fk;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPasssword() {
		return password;
	}


	public void setPasssword(String password) {
		this.password = password;
	}
	
	
}
