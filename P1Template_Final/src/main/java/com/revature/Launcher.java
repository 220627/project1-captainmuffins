package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.RoleController;
import com.revature.controllers.TicketController;
import com.revature.daos.AuthDAO;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.daos.TicketsDAO;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println("========Welcome to Loot Crew ERS========");
		
		//this is a try-with-resources block. it will test whether our Connection works.
		//try-with-resources works by trying to open a certain resource (Connection in this case)
		//and catch an exception if the resource fails to open. 
		//So in this case, if we fail to open a connection, it will throw an exception
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) {
			//if the connection fails to open, catch the resulting SQLException and print the stack trace (error log)
			System.out.println("connection failed...");
			e.printStackTrace();
		} //end of the connection test
			
		
		//Typical Javalin syntax to CREATE a javalin object 
		Javalin app = Javalin.create(
				
				//the config lambda lets us specify certain configurations for our Javalin app.
				config -> {
					config.enableCorsForAllOrigins(); //this lets us process HTTP requests from any origin
				}
				
				).start(3000); //we need .start() to start our Java server on port 3000.
				//This port is important, because this is where we need to send requests to.
		
		//We need to make some endpoint handlers, which will take in requests and send them where they need to go
		//Javalin endpoint handlers are like a traffic cop to your Java server. They take HTTP traffic and direct it.
		
		//Instantiate an EmployeeController so that we can use its handlers
		EmployeeController ec = new EmployeeController();
		TicketController tc = new TicketController();
		//Instantiate a RoleController so that we can use its handler
		RoleController rc = new RoleController();
		
		//Instantiate an AuthController... you know why hopefully :)
		AuthController ac = new AuthController();
		
		//endpoint handlers below--------------------------
		
		//app.get() is the javalin method that takes in GET requests. It will return all employees from the DB.
		//this handler takes in GET requests ending in /employees, and sends them to the getEmployeesHandler
		//the request in postman would look something like: localhost:3000/employees
		app.get("/employees", ec.getEmployeesHandler);
		app.get("/tickets",  tc.getTicketsHandler);
		app.get("/tickets/filter/:user_id", tc.getUserTicketsHandler);
		app.get("/tickets/:status_id", tc.filterTicketHandler);
		//what does /employees relate to? it's something we define. we want requests ending in /employees to get all employees
		app.post("/tickets", tc.insertTicketHandler);
		//app.post() is the javalin method that takes in POST requests. It will insert employee data into the DB.
		//how come we can have two endpoints of "/employees"? that's because one is for a GET, while the other is a POST

		
		//app.put() is a javalin method that takes PUT requests. 
		//It will take in two pieces of data: the role title (in the path parameter) and the salary (in the Request body)
		//:title? This is a PATH PARAMETER. Whatever the user inserts here in the request will be used in the controller
		app.put("/tickets/:ticket_id", tc.updateTicketHandler);
	
	
		app.post("/login", ac.loginHandler);
		
	}
}
//		 __
//  (___()'`; - root root 
//  /,    /`
//  \\"--\\      
//  (___()'`;
//  /,    /`
//  \\"--\\      
//  (___()'`;
//  /,    /`
//  \\"--\\
