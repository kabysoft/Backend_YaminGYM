package com.yamin.gym.admin.controllers;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.google.gson.Gson;
    import com.yamin.gym.admin.dao.participantsDAO;
import com.yamin.gym.admin.dto.ResponseDTO;
import com.yamin.gym.admin.model.participants;
	

	@WebServlet("/participants")
	public class ParticipantsCrudController extends HttpServlet {

		private static final long serialVersionUID = 1L;

		participantsDAO ParticipantsDAO = new participantsDAO();

		/**
		 * Get All OR get One participants.
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String id = request.getParameter("id");
			List<participants> participantsList = new ArrayList<participants>();

			if (id != null) {
				participants Participant = ParticipantsDAO.getOne(Long.parseLong(id));
				participantsList.add(Participant);
			} else {
				participantsList = ParticipantsDAO.getAll();
			}
			String jsonResponse = new Gson().toJson(participantsList);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResponse);
			out.flush();
		}

		/**
		 * Create a Participant.
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			// create repones data
			ResponseDTO dto = new ResponseDTO();

			try {
				participants Participant = new participants();
				Participant.setFirst_name(request.getParameter("first_name"));
				Participant.setLast_name(request.getParameter("last_name"));
				Participant.setAdress(request.getParameter("adress"));
				Participant.setD_o_birth(request.getParameter("d_o_birth"));
				Participant.setEmail(request.getParameter("email"));
				Participant.setPhone(Long.parseLong(request.getParameter("phone")));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOnDate = format.parse(request.getParameter("addedOn"));
				Participant.setAddedOn(addedOnDate);
				
				ParticipantsDAO.save(Participant);
				dto.setMessage("Participant is created successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed create Participant data");
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
		 * Update a Participant.
		 */
		protected void doPut(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			// create repones data
			ResponseDTO dto = new ResponseDTO();

			try {
				participants Participant = new participants();
				
				Participant.setFirst_name(request.getParameter("first_name"));
				Participant.setLast_name(request.getParameter("last_name"));
				Participant.setAdress(request.getParameter("adress"));
				Participant.setD_o_birth(request.getParameter("d_o_birth"));
				Participant.setEmail(request.getParameter("email"));
				Participant.setPhone(Long.parseLong(request.getParameter("phone")));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOnDate = format.parse(request.getParameter("addedOn"));
				Participant.setAddedOn(addedOnDate);
				
				participantsDAO participantsDAO2 = new participantsDAO();
				participantsDAO2.update(Participant);
				dto.setMessage("Participant is updated successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed updated Participant data");
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
		 * Delete a Participant
		 */
		protected void doDelete(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String id = request.getParameter("id");
			// create repones data
			ResponseDTO dto = new ResponseDTO();

			try {
				ParticipantsDAO.delete(Integer.parseInt(id));
				dto.setMessage("Participant is deleted successfully!");
			} catch (Exception e) {
				dto.setMessage("Failed deletion of a participant");
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

	

