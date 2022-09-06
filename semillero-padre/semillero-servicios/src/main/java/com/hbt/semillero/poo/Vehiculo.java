package com.hbt.semillero.poo;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;
/**
 * 
 * <b>Descripción:<b> Clase que determina la clase padre vehiculo
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version
 */
public class Vehiculo {
	/*
	 * Atributo que determina el modelo del vehiculo
	 */
	private short modelo;
	/*
	 * Atributo que determina tipo del vehiculo(enum)
	 */
	private TipoVehiculoEnum tipo;
	private double peso;
	private String color;
	private int capacidad;
	private BigDecimal precio;
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Vehiculo() {
		
	}
	/**
	 * 
	 * Constructor de la clase.
	 * @param precio
	 */
	public Vehiculo(BigDecimal precio) {
		this.precio=precio;
		
	}
	/**
	 * 
	 * Constructor de la clase.
	 * @param modelo
	 * @param tipo
	 * @param peso
	 * @param color
	 * @param capacidad
	 * @param precio
	 */
	public Vehiculo(short modelo,TipoVehiculoEnum tipo,double peso,String color,int capacidad,BigDecimal precio) {
		this.modelo=modelo;
		this.tipo=tipo;
		this.peso=peso;
		this.color=color;
		this.capacidad=capacidad;
		this.precio=precio;
	}
	
	
	public int getModelo() {
		return modelo;
	}
	public void setModelo(short modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * @return the tipo
	 */
	public TipoVehiculoEnum getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", tipo=" + tipo + ", peso=" + peso + ", color=" + color + ", capacidad="
				+ capacidad + ", precio=" + precio + "]";
	}
	public void encendidoMotor() {
		System.out.println("El vehiculo esta avanzando ");
	}
	

}
