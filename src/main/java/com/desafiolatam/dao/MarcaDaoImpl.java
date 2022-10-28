package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.ConexionDatabase;
import com.desafiolatam.modelo.Marca;

public class MarcaDaoImpl implements MarcaDao {
	
	private ConexionDatabase conn = new ConexionDatabase();
	
	private Connection conexion;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	

	@Override
	public Marca buscarMarca(int id) {
		
		String sql = "SELECT * FROM marca WHERE id = ?";
		Marca marca = new Marca();
		
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			pstm.setInt(1, id); //el signo de interrogacion va a tomar el valor de la variable que pasamos por parametro
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				marca.setId(rs.getInt("id"));
				marca.setNombre(rs.getString("nombre"));
				
				
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return marca;
	}

	
	
	@Override
	public List<Marca> listarMarcas() {
		
		String sql = "SELECT * FROM marca";
		List<Marca> listaMarcas = new ArrayList<>();
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			rs = pstm.executeQuery();
		
		while(rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("id"));
			marca.setNombre(rs.getString("nombre"));
			listaMarcas.add(marca);
			

		}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaMarcas;
}
}