package br.upe.ajudame.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.upe.ajudame.model.repositories.UserMigration;

@WebServlet("/banco")
public class TesteBancoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TesteBancoController() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("Get");
		/*// TESTA A CONECÇÃO COM O BANCO
		try {
			ConnectionPostgres c = new ConnectionPostgres();
			c.connect();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//*/
		

		UserMigration userMigration = new UserMigration();
		/*/
		userMigration.migrate();
		//*/

		//*/
		userMigration.refresh();
		//*/
		
		//*/
		userMigration.populate();
		//*/
	}

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("Post");
	}

}
