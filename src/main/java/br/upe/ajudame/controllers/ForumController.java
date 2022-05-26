package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.Forum;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forum")
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForumController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Criando uma pergunta!");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String topico = req.getParameter("topico");
		String tema = req.getParameter("tema");
		String pergunta = req.getParameter("pergunta");
		
		Forum forum = new Forum();
		
		forum.setTopico(topico);
		forum.setTema(tema);
		forum.setPergunta(pergunta);
		
		req.setAttribute("pergunta", forum);
		
		RequestDispatcher despachar = req.getRequestDispatcher("/Forum.jsp");
		despachar.forward(req, resp);
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
