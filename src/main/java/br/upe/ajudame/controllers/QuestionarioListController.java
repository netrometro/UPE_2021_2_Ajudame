package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.repositories.QuestionarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario/list")
public class QuestionarioListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public QuestionarioListController() {
		super();
	}
	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
						System.out.println("GET:: Questionario List");
						
						try {
							QuestionarioDAO dao = new QuestionarioDAO();
							
							ArrayList<Questionario> lista = (ArrayList<Questionario>) dao.list();
							
							request.setAttribute("questionarios", lista);
							System.out.println(lista.get(0).getTema());
							RequestDispatcher despachar = request.getRequestDispatcher("/Questionarios.jsp");
							despachar.forward(request, response);
							
						} catch (ClassNotFoundException | SQLException e) {
							 e.printStackTrace();
						}
					}
}
