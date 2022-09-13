package com.hbt.semillero.dtos;

/**
 * Descripción: Clase que determina
 * Caso de Uso: SEMILLERO HBT 2022
 * @author Miguel Castaño
 */
public class DatosActualizarCantidadDTO{
	
	private Long idComic;
	private Long cantidadComic;
	/**
	 * Constructor vacio de la clase.
	 */
	public DatosActualizarCantidadDTO() {
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idComic
	 * @return El idComic asociado a la clase
	 */
	public Long getIdComic() {
		return idComic;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idComic
	 * @param idComic El nuevo idComic a modificar.
	 */
	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo cantidadComic
	 * @return El cantidadComic asociado a la clase
	 */
	public Long getCantidadComic() {
		return cantidadComic;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo cantidadComic
	 * @param cantidadComic El nuevo cantidadComic a modificar.
	 */
	public void setCantidadComic(Long cantidadComic) {
		this.cantidadComic = cantidadComic;
	}
	
}