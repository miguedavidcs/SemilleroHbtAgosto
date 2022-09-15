/**
 * 
 */
package com.hbt.semillero.dtos;



/**
 * @Caso_de_Uso: Creamos un DTO que permitira hacer la compra del Comic
 * @author Usuario Miguel Castaño
 * @version 1.0
 *
 */

public class CantidadDTO extends ResultadoDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * En cargado de agrupar la compra de Comic
	 * @param id 
	 */
	private Long id;
	/**
	 * En cantidad a compra de Comic
	 * @param id 
	 */
	private Integer cantidad;
	/**
	 * 
	 * GETT Y SETTER
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public CantidadDTO(Long id, Integer cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}
	public CantidadDTO() {
		//Entity
	}
	
	
	
	

}
