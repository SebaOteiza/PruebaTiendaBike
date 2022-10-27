package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.ConexionDatabase;
import com.desafiolatam.modelo.Bicicleta;

public class BicicletaDaoimpl implements BicicletaDao {
	
	private ConexionDatabase conn = new ConexionDatabase();
	
	private Connection conexion;
	private PreparedStatement pstm;
	private ResultSet rs;
	

	@Override
	public Bicicleta buscarBicicleta(int id) {
		String sql = "SELECT * FROM bicicleta WHERE id_bicicleta = ?";
		Bicicleta bicicleta = new Bicicleta();
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			pstm.setInt(1, id); //el signo de interrogacion va a tomar el valor de la variable que pasamos por parametro
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				bicicleta.setId(rs.getInt("id_bicicleta"));
				bicicleta.setModelo(rs.getString("modelo"));
				bicicleta.setColor(rs.getString("color"));
				bicicleta.setAro(rs.getInt("aro"));
				bicicleta.setPrecio(rs.getInt("precio"));
				bicicleta.setIdMarca(rs.getInt("id_marca"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bicicleta;
	}

	@Override
	public List<Bicicleta> listarBicicletas() {
		String sql = "SELECT * FROM bicicleta";
		List<Bicicleta> listaBicicletas = new ArrayList<>()
				;
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Bicicleta bicicleta = new Bicicleta();
				
				bicicleta.setId(rs.getInt("id_bicicleta"));
				bicicleta.setModelo(rs.getString("modelo"));
				bicicleta.setColor(rs.getString("color"));
				bicicleta.setAro(rs.getInt("aro"));
				bicicleta.setPrecio(rs.getInt("precio"));
				bicicleta.setIdMarca(rs.getInt("id_marca"));
				listaBicicletas.add(bicicleta);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaBicicletas;
	}

	@Override
	public boolean aagregarBicicleta(Bicicleta bicicleta) {
		
		String sql ="INSERT INTO bicicleta (id_bicicleta, modelo, color, aro, precio, id_marca)"
				+"VALUES (?, ?, ?, ?, ?, ?)";
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			
			pstm.setInt(1, bicicleta.getId());
			pstm.setString(2, bicicleta.getModelo());
			pstm.setString(3, bicicleta.getColor());
			pstm.setInt(4, bicicleta.getAro());
			pstm.setInt(5, bicicleta.getPrecio());
			pstm.setInt(6, bicicleta.getIdMarca());
			
			int resultado = pstm.executeUpdate(); //este es diferente porque ejecuta una operacion que no retorna filas ni columnas, sino que retorna un numer oentero 
			
			
			if(resultado == 1){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean modificarBicicleta(Bicicleta bicicleta) {
		
		String sql ="UPDATE bicicleta SET modelo= ?, color=?, aro=?, precio=?, id_marca=?"
				+"WHERE id_bicicleta=?";
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			
			
			pstm.setString(1, bicicleta.getModelo());
			pstm.setString(2, bicicleta.getColor());
			pstm.setInt(3, bicicleta.getAro());
			pstm.setInt(4, bicicleta.getPrecio());
			pstm.setInt(5, bicicleta.getIdMarca());
			pstm.setInt(6, bicicleta.getId());
			
			int resultado = pstm.executeUpdate(); 
			
			
			if(resultado == 1){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

	@Override
	public boolean eliminarBicicleta(int id) {
		String sql ="DELETE FROM bicicleta WHERE id_bicicleta =?";
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			
			int resultado = pstm.executeUpdate(); 
			
			
			if(resultado == 1){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	@Override
	public int obtenerUltimoId() {
		
	
		String sql = "SELECT MAX(id_bicicleta) AS max FROM bicicleta";
		
		int maximo =0;
		
		conexion = conn.obtenerConexion();
		try {
			pstm = conexion.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				maximo = rs.getInt("max");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maximo;
	}
}
