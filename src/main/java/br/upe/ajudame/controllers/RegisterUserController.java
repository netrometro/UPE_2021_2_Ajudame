package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.Gamificacao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RegisterUserController() {
        super();
    }
    
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("pontos"));
		System.out.println(request.getParameter("acao"));
	
		Gamificacao game = new Gamificacao();
		game.setNome(request.getParameter("name"));
		game.setPontos(request.getParameter("pontos"));
		game.setAcao(request.getParameter("acao"));
		
		request.setAttribute("gamificacao", game);
		
		RequestDispatcher despachar = request.getRequestDispatcher("/gamificacao.jsp");
		despachar.forward(request, response);
	}
}
