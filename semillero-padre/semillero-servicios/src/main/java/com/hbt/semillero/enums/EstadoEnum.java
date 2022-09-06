package com.hbt.semillero.enums;
/**
 * 
 * <b>Descripción:<b> Enum que determina el estado de los comic
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version
 */
public enum EstadoEnum {
	ACTIVO("enum.tematica.activo"), 
	INACTIVO("enum.tematica.inactivo");
	
	/**
	 * Atributo etiquetas que ayudara a nombrar los valores de arriba
	 */
	/**
	 * Constructor que recibe como parametro el codigo el valor de la etiqueta
	 */
	private String etiqueta;
	EstadoEnum(String etiqueta){
		this.etiqueta=etiqueta;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo etiquetas
	 * @return El etiquetas asociado a la clase
	 */
	public String getEtiqueta() {
		return etiqueta;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo etiquetas
	 * @param etiquetas El nuevo etiquetas a modificar.
	 */
	public void setEtiquetas(String etiqueta) {
		this.etiqueta = etiqueta;
	}}
