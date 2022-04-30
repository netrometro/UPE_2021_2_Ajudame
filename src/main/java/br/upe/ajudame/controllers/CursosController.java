package br.upe.ajudame.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/curso")
public class CursosController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CursosController() {
		super();
	}
	
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
		{
			super.doGet(req, resp);
		}
	
	
	protected void doPost(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
		{
			super.doPost(req, resp);
		}
	
	protected void doPut(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
		{
			super.doPut(req, resp);
		}
	
	protected void doDelete(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
	{
		super.doDelete(req, resp);
	}
}
