package br.upe.ajudame.controllers;

import java.io.IOException;
import java.util.List;

import br.upe.ajudame.model.entities.Alternativa;
import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.repositories.QuestaoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/questionario/questao/buscar")
public class QuestaoBuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QuestaoBuscarController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ReceberQuestao = request.getParameter("questao");
		System.out.println(ReceberQuestao);
		
		int id_questao = Integer.parseInt(ReceberQuestao);
		
		QuestaoDAO questaoDAO = new QuestaoDAO();
		
		try {
			
			Questao buscarQuestao = questaoDAO.searchByIdQuestao(id_questao);
			
			List<Alternativa> alt = questaoDAO.listAlternativas(id_questao);
			buscarQuestao.setAlternativas(alt);;
			
			for (int i = 0; i < alt.size(); i++) {
				System.out.println(alt.get(i));
			}
			
			request.setAttribute("questao", buscarQuestao);
			
			RequestDispatcher despachar = request.getRequestDispatcher("/AtualizarQuestao.jsp");
			despachar.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
