package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

//DAO stands for Data Access Object - it's the layer of classes that DIRECTLY talk to the database
//so this is where any SELECT, INSERT, UPDATE, DELETE commands will go.
public class EmployeeDAO {
		
	
	//There is a TDD test written for this method (not necessary to do this, just wanted to demonstrate TDD0
	//This method gets all employees from the DB
	public ArrayList<Employee> getEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//A String that will represent our SQL statement
			String sql = "select * from users_info;";
			
			//no variables so we don't need a PreparedStatement!
			//What we'll use instead is a Statement object to execute our query
			Statement s = conn.createStatement(); 
			//IMPORT STATEMENT FROM JAVA.SQL, NOT JAVA.BEANS!!!!!!!!!!!!!!!!!!!!!
			
			//remember we need to execute our query into a ResultSet object, which will hold the incoming data
			ResultSet rs = s.executeQuery(sql);
			
			//Instantiate an empty ArrayList to hold our Employee data (remember, java can't read SQL).
			ArrayList<Employee> employeeList = new ArrayList<>();
			
			//use rs.next() in a while loop to create Employee object and populate our ArrayList with them.
			while(rs.next()) { //rememeber, rs.next() returns "true" if there are more results that we haven't looked at yet
				
				//Create a new Employee object from each record in the ResultSet
				//we're using the all-args constructor!!
				Employee e = new Employee(
							rs.getInt("user_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							null //there is no JDBC method for getRole()... we'll add the Role object below 
							//this is an extra step we have to take, because in the DB, role_id_fk is an int
							//but we need a Role object here... not an int
						);
						
				//we need to get a Role object somehow
				//we need to use the RoleDAO method to get a role by ID.
				int roleFK = rs.getInt("role_id_fk");
				
				//Instantiate a RoleDAO so we can use getRoleById
				RoleDAO rDAO = new RoleDAO();
				
				//get a Role object using the int that we populate with rs.getInt()!!!!
				Role r = rDAO.getRoleById(roleFK);
				
				//use the SETTER of our Employee class to set the Role object to the one we got from the DB
				e.setRole(r);
				//thanks to this setter, we have a FULLY INITIALIZED Employee object
				
				//add the new Employee to our ArrayList. For every employee returned, we put it in the ArrayList
				employeeList.add(e); 
				
			} //end of while loop
			
			//once the while loop breaks (once rs.next() == false), return the ArrayList
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Could not get employee information."); //tell the console it failed
			e.printStackTrace(); //print the error log for debugging
		}
		
		return null; //so the compiler doesn't complain when our REAL return is in a try block
		
	} //end of get all 
	
	
}
