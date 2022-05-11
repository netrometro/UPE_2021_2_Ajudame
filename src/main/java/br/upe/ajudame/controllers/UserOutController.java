package br.upe.ajudame.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sair")
public class UserOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserOutController() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("GET:: User Out");

		HttpSession session = request.getSession(false); // Pega a sessão se existir, senão existir NÃO cria
		if (session != null) {
			session.invalidate(); // Acaba com a sessão do usuário
		}
		
		//Mensagem de erro
		response.sendRedirect("index.jsp");
	}
}
