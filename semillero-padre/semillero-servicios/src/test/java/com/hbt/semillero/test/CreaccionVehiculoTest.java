package com.hbt.semillero.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.Automovil;

/**
 * 
 * <b>Descripción:<b> Clase que determina Creacion de Vehiculos formato test 
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version
 */

public class CreaccionVehiculoTest {
/*
 * WHENGIVENTHEN
 */ 
	@Test
	public void whenCreateCarGivenSuccessThenOk(){
		Automovil mazda = new Automovil();
		mazda.setPrecio(new BigDecimal(150));
		mazda.setColor("blanco");
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		mazda.setCapacidad(40);
		
		assertNotNull(mazda);
		assertEquals(TipoVehiculoEnum.TERRESTRE, mazda.getTipo());
		assertEquals(40,mazda.getCapacidad());
		
		
	}
	@Test
	public void whenDeterminarTipoVehiculoGivenTrueThenOk() throws Exception {
		Automovil mazda=new Automovil();
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		Exception exception = assertThrows(Exception.class, () ->{
			
			mazda.determinarTipoVehiculo(mazda.getTipo());
		});
		 assertNotNull(exception);
		 assertEquals("El tipo de Auto es Erroneo, debe ser " +TipoVehiculoEnum.TERRESTRE.getTipo(), exception.getMessage());
		
	}
}
