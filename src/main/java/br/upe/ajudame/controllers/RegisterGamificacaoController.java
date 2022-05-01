package br.upe.ajudame.controllers;


	


	import java.io.IOException;

import br.upe.ajudame.model.entities.Gamificacao;
import br.upe.ajudame.model.entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/register")
	public class RegisterGamificacaoController {
		private static final long serialVersionUID = 1L;
	     
	    public RegisterGamificacaoController() {
	        super();
	    }
	    
		protected void doPost(
				HttpServletRequest request, 
				HttpServletResponse response) 
						throws ServletException, IOException {
			
			
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("acao"));
			System.out.println(request.getParameter("pontos"));
		
			Gamificacao game = new Gamificacao();
			game.setNome(request.getParameter("nome"));
			game.setAcao(request.getParameter("acao"));
			game.setPontos(request.getParameter("pontos"));
			
			request.setAttribute("game", game);
			
			RequestDispatcher despachar = request.getRequestDispatcher("/Gamificacao.jsp");
			despachar.forward(request, response);
		}
	}
