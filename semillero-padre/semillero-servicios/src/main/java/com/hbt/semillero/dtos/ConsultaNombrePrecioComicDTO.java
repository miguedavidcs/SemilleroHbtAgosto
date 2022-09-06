/**
 * ConsultaNombrePrecioComicDTO.java
 */
package com.hbt.semillero.dtos;

import java.math.BigDecimal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version 
 */
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO{

	/**
	 * Atributo que determina la Serializacion
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que determina el nombre de un comic
	 */
	private String nombre;
	/**
	 * Atributo que determina  el precio de un comic
	 */
	private BigDecimal precio; // Atributo que determina el precio de un comic

	/**
	 * 
	 * Constructor de la clase.
	 */
	public ConsultaNombrePrecioComicDTO() {
		//Vacio
	}

	/**
	 * Constructor de la clase.
	 * @param nombre
	 * @param precio
	 */
	public ConsultaNombrePrecioComicDTO(String nombre, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
