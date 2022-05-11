package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;

import br.upe.ajudame.model.repositories.ConnectionPostgres;
import br.upe.ajudame.model.repositories.QuestaoMigration;
import br.upe.ajudame.model.repositories.QuestionarioMigration;
import br.upe.ajudame.model.repositories.UserMigration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/banco")
public class TesteBancoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TesteBancoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GET:: Banco");

		/*
		 * // TESTA A CONECÇÃO COM O BANCO try { ConnectionPostgres c = new
		 * ConnectionPostgres(); c.connect(); } catch (SQLException |
		 * ClassNotFoundException e) { e.printStackTrace(); } //
		 */

		UserMigration userMigration = new UserMigration();
		/*
		 * / userMigration.migrate(); //
		 */

		// */
		userMigration.refresh();
		// */

		// */
		userMigration.populate();
		// */

		// */

		QuestionarioMigration questionarioMigration = new QuestionarioMigration();

		//*/
			questionarioMigration.migrate();
		/**/
		
		/*
		 	questionarioMigration.refresh();
		/**/
		
		/* 
		  	questionarioMigration.populate();
		/**/
		
		QuestaoMigration questaoMigration = new QuestaoMigration();

		//*
		  questaoMigration.migrate();
		/**/

		/*
		 questaoMigration.refresh();
		/**/

		//*
		 questaoMigration.migrateAlternativas();
		/**/
		 
		
	}
}
