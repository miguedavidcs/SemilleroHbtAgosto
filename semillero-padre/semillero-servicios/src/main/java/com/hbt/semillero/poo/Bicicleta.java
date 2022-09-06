package com.hbt.semillero.poo;

import com.hbt.semillero.poo.astracts.AccionesVehiculoAstract;

public class Bicicleta extends AccionesVehiculoAstract{

	@Override
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public long obtenerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return 90L;
	}

}
