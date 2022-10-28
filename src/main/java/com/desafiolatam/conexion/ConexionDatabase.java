package com.desafiolatam.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDatabase {
	
	//conexion basada en Singleton, patrón de diseño que se utiliza para que exista un uso eficiente de la memoria en los dispositivos 
	private static Connection conexion = null; //esta conexion establecida aquí, será compartida por toda la aplicación
	
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USUARIO ="desafiolatam";
	private static final String PASSWORD ="desafiolatam";
	
	
	protected Connection crearConexion() {
		
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public Connection obtenerConexion() {
		
		if(conexion == null) {
			crearConexion();
		}
		return conexion;
		
	}
	

}
