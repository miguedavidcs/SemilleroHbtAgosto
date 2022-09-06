package com.hbt.semillero.poo;

import java.math.BigDecimal;

public class Barco extends Vehiculo {
 private int nVelas;
 private String nombreCapitan;
 private String puertoLLegada;
 private float calado;
 
 public Barco() {
	 
 }
 
 
public Barco(int nVelas, String nombreCapitan, String puertoLLegada,BigDecimal precio) {
	super(precio);
	this.nVelas = nVelas;
	this.nombreCapitan = nombreCapitan;
	this.puertoLLegada = puertoLLegada;
}


/**
 * @return the nVelas
 */
public int getnVelas() {
	return nVelas;
}
/**
 * @param nVelas the nVelas to set
 */
public void setnVelas(int nVelas) {
	this.nVelas = nVelas;
}
/**
 * @return the nombreCapitan
 */
public String getNombreCapitan() {
	return nombreCapitan;
}
/**
 * @param nombreCapitan the nombreCapitan to set
 */
public void setNombreCapitan(String nombreCapitan) {
	this.nombreCapitan = nombreCapitan;
}
/**
 * @return the puertoLLegada
 */
public String getPuertoLLegada() {
	return puertoLLegada;
}
/**
 * @param puertoLLegada the puertoLLegada to set
 */
public void setPuertoLLegada(String puertoLLegada) {
	this.puertoLLegada = puertoLLegada;
}
/**
 * @return the calado
 */
public float getCalado() {
	return calado;
}
/**
 * @param calado the calado to set
 */
public void setCalado(float calado) {
	this.calado = calado;
}


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Barco [nVelas=" + nVelas + ", nombreCapitan=" + nombreCapitan + ", puertoLLegada=" + puertoLLegada
			+ ", calado=" + calado + ", precio="+super.getPrecio()+"]" ;
}
 
 
}
