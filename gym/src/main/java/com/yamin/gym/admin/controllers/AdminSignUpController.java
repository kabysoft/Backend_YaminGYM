package com.yamin.gym.admin.controllers;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Date;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import com.google.gson.Gson;
	import com.yamin.gym.admin.dao.adminDAO;
	import com.yamin.gym.admin.dto.ResponseDTO;
	import com.yamin.gym.admin.model.Admins;


	@WebServlet("/SignUp")
	public class AdminSignUpController extends HttpServlet{

		private static final long serialVersionUID = 1L;
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException { 
			
			// map admin object fields with request parameters
			Admins admin  = new Admins();
			admin.setEmail(request.getParameter("email"));
			admin.setPassword(request.getParameter("password"));
			admin.setAddedOn( new Date());
			admin.setLoginType(1);
			admin.setFullName(request.getParameter("fullName"));
			// map admin dao to call login
			adminDAO AdminDAO = new adminDAO();
			
			// create repones data
			ResponseDTO dto = new ResponseDTO();
					
			try {
				AdminDAO.save(admin);
				dto.setMessage("Admin user is created successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed signup admin user ");
				dto.setError(e.toString());
			}
			
			String jsonResponse = new Gson().toJson(dto);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResponse);
			out.flush();
		}

	}


