package com.hbt.semillero.enums;
/**
 * 
 * <b>Descripción:<b> Tipo Enum que determina   tipos de tematica de los comic
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version
 */
public enum TematicaEnum {
	AVENTURAS("enum.tematica.aventuras"), 
	BELICO("enum.tematica.belico"),
	DEPORTIVO("enum.tematica.deportivo"), 
	FANTASTICO("enum.tematica.fantastico"),  
	CIENCIA_FICCION("enum.tematica.cienciaficcion"),  
	HISTORICO("enum.tematica.historico"),  
	HORROR("enum.tematica.horror");
	/**
	 * Atributo etiquetas que ayudara a nombrar los valores de arriba
	 */
	/**
	 * Constructor que recibe como parametro el codigo el valor de la etiqueta
	 */
	private String etiquetas;
	TematicaEnum(String codigos){
		this.etiquetas=codigos;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo etiquetas
	 * @return El etiquetas asociado a la clase
	 */
	public String getEtiquetas() {
		return etiquetas;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo etiquetas
	 * @param etiquetas El nuevo etiquetas a modificar.
	 */
	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}
	
}
