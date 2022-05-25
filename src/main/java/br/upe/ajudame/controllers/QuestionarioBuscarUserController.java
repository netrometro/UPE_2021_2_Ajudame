package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario/buscarUser")
public class QuestionarioBuscarUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionarioBuscarUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect("/upe_20212_ajudame/CadastrarQuestionario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			User user = new User();
			String idValue = request.getParameter("id");
			String email = request.getParameter("email");
			
			int id = Integer.parseInt(idValue);
			user.setId(id);
			user.setEmail(email);

			request.setAttribute("user", user);

			RequestDispatcher despachar = request.getRequestDispatcher("/CadastrarQuestionario.jsp");
			despachar.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
