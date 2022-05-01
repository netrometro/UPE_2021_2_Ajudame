package br.upe.ajudame.controllers;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.Gamificacao;
import br.upe.ajudame.model.repositories.GamificacaoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/list")
public class GamificacaoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GamificacaoListController() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("GET:: User List");
		
		try {
			GamificacaoDAO dao = new GamificacaoDAO();
			ArrayList<Gamificacao> lista = (ArrayList<Gamificacao>) dao.list();

			
			request.setAttribute("users", lista);
			System.out.println(lista.get(0).getPontos());
			RequestDispatcher despachar = request.getRequestDispatcher("/gamificacao.jsp");
			despachar.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
