package com.cj.jersey.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/hello")
public class GetTweetsByUser {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response sayPlainTextHello() {

//		User u = new User();
//
//		u.setUser("Hanny");
//		u.setTweet("Tweeted");

		List<Customer> c = new ArrayList<Customer>();
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dev", "root",
					"");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				
				Customer cus = new Customer();
				
				cus.setId(rs.getInt(1) + "");
				cus.setName(rs.getString(2));
				cus.setAge(rs.getInt(3) + "");
				
//				System.out.println("Customer -> Id: " + cus.getId() + "; Name: " + cus.getName() + "; Age: " + cus.getAge());
				
				c.add(cus);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Failed to close conn. " + e);
				}	
			}
		}
		GenericEntity<List<Customer>> entity = new GenericEntity<List<Customer>>(c) {};
		return Response.status(Status.OK).entity(entity).build();
	}

}
