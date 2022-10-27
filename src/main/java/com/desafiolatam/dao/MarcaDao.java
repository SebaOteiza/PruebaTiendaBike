package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Marca;

public interface MarcaDao {
	
	public Marca buscarMarca(int id);
	public List<Marca> listarMarcas();
	
	

}
