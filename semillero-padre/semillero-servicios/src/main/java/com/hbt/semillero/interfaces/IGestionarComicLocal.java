package com.hbt.semillero.interfaces;
import javax.ejb.Local;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;


/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> Semillero 2022
 * @author Usuario Miguel Castaño 
 * @version 
 */
@Local
public interface IGestionarComicLocal {
	
	
	//Metodo para consultar el nonmbre y el precio de un comic
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);

	// Metdo para consultar si existe Primero un Comic con Identificador
	public ResultadoDTO existeComicConResult(Long idComic);
	

	//Metodo para seber que comics tienen nombres que superan o no la longitud ingresada.  
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre (Short lengthComic);

	//Medo encargado de Crear Comic
	public ComicDTO crearComic(ComicDTO comicDTO);
	
		
}