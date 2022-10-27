package com.desafiolatam.dao;

import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.modelo.Bicicleta;
import com.desafiolatam.modelo.BicicletaMarca;
import com.desafiolatam.modelo.Marca;

public class BicicletaMarcaDaoImpl implements BicicletaMarcaDao {
	
	
	private BicicletaDao bicicletaDao = new BicicletaDaoimpl();
	private MarcaDao marcaDao = new MarcaDaoImpl();
	
	
	@Override
	public List<BicicletaMarca> listarBicicletasMarca() {
		
		
		List<BicicletaMarca> lista = new ArrayList<>();
		List<Bicicleta> listaBicicletas = bicicletaDao.listarBicicletas();
		
		for(Bicicleta bicicleta: listaBicicletas) {
			Marca marca = marcaDao.buscarMarca(bicicleta.getIdMarca());
			
			BicicletaMarca bicicletaMarca = new BicicletaMarca();
			bicicletaMarca.setBicicleta(bicicleta);
			bicicletaMarca.setMarca(marca);
			
			
			lista.add(bicicletaMarca);
			
		}
		
		
		
		return lista;
		
	
	}

}
