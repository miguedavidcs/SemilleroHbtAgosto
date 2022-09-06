
package com.hbt.semillero.enums;

/**
 * @author Usuario
 *
 */
public enum TipoVehiculoEnum {
	
	TERRESTRE("Terrestre",1),
	ACUATICO("Acuatico",2),
	AEREO("Aereo",3),
	ESPACIAL("Espacial",4);
	
	
	private String tipo;
	private int identificador;
	TipoVehiculoEnum(String tipo, int identificador){
		this.tipo=tipo;
		this.identificador=identificador;
	
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}
}
