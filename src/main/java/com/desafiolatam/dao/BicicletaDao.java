package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Bicicleta;

public interface BicicletaDao {
	
	public Bicicleta buscarBicicleta(int id);
	public List<Bicicleta> listarBicicletas();
	public boolean aagregarBicicleta(Bicicleta bicicleta);
	public boolean modificarBicicleta(Bicicleta bicicleta);
	public boolean eliminarBicicleta(int id);
	public int obtenerUltimoId();
	
	

}
