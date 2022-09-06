package com.hbt.semillero.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

//
//
//Descripción: Clase que gestiona los servicios relacionados a un comic 
//				con un EJB de tipo Session sin estado 
//				la transacción la va a manejar el contenedor es decir no va a ser manual
//Caso de Uso: SEMILLERO HBT 2022
//@author Miguel Castaño
//@version 1.0
//
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * Instancia de la clase EntityManager, que permite administrar objetos de datos, 
	 * de una fuente de datos específica.
	 */
	@PersistenceContext
	public EntityManager em;

	/**
	 * 
	 * Metodo encargado de de realizar la consulta a la BD saber si en la los nombres de los comics superan o no una longitud
	 * 
	 * @param lengthComic
	 * @return EvaluacionComicDTO 
	 * @throws Exception 
	 */
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) 
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre (Short lengthComic)
	{		
		ConsultarComicTamanioNombreDTO consultarComicTamanioNombreDTOResult =  new ConsultarComicTamanioNombreDTO();
		try {
			String consultarComics = " SELECT cm.nombre FROM Comic cm ";
			Query queryConsultarComics = em.createQuery(consultarComics);
			List<String> listaComics = queryConsultarComics.getResultList();
			
			
			for (String nombreComic : listaComics) {
				if(nombreComic.length() <= lengthComic)
				{
					consultarComicTamanioNombreDTOResult.getListaComicsNoSuperanTamanio().add(nombreComic);
				}
				else {
					consultarComicTamanioNombreDTOResult.getListaComicsSuperanTamanio().add(nombreComic);
				}
				consultarComicTamanioNombreDTOResult.setExitoso(true);
				consultarComicTamanioNombreDTOResult.setMensajeEjecucion("Comics procesados exitosamente");
			}
		} catch (Exception e) {
			consultarComicTamanioNombreDTOResult.setExitoso(false);
			consultarComicTamanioNombreDTOResult.setMensajeEjecucion("Se ha presentado un error técnico");
		}
		
		return consultarComicTamanioNombreDTOResult;
	}
	
	
	/**
	 * Método encargado de realizar la consulta a la BD para obtener el nombre y el precio de un comic
	 * Esta operación se ejecuta sin una transacción
	 * 
	 * @return ConsultaNombrePrecioComicDTO : Con la información del comic que necesitamos
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) 
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		
		// Variable donde se almacena la consulta SQL 
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
						+ " FROM Comic c WHERE c.id = :idComic";
		// Objeto de la clase consultaNombrePrecioDTO donde se va a almacenar la información del comic que reorne la consulta
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();
		
		//Bloque que controla la excepción que pueda retornar el método createQuery()
		try {
			Query queryConsultaNombrePrecio = em.createQuery(consultaNombrePrecioComic); //variable donde se almacena la query para la consulta   
			queryConsultaNombrePrecio.setParameter("idComic", idComic); // Se pasa el parametro que recibe la consulta
			// Se almacena el objeto que retorna la ejecución de la consulta en un objeto DTO
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) queryConsultaNombrePrecio.getSingleResult();  
			consultaNombrePrecioDTO.setExitoso(true); // Se modifica la variebale exitoso a true 
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	//Se modifica el mensaje de ejecución
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false); // Se modifica la variebale exitoso a false
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");//Se modifica el mensaje de ejecución
		}

		return consultaNombrePrecioDTO; //retorna el objeto DTO con la información del comic 
	}
	/**
	 * Método encargado de realizar la consulta a la BD para saber si existe o no un comic
	 * Esta operación se ejecuta sin una transacción
	 * 
	 * @return boolean : Existe o no un comic en la BD
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) 
	public ResultadoDTO existeComicConResult(Long idComic) {
		
		//Variable para saber si existe el comic
		ResultadoDTO result = new ResultadoDTO();
		
		// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
		try {
			Comic comic =  em.find(Comic.class, idComic);
			
			//validación para saber si existe o no el comic
			if(comic != null)
			{
				result.setExitoso(true);
				result.setMensajeEjecucion("El comic existe");
			}
			else {
				result.setExitoso(false);
				result.setMensajeEjecucion("El comic no existe");
			}
		} catch (Exception e) {
			result.setExitoso(false);
			result.setMensajeEjecucion("Ha ocurrido un error tecnico");
		}
		//Retorna true o false
		return result;
	}
		
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return ComicDTO 
	 */
	@SuppressWarnings("unused")
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}


	/** 
	 * @see com.hbt.semillero.interfaces.IGestionarComicLocal#crearComic(com.hbt.semillero.dtos.ComicDTO)
	 */
	@Override
	public ComicDTO crearComic(ComicDTO comicDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
}