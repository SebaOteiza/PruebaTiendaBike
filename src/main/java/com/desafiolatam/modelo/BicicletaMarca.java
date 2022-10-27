package com.desafiolatam.modelo;

public class BicicletaMarca {
	
	private Bicicleta bicicleta;
	private Marca marca;
	
	public BicicletaMarca() {
		super();
	}

	public BicicletaMarca(Bicicleta bicicleta, Marca marca) {
		super();
		this.bicicleta = bicicleta;
		this.marca = marca;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	

}
