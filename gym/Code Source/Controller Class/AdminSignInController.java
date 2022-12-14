package com.yamin.gym.admin.controllers;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yamin.gym.admin.dao.adminDAO;
import com.yamin.gym.admin.dto.ResponseDTO;
import com.yamin.gym.admin.model.Admins;


@WebServlet("/signin")
public class AdminSignInController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		// map admin object fields with request parameters
		Admins admin  = new Admins();
		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("password"));
		
		// map admin dao to call login
		adminDAO AdminDAO = new adminDAO();
		
		// create repones data
		ResponseDTO dto = new ResponseDTO();
		try {
			AdminDAO.login(admin);
		} catch (Exception e) {
			dto.setMessage("Login Failed. ");
			dto.setError(e.toString());
		}
		
		if(admin.getAdminId() >0 ) {
			dto.setData(admin);
			dto.setMessage("Login Successfull. ");
		} else {
			dto.setMessage("Login Failed. ");
			dto.setError("User does not exist");
		}
		String jsonResponse = new Gson().toJson(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}

}
