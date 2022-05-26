package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.Forum;
import br.upe.ajudame.model.repositories.ForumDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forum/list")
public class ForumListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ForumListController() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("GET:: Forum List");
		
		try {
			ForumDAO dao = new ForumDAO();
			ArrayList<Forum> lista = (ArrayList<Forum>) dao.list();

			request.setAttribute("forum", lista);
			System.out.println(lista.get(0).getTopico());
			RequestDispatcher despachar = request.getRequestDispatcher("/forum.jsp");
			despachar.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}