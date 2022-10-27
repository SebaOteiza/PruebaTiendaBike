package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.BicicletaMarcaDao;
import com.desafiolatam.dao.BicicletaMarcaDaoImpl;
import com.desafiolatam.modelo.BicicletaMarca;


@WebServlet("/ListarBicicleta")
public class ListarBicicleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BicicletaMarcaDao bicicletaMarcaDao = new BicicletaMarcaDaoImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<BicicletaMarca> lista = bicicletaMarcaDao.listarBicicletasMarca();
		request.setAttribute("bicicletas", lista);
		request.getRequestDispatcher("ListarBicicleta.jsp").forward(request, response);
	}

}
