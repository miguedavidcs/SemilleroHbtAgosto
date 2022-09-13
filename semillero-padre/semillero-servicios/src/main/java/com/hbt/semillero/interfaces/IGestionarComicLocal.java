package com.hbt.semillero.interfaces;
import java.util.List;

import javax.ejb.Local;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.DatosActualizarCantidadDTO;
import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ConsultarComicEstadoDTO;


/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> Semillero 2022
 * @author Usuario Miguel Castaño 
 * @version 
 */
@Local
public interface IGestionarComicLocal {
	
	/**
	 * @author Miguel Castaño
	 * @Caso_de_Uso: Hacer un CRUD
	 * @param idComic identicador de comic
	 * @param comicDTO Utilizamos el DTO Para la Transferencia de Datos
	 * @param Buscador
	 * @throws Exception
	 * @return CRUD de ComicDTO
	 */
		/**
		 * @author Miguel Castaño
	     * @Caso_de_Uso:Metodo para Crear los Comic
		 * @param comicDTO
		 * @return
		 * @throws Exception
		 */
		public ComicDTO crearComic(ComicDTO comicDTO) throws Exception;
		/**
		 * @author Miguel Castaño
	     * @Caso_de_Uso:Metodo para Actualizar
		 * @param datosActualizarCantidad
		 * @return
		 */
		public ComicDTO actualizarComic(ComicDTO comicDTO);
		/**
		 * @author Miguel Castaño
	     * @Caso_de_Uso:Metodo para Mostrar
		 * @param Buscador
		 * @return
		 */
		public List<ComicDTO> listarComics(String Buscador);
		/**
		 * @author Miguel Castaño
	     * @Caso_de_Uso:Metodo para Consultar Lista de Comic por parametro id del comic
		 * @param idComic
		 * @return
		 */
		public ComicDTO consultarComic(Long idComic);
		/**
		 * @author Miguel Castaño
	     * @Caso_de_Uso:Metodo para Eliminar los Comic
		 * @param idComic
		 * @return
		 */
		public ResultadoDTO eliminarComic(Long idComic);
	
	
		/**
		 * @author Miguel Castaño
		 * @Caso_de_Uso Metodos de Guia para implentar la etapa de Negocio creados por el profesor y Taller
		 * @param idComic id del comic
		 * @param lengthComic tamaño del comic
		 * @return
		 */
		//Metodo para consultar el nonmbre y el precio de un comic
		public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
		//Metodo para seber que comics tienen nombres que superan o no la longitud ingresada.  
		public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre (Short lengthComic);
		//Metodo para consultar el estado de los comic
		public ConsultarComicEstadoDTO consultarComicEstado();
		//Metodo para Actualizar la Cantidad de los Comic
		public ResultadoDTO actualizarCantidadComic(DatosActualizarCantidadDTO datosActualizarCantidad);
		/**
		 * @author Miguel Castaño
		 * @Caso_de_Uso Metodo para confirmar la existencia del Comic es para permitir la ayuda en el CRUD
		 * @param idComic
		 * @return
		 */
		public ResultadoDTO existeComicConResult(Long idComic);
	
	
	
		
}