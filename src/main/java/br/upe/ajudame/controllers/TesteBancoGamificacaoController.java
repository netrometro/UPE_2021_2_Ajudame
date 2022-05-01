package br.upe.ajudame.controllers;


	import java.io.IOException;

import br.upe.ajudame.model.entities.Gamificacao;
import br.upe.ajudame.model.entities.User;
	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/register")
	public class TesteBancoGamificacaoController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	     
	    public TesteBancoGamificacaoController() {
	        super();
	    }
	    
		protected void doPost(
				HttpServletRequest request, 
				HttpServletResponse response) 
						throws ServletException, IOException {
			
			
			System.out.println(request.getParameter("acao"));
			System.out.println(request.getParameter("pontos"));
			System.out.println(request.getParameter("nome"));
		
			Gamificacao game = new Gamificacao();
			game.setAcao(request.getParameter("acao"));
			game.setPontos(request.getParameter("pontos"));
			game.setNome(request.getParameter("nome"));
			
			request.setAttribute("game", game);
			
			RequestDispatcher despachar = request.getRequestDispatcher("/gamificacao.jsp");
			despachar.forward(request, response);
		}
	}
