package com.eschool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eschool.beans.User;
import com.eschool.data.DBHandler;


@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email= request.getParameter("email");
	      String password= request.getParameter("password");
	      String name= request.getParameter("name");
	      User user= new  User(email, password, name);
	      DBHandler db= new DBHandler();
	      db.update(user);
	      if(db.getMessage().length()==0) {	  

	    	  response.sendRedirect("welcome.jsp");
	    	  
	      }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
