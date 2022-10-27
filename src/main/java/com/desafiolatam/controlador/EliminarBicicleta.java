package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.BicicletaDao;
import com.desafiolatam.dao.BicicletaDaoimpl;


@WebServlet("/EliminarBicicleta")
public class EliminarBicicleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BicicletaDao bicicletaDao = new BicicletaDaoimpl();
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id <=0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			
		}
		
		request.setAttribute("id", id);
		request.getRequestDispatcher("EliminarBicicleta.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id <=0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			
		}
		
		bicicletaDao.eliminarBicicleta(id);
		
		request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
	}

}
