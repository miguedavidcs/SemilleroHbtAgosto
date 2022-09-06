package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * @author Usuario
 *
 */
public interface IAccionesVehiculo {
	public  int obtenerVelocidadMaxima();
	public  long obtenerPesoMaximoCarga();
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum )throws Exception;
	default public void acelerar() {
	//public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerara ");
	}

}
