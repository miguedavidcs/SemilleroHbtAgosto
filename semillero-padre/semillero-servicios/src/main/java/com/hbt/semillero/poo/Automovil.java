/**
 * 
 */
package com.hbt.semillero.poo;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.interfaces.IAccionesVehiculo;

/**
 * @author Usuario
 *
 */
public class Automovil extends Vehiculo implements IAccionesVehiculo{
	public Automovil() {
		//constructor vacio
	}

	@Override
	public int obtenerVelocidadMaxima() {
		// TODO Auto-generated method stub
		return 300;
	}

	@Override
	public long obtenerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return 1000L;
	}
	public Automovil(BigDecimal precio) {
		super(precio);
		super.toString();
		
	}

	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception {
		
		if (TipoVehiculoEnum.TERRESTRE.getIdentificador()==(tipoVehiculoEnum.getIdentificador())) {
			System.out.println("El auto Movil es del tipo asignado ("+tipoVehiculoEnum.getTipo()+")");
		    return true;
		}else {
			throw new Exception("El tipo de Auto es Erroneo, debe ser " +TipoVehiculoEnum.TERRESTRE.getTipo());
			
		}
			
		
	}

}
