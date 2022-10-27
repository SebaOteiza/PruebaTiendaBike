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


@WebServlet("/AgregarBicicleta")
public class AgregarBicicleta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	BicicletaDao bicicletaDao = new BicicletaDaoimpl();
	MarcaDao marcaDao = new MarcaDaoImpl();
	
	
	//va a retortar la vista de agregar bicicletas.jsp que tendrá un formulario
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Marca> marcas = marcaDao.listarMarcas();
		request.setAttribute("marcas", marcas);
		request.getRequestDispatcher("AgregarBicicleta.jsp").forward(request, response);
		
		
	}

	
	//recibe esos datos, los junta en un objeto bicicleta y ese objeto lo guarda en la BD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		int aro = Integer.parseInt(request.getParameter("aro"));
		int precio = Integer.parseInt(request.getParameter("precio"));
		int idMarca = Integer.parseInt(request.getParameter("Marca"));
		
		int id = bicicletaDao.obtenerUltimoId() + 1;
		
		Bicicleta bicicleta = new Bicicleta ();
		
		bicicleta.setId(id);
		bicicleta.setModelo(modelo);
		bicicleta.setColor(color);
		bicicleta.setAro(aro);
		bicicleta.setPrecio(precio);
		bicicleta.setIdMarca(idMarca);
		
		
		bicicletaDao.aagregarBicicleta(bicicleta);
		
		request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
		
		//es necesario devolcer una vista cada vez que se termina de procesar un controlar,  porque de no hacerlo, el cliente no va a poder seguir interactuando con nuestra pagina
		
	}

}
