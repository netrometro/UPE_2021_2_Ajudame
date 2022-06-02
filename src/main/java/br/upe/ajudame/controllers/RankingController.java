package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.User;
import br.upe.ajudame.model.repositories.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ranking")
public class RankingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RankingController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
	
			User user = (User) session.getAttribute("user");
			//System.out.println("> "+user.getName());
			
			UserDAO dao = new UserDAO();
			ArrayList<User> lista = (ArrayList<User>) dao.listOrderByRanking();
			ArrayList<User> listaAtualizada = new ArrayList<User>();

			int indexUser = 0;
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == user.getId()) indexUser = i;
			}
		
		
			
			for(int i=indexUser; i<indexUser-5; i--) {
				if(i >= 0 ) {
					
				}
			}
			
			request.setAttribute("users", lista);
			
			RequestDispatcher despachar = request.getRequestDispatcher("/Ranking.jsp");
			despachar.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
