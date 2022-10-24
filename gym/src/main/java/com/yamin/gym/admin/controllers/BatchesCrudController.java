package com.yamin.gym.admin.controllers;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.List;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import com.google.gson.Gson;
	import com.yamin.gym.admin.dao.batchesDAO;

	import com.yamin.gym.admin.dto.ResponseDTO;
	import com.yamin.gym.admin.model.batches;
	
	

	@WebServlet("/Batches")
	public class BatchesCrudController extends HttpServlet {

		private static final long serialVersionUID = 1L;

		batchesDAO batchescDAO = new batchesDAO();

		/**
		 * Get All OR get One Batches.
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String id = request.getParameter("id");
			List<batches> batchesList = new ArrayList<batches>();

			if (id != null) {
				batches batchesc = batchescDAO.getOne(Long.parseLong(id));
				batchesList.add(batchesc);
			} else {
				batchesList = batchescDAO.getAll();
			}
			String jsonResponse = new Gson().toJson(batchesList);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResponse);
			out.flush();
		}

		/**
		 * Create a Batches.
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			// create repones data
			ResponseDTO dto = new ResponseDTO();

			try {
				batches batchesc = new batches();
				batchesc.setBatche_time(request.getParameter("batche_time"));
				
				
				batchescDAO.save(batchesc);
				dto.setMessage("Batche is created successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed create Batche data");
				dto.setError(e.toString());
			}
			
			String jsonResponse = new Gson().toJson(dto);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResponse);
			out.flush();
		}
		
		/**
		 * Update a Batches.
		 */
		protected void doPut(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			// create repones data
			ResponseDTO dto = new ResponseDTO();
			

			try {
				batches batchesc = new batches();
				batchesc.setBatche_time(request.getParameter("batche_time"));
				batchescDAO.update(batchesc);
				dto.setMessage("Batche is updated successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed updated Batche data");
				dto.setError(e.toString());
			}
			
			String jsonResponse = new Gson().toJson(dto);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResponse);
			out.flush();
		}
		
		/**
		 * Delete a Batches
		 */
		protected void doDelete(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String id = request.getParameter("id");
			// create repones data
			ResponseDTO dto = new ResponseDTO();

			try {
				batchescDAO.delete(Integer.parseInt(id));
				dto.setMessage("Batche is deleted successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed deletion of a Batche");
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


