package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.User;
import br.upe.ajudame.model.repositories.ConnectionPostgres;
import br.upe.ajudame.model.repositories.UserDAO;
import br.upe.ajudame.model.repositories.UserMigration;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/list")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserListController() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("GET:: User List");
		
		try {
			UserDAO dao = new UserDAO();
			ArrayList<User> lista = (ArrayList<User>) dao.list();

			request.setAttribute("users", lista);
			System.out.println(lista.get(0).getEmail());
			RequestDispatcher despachar = request.getRequestDispatcher("/users.jsp");
			despachar.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
