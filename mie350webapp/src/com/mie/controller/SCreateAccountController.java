package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.HomeownersDao;
import com.mie.dao.HomeseekersDao;
import com.mie.model.Homeseekers;
import com.mie.model.Student;

public class SCreateAccountController extends HttpServlet{

	private HomeseekersDao dao;
	
	public SCreateAccountController(){
		super();
		dao = new HomeseekersDao();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method creates an account for homeseekers
		 * 
		 */
		Homeseekers hs = new Homeseekers();

		hs.setLongURL(request.getParameter("Long"));
		
		
		//generate short
		String longURL = hs.getLongURL();
		//String shortURL = longURL.split("/");
		
		//hs.setshort...
		
		dao.addHomeseeker(hs);
		
		HttpSession session = request.getSession(true);

		session.setAttribute("Long", hs.getLongURL());

		//session.set short
		
		response.sendRedirect("Preferences.jsp");
		

	}
	
	
}
