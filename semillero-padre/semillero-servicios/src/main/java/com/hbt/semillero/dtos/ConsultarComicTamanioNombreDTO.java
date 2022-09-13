/**
 * ConsultarComicTamanioNombreDTO.java
 */
package com.hbt.semillero.dtos;

import java.util.*;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Usuario Miguel Castaño
 * @version
 */
public class ConsultarComicTamanioNombreDTO extends ResultadoDTO {

	/**
	 * Atributo que determina la serializacion
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo tipo Lista que su accion es Alistar los Comic que no Superan el
	 * Tamaño
	 * 
	 * 
	 */
	private List<String> listaComicsNoSuperanTamanio;
	/**
	 * Atributo tipo Lista que su accion es Alistar los Comic que Si Superan el
	 * Tamaño
	 * 
	 * 
	 */
	private List<String> listaComicsSuperanTamanio;

	/**
	 * Constructor de la clase.
	 */
	public ConsultarComicTamanioNombreDTO() {
		this.listaComicsNoSuperanTamanio = new ArrayList<String>();
		this.listaComicsSuperanTamanio = new ArrayList<String>();
	}

	/**
	 * Metodo encargado de retornar el valor del atributo
	 * listaComicsNoSuperanTamanio
	 * 
	 * @return El listaComicsNoSuperanTamanio asociado a la clase
	 */
	public List<String> getListaComicsNoSuperanTamanio() {
		return listaComicsNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo
	 * listaComicsNoSuperanTamanio
	 * 
	 * @param listaComicsNoSuperanTamanio El nuevo listaComicsNoSuperanTamanio a
	 *                                    modificar.
	 */
	public void setListaComicsNoSuperanTamanio(List<String> listaComicsNoSuperanTamanio) {
		this.listaComicsNoSuperanTamanio = listaComicsNoSuperanTamanio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComicsSuperanTamanio
	 * 
	 * @return El listaComicsSuperanTamanio asociado a la clase
	 */
	public List<String> getListaComicsSuperanTamanio() {
		return listaComicsSuperanTamanio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComicsSuperanTamanio
	 * 
	 * @param listaComicsSuperanTamanio El nuevo listaComicsSuperanTamanio a
	 *                                  modificar.
	 */
	public void setListaComicsSuperanTamanio(List<String> listaComicsSuperanTamanio) {
		this.listaComicsSuperanTamanio = listaComicsSuperanTamanio;
	}

}
