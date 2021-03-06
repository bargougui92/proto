package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class testDBservlet
 */
@WebServlet("/testDBservlet")
public class testDBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
		String user = "root";
		String pass = "codebanka";
		String driver = "com.mysql.jdbc.Driver";

		String JDBCUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false" ;

		//get connection to database
		try {
			PrintWriter out = response.getWriter();
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(JDBCUrl, user, pass);
			out.println("Success!!");
			myConn.close();
		}catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}
