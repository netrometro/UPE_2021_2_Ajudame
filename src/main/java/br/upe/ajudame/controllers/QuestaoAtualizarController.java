package br.upe.ajudame.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Alternativa;
import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.repositories.QuestaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario/questao/atualizar")
public class QuestaoAtualizarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QuestaoAtualizarController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Questao questao = new Questao();
		questao.setId(Integer.parseInt(request.getParameter("id")));
		questao.setPergunta(request.getParameter("pergunta"));
		questao.setExplicacao(request.getParameter("explicacao"));
		questao.setResposta(request.getParameter("resposta"));
		
		
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		
		String idValorA = request.getParameter("idAlternativaA");
		int idAlternativaA = Integer.parseInt(idValorA);
		Alternativa alternativa = new Alternativa();
		alternativa.setId(idAlternativaA);
		String alternativaA = request.getParameter("alternativaA");
		alternativa.setAlternativa(alternativaA);
		
		alternativas.add(alternativa);
		
		String idValorB = request.getParameter("idAlternativaB");
		int idAlternativaB = Integer.parseInt(idValorB);
		alternativa = new Alternativa();
		alternativa.setId(idAlternativaA);
		String alternativaB = request.getParameter("alternativaB");
		alternativa.setAlternativa(alternativaB);
		
		alternativas.add(alternativa);
		
		String idValorC = request.getParameter("idAlternativaC");
		int idAlternativaC = Integer.parseInt(idValorC);
		alternativa = new Alternativa();
		alternativa.setId(idAlternativaC);
		String alternativaC = request.getParameter("alternativaC");
		alternativa.setAlternativa(alternativaC);
		
		alternativas.add(alternativa);
		
		String idValorD = request.getParameter("idAlternativaD");
		int idAlternativaD = Integer.parseInt(idValorD);
		alternativa = new Alternativa();
		alternativa.setId(idAlternativaD);
		String alternativaD = request.getParameter("alternativaD");
		alternativa.setAlternativa(alternativaD);
		
		alternativas.add(alternativa);
		
		String idValorE = request.getParameter("idAlternativaE");
		int idAlternativaE = Integer.parseInt(idValorE);
		alternativa = new Alternativa();
		alternativa.setId(idAlternativaE);
		String alternativaE = request.getParameter("alternativaE");
		alternativa.setAlternativa(alternativaE);
		
		alternativas.add(alternativa);
		
		
		for (int i = 0; i < alternativas.size(); i++) {
			System.out.println(alternativas.get(i).getAlternativa() + " id" + alternativas.get(i).getId());
		}
		
		try {
			QuestaoDAO questaoDAO = new QuestaoDAO();
			questaoDAO.update(questao);
			
			questaoDAO.updateAlternativas(alternativas);
			
			response.sendRedirect("/upe_20212_ajudame/questionario/questoes");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
