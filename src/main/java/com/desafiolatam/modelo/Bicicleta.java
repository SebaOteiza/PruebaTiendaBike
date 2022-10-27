package com.desafiolatam.modelo;

public class Bicicleta {
	
	private int id;
	private String modelo;
	private String color;
	private int aro;
	private int precio;
	private int idMarca;
	
	public Bicicleta() {
		super();
	}

	public Bicicleta(int id, String modelo, String color, int aro, int precio, int idMarca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.color = color;
		this.aro = aro;
		this.precio = precio;
		this.idMarca = idMarca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAro() {
		return aro;
	}

	public void setAro(int aro) {
		this.aro = aro;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	
	
}
