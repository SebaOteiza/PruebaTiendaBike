package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.BicicletaDao;
import com.desafiolatam.dao.BicicletaDaoimpl;
import com.desafiolatam.dao.MarcaDao;
import com.desafiolatam.dao.MarcaDaoImpl;
import com.desafiolatam.modelo.Bicicleta;
import com.desafiolatam.modelo.Marca;


@WebServlet("/ModificarBicicleta")
public class ModificarBicicleta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BicicletaDao bicicletaDao = new BicicletaDaoimpl();
	MarcaDao marcaDao = new MarcaDaoImpl();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idBicicleta"));
		
		
		if(id <=0 || id == 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		Bicicleta bicicleta = bicicletaDao.buscarBicicleta(id);
		
		if(bicicleta.getId() ==0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		
		List<Marca> marcas = marcaDao.listarMarcas();
		request.setAttribute("marcas", marcas);
		request.setAttribute("bicicleta", bicicleta);
		
		request.getRequestDispatcher("ModificarBicicleta.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("UTF-8");
		
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		int aro = Integer.parseInt(request.getParameter("aro"));
		int precio = Integer.parseInt(request.getParameter("precio"));
		int idMarca = Integer.parseInt(request.getParameter("marca"));
		
		
		int id = Integer.parseInt(request.getParameter("id_bicicleta"));
		
		
		if(id <=0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		
		Bicicleta bicicleta = new Bicicleta ();
		
		bicicleta.setId(id);
		bicicleta.setModelo(modelo);
		bicicleta.setColor(color);
		bicicleta.setAro(aro);
		bicicleta.setPrecio(precio);
		bicicleta.setIdMarca(idMarca);
		
		
		bicicletaDao.modificarBicicleta(bicicleta);
		
		request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);

	}
	
}
