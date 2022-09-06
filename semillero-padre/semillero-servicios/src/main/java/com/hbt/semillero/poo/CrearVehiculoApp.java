package com.hbt.semillero.poo;

import java.math.BigDecimal;





import com.hbt.semillero.enums.TipoVehiculoEnum;

public class CrearVehiculoApp {

	public static void main(String[] args) throws Exception{
		/*Vehiculo Toyota = new Vehiculo();
		BigDecimal valorPrecio= new BigDecimal(109);
		Toyota.setPrecio(valorPrecio);
		//System.out.println("VALOR VEHICULO TOYOTA "+valorPrecio);
Buenas practicas
		System.out.println("Valor del vehiculo Toyota: "+Toyota.getPrecio());
		*/
		Vehiculo Barco = new Barco(10,"Pamela","Puerto Libertador",new BigDecimal(1000));
		Vehiculo Honda=new Vehiculo((short)2022,TipoVehiculoEnum.TERRESTRE,155.6,"Dorado",5,new BigDecimal(110));
		Vehiculo Kia= new Vehiculo((short)2022,TipoVehiculoEnum.TERRESTRE,120.9,"Verde",5,new BigDecimal(105));
		/*
		if (1==TipoVehiculoEnum.TERRESTRE.getIdentificador()) {
			
		}else {
			
		}
		
		*/
		System.out.println("comparaciones para capturar el valor del tipo de Vehiculo");
		try {
			if(Kia.getTipo().equals(TipoVehiculoEnum.TERRESTRE)) {
				System.out.println("El vehiculo es Terrestre");
			}else {
				System.out.println("El vehiculo es No Terrestre");
			}
		}catch(Exception e){
			System.out.println("Se presento un error en try/catch");
		}
		
		System.out.println("valor vehiculo es de:"+Honda.getPrecio());
		System.out.println("ESPECIFICACIONES vehiculo HONDA: "+Honda.toString());
		System.out.println("ESPECIFICACIONES vehiculo Kia: "+Kia.toString());
		System.out.println("ESPECIFICACIONES vehiculo Barco: "+Barco.toString());
		
		Vehiculo V1=new Vehiculo();
		V1.encendidoMotor();
		
		Avion avion =new Avion();
		avion.encendidoMotor();
		Vehiculo avion2 = new Avion();
		avion2.encendidoMotor();
		
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.acelerar();
		System.out.println("BICICLETA");
		System.out.println("Velocidad  Max "+bicicleta.obtenerVelocidadMaxima());
		System.out.println("Peso Max "+bicicleta.obtenerPesoMaximoCarga());
		
		System.out.println("AUTOMOVIL");
		Automovil Auto = new Automovil(new BigDecimal(9000000));
		Auto.acelerar();
		System.out.println("AUTO TIPO ");
		Auto.setTipo(TipoVehiculoEnum.ACUATICO);
		
		System.out.println("Velocidad  Max "+Auto.obtenerVelocidadMaxima());
		System.out.println("Peso Max "+Auto.obtenerPesoMaximoCarga());
		
		try {
			Auto.determinarTipoVehiculo(Auto.getTipo());
		} catch (Exception e) {
			System.out.println("SE HA PRESENTADO ESTE ERROR "+e.getMessage());
		}
		System.out.println("Lista de Vehiculos");
		
		/**
		 * List<Vehiculo>listaVehiculos =new ArrayList<Vehiculo>();
		 
		listaVehiculos.add(Auto);
		listaVehiculos.add(Kia);
		listaVehiculos.add(Barco);
		listaVehiculos.add(Honda);
		
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getPrecio());
		}
		System.out.println("Lista de Vehiculos eliminando Kia");
		listaVehiculos.remove(Kia);
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getPrecio());
		}
		System.out.println("Lista MAP -HASHMAP de Vehiculos eliminando Kia");
		Map<String,Vehiculo>mapaVehiculos= new HashMap<>();
		mapaVehiculos.put("china", Kia);
		mapaVehiculos.put("japon", Honda);
		System.out.println(mapaVehiculos.get("china"));*/
	}

}
