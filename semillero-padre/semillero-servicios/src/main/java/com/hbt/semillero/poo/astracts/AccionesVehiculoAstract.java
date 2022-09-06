package com.hbt.semillero.poo.astracts;

public abstract class AccionesVehiculoAstract {
	public abstract int obtenerVelocidadMaxima();
	public abstract long obtenerPesoMaximoCarga();
	public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerara ");
	}

}
