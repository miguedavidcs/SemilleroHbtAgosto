package com.hbt.semillero.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;


/**
 * 
 * <b>Descripción:<b> Clase que determina Comic Test
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version
 */
public class ComicTest {

	private final static Logger Log = Logger.getLogger(ComicTest.class);
	private ArrayList<Comic> ListaComic;

	@Before
	public void inicializar() {
		BasicConfigurator.configure(); //Inicializa la ejecución del test
		Log.info("---------------------------INICIAN PRUEBAS UNITARIAS-----------------------");
	}
	
	/**
	 * 
	 * Metodo encargado de crear comics a partir del constructor
	 * 
	 * @author Usuario Miguel Castaño 
	 *
	 */
	@Before
	public  ArrayList<ComicDTO>crearComic() {
		ArrayList<ComicDTO>ListaComic = new ArrayList<>();
   		
		ComicDTO Comic1 = new ComicDTO(1L, "NombreComic1", "xxxxx", TematicaEnum.FANTASTICO,"Editorial", 50, new BigDecimal(100), "Autores", Boolean.FALSE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic2 = new ComicDTO(2L, "NombreComic2", "xxxxx", TematicaEnum.BELICO,"Editorial", 50, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic3 = new ComicDTO(3L, "NombreComic3", "xxxxx", TematicaEnum.AVENTURAS,"Editorial",100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic4 = new ComicDTO(4L, "NombreComic4", "xxxxx", TematicaEnum.CIENCIA_FICCION,"Editorial", 402, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.INACTIVO,40L);
		ComicDTO Comic5 = new ComicDTO(5L, "NombreComic5", "xxxxx", TematicaEnum.AVENTURAS,"Editorial", 100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic6 = new ComicDTO(6L, "NombreComic6", "xxxxx", TematicaEnum.HISTORICO,"Editorial", 100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.INACTIVO,40L);
		ComicDTO Comic7 = new ComicDTO(7L, "NombreComic7", "xxxxx", TematicaEnum.BELICO,"Editorial", 100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic8 = new ComicDTO(8L, "NombreComic8", "xxxxx", TematicaEnum.AVENTURAS,"Editorial", 100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic9 = new ComicDTO(9L, "NombreComic9", "xxxxx", TematicaEnum.AVENTURAS,"Editorial", 100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);
		ComicDTO Comic10 = new ComicDTO(10L, "NombreComic10", "xxxxx", TematicaEnum.CIENCIA_FICCION,"Editorial", 100, new BigDecimal(100), "Autores", Boolean.TRUE, LocalDate.of(2000, 12, 02), EstadoEnum.ACTIVO,40L);

		ListaComic.add(Comic1);
		ListaComic.add(Comic2);
		ListaComic.add(Comic3);
		ListaComic.add(Comic4);
		ListaComic.add(Comic5);
		ListaComic.add(Comic6);
		ListaComic.add(Comic7);
		ListaComic.add(Comic8);
		ListaComic.add(Comic9);
		ListaComic.add(Comic10);
		
		return ListaComic;
	}
		
	/**
	 * 
	 * Metodo que determina los comic Activos
	 * 
	 * @author Usuario Miguel Castaño 
	 *
	 */
	
	@Test
	public void validarComicEstadoActivo() {
		Log.info("inicia ejecución del metodo validarComicEstadoActivo()");
		ArrayList<Comic> comicAactivos = new ArrayList<>();
		
        for (int i = 0; i < ListaComic.size(); i++) {  
        	if(ListaComic.get(i).getEstadoEnum() == EstadoEnum.ACTIVO) {    
        		Assert.assertEquals(ListaComic.get(i).getEstadoEnum(),EstadoEnum.ACTIVO);
        		Log.info(ListaComic.get(i).getEstadoEnum() + " - " + ListaComic.get(i).getNombre());
        		comicAactivos.add(ListaComic.get(i));
        		System.out.println(ListaComic.get(i).toString());
        	}
        }

		Log.info("Finaliza la ejecución del metodo validarComicEstadoActivo()");
	}	
	
	
	/**
	 * 
	 * Metodo que determina los comic Inactivos
	 * 
	 * @author Usuario Miguel Castaño 
	 *
	 */
	@Test
	public void EstadoInactivo() {
		Log.info("inicia ejecución del metodo validarComicEstadoInactivo()");
		ArrayList<String> inactivos = new ArrayList<>();
		
		try {
			
	        for (int i = 0; i < ListaComic.size(); i++) {  
	        	if(ListaComic.get(i).getEstadoEnum() == EstadoEnum.INACTIVO) {        		
	        		Assert.assertEquals(ListaComic.get(i).getEstadoEnum(), EstadoEnum.INACTIVO); 	
	        		Log.info(ListaComic.get(i).getEstadoEnum() + " - " + ListaComic.get(i).getNombre());
	          		inactivos.add(ListaComic.get(i).getNombre());
	        	} else if(ListaComic.get(i).getEstadoEnum() == EstadoEnum.INACTIVO) {
					Log.info("Se ha generado un error funcional Estado Inactivo");
					throw new Exception("El estado no coincide");
				}
	        }
			
		}
		catch (Exception e){
			Assert.assertEquals(e.getMessage(), "Se ha detectado que de " + ListaComic.size() + " comics se encontraron que " + (ListaComic.size() - inactivos.size()) + " se encuentran activos y " + inactivos.size() + " inactivos. Los comics inactivos son: " + inactivos);
		}
		
		Log.info("Finaliza la ejecución del metodo EstadoInactivo()");
	}	
	
	@After	
	public void finalizar() {
		BasicConfigurator.configure();
		Log.info("---------------------------FINALIZAN PRUEBAS UNITARIAS-----------------------");
	}
}