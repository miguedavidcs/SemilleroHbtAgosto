package com.hbt.semillero.bean;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.Stateless;
//import org.apache.log4j.Logger;
import javax.ejb.TransactionAttribute;
import javax.persistence.Query;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.DatosActualizarCantidadDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ConsultarComicEstadoDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

/**
 * Descripción: Clase que gestiona los servicios relacionados a un comic con un
 * EJB de tipo Session sin estado (STALELESS) la transacción la va a manejar el
 * contenedor es decir no va a ser manual
 * 
 * Caso de Uso: SEMILLERO HBT 2022
 * 
 * @author Miguel Castaño
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {
	
	/**
	 * PersistenceContext el EntityManager este será capaz de controlar todos los
	 * cambios que se han realizado en él y ejecutar las consultas adecuadas contra
	 * la base de datos.
	 * --------------------------------------------------------------------------------------
	 * Instancia de la clase EntityManager, que permite administrar objetos de
	 * datos, de una fuente de datos específica.
	 */
	@PersistenceContext
	public EntityManager em;

	/**
	 * @author Miguel Castaño
	 * @Caso_de_Uso: Hacer un CRUD
	 * @param idComic  identicadoir de comic
	 * @param comicDTO Utilizamos el DTO Para la Transferencia de Datos
	 * @param Buscador
	 * @throws Exception
	 * @return CRUD con JPQL
	 */

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		// Primero Validamos la existencia del Atributo Nombre COmicDTO
		if (comicDTO.getNombre() == null) {
			// Retorna una excepción
			throw new Exception("El campo nombre es requerido");
		}
		
		// Variable Ingresamos la información del comic nuevo
		ComicDTO comicDTOResult = null;
		// Convertimos el objeto comicDTO a la entidad Comic Pero el metodo al final del
		// codico
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		/**
		 * Si se llama a persist() fuera de una transacción la entidad se incluirá en el
		 * contexto de persistencia, pero no se realizará ninguna acción hasta que la
		 * transacción comience y el contexto de persistencia se sincronice con la base
		 * de datos.
		 */
		// Insertamos el comic a la BD
		em.persist(comic);
		// Convertimos la entidad Comic a objeto comicDTO Pero el metodo al final del
		// codico
		comicDTOResult = this.convertirComicToComicDTO(comic);
		// Se modifica la variebale exitoso a true
		comicDTOResult.setExitoso(true);
		// Se modifica el mensaje de ejecución
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado ");
		// retorna el objeto DTO con la información del comic que se creo
		return comicDTOResult;
		
	}
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ComicDTO actualizarComic(ComicDTO comicDTO) {
		
		// Creamos un constructor apartir de ComiDTO para actualizar informacion
		ComicDTO comicDTOResult = new ComicDTO();
		// Convertimos el objeto comicDTO a la entidad Comic Pero el metodo al final del
		// codigo
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		/**
		 * El método merge() permite volver a incorporar en el contexto de persistencia
		 * del entity manager una entidad que había sido desconectada.
		 */
		em.merge(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		// Se modifica la variebale exitoso a true
		comicDTOResult.setExitoso(true);
		// Se modifica el mensaje de ejecución
		comicDTOResult.setMensajeEjecucion("El comic ha sido modificado");
		// retorna el objeto DTO con la información del comic que se creo
		return comicDTOResult;

	}
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(Long idComic) {
		/**
		 * La llamada a find puede devolver dos posibles excepciones de tiempo de ejecución, 
		 * ambas de la clase PersistenceException: IllegalStateException si el entitiy 
		 * manager ha sido previamente cerrado o IllegalArgumentException si el primer 
		 * argumento no contiene una clase entidad o el segundo no es el tipo correcto de 
		 * la clave primaria de la entidad.
		 */
		Comic comic = em.find(Comic.class, idComic);
		// Convertimos el objeto comicDTO a la entidad Comic Pero el metodo al final del
		// codigo
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		//Mensaje Exito
		comicDTO.setExitoso(true);
		//Mensaje si se relizo la Consulta DB
		comicDTO.setMensajeEjecucion("Consulta exitosa de comics");
		return comicDTO;
	}


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO eliminarComic(Long idComic) {
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		/**
		 * La llamada a find puede devolver dos posibles excepciones de tiempo de ejecución, 
		 * ambas de la clase PersistenceException: IllegalStateException si el entitiy 
		 * manager ha sido previamente cerrado o IllegalArgumentException si el primer 
		 * argumento no contiene una clase entidad o el segundo no es el tipo correcto de 
		 * la clave primaria de la entidad.
		 */
		
		Comic comic = em.find(Comic.class, idComic);
		/**
		 * En su forma más simple, el borrado de una entidad se realiza pasando la entidad 
		 * como parámetro del método remove() del entity manager que la gestiona. En el 
		 * momento en que el contexto de persistencia se sincroniza con una transacción y 
		 * se realiza un commit, la entidad se borra. Hay que tener cuidado, sin embargo, 
		 * con las relaciones en las que participa la entidad para no comprometer la 
		 * integridad de la base de datos.
		 */
		em.remove(comic);
		//Mensaje Exito
		resultadoDTO.setExitoso(true);
		//Mensaje si se relizo la Consulta DB
		resultadoDTO.setMensajeEjecucion("Comic eliminado ");
		
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de de realizar la consulta a la BD saber si en la los
	 * nombres de los comics superan o no una longitud
	 * 
	 * @param lengthComic
	 * @return EvaluacionComicDTO
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) {
		ConsultarComicTamanioNombreDTO consultarComicTamanioNombreDTOResult = new ConsultarComicTamanioNombreDTO();
		try {
			String consultarComics = " SELECT cm.nombre FROM Comic cm ";
			Query queryConsultarComics = em.createQuery(consultarComics);
			List<String> listaComics = queryConsultarComics.getResultList();
			for (String nombreComic : listaComics) {
				if (nombreComic.length() <= lengthComic) {
					consultarComicTamanioNombreDTOResult.getListaComicsNoSuperanTamanio().add(nombreComic);
				} else {
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
	 * Método encargado de realizar la consulta a la BD para obtener el nombre y el
	 * precio de un comic Esta operación se ejecuta sin una transacción
	 * 
	 * @return ConsultaNombrePrecioComicDTO : Con la información del comic que
	 *         necesitamos
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {

		// Variable donde se almacena la consulta SQL
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
				+ " FROM Comic c WHERE c.id = :idComic";
		// Objeto de la clase consultaNombrePrecioDTO donde se va a almacenar la
		// información del comic que reorne la consulta
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();

		// Bloque que controla la excepción que pueda retornar el método createQuery()
		try {
			Query queryConsultaNombrePrecio = em.createQuery(consultaNombrePrecioComic); // variable donde se almacena
																							// la query para la consulta
			queryConsultaNombrePrecio.setParameter("idComic", idComic); // Se pasa el parametro que recibe la consulta
			// Se almacena el objeto que retorna la ejecución de la consulta en un objeto
			// DTO
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) queryConsultaNombrePrecio.getSingleResult();
			consultaNombrePrecioDTO.setExitoso(true); // Se modifica la variebale exitoso a true
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta"); // Se modifica el
																								// mensaje de ejecución
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false); // Se modifica la variebale exitoso a false
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");// Se
			}

		return consultaNombrePrecioDTO; // retorna el objeto DTO con la información del comic
	}

	/**
	 * Método encargado de realizar la consulta a la BD para saber si existe o no un
	 * comic Esta operación se ejecuta sin una transacción
	 * 
	 * @return boolean : Existe o no un comic en la BD
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO existeComicConResult(Long idComic) {
	// Variable para saber si existe el comic
		ResultadoDTO result = new ResultadoDTO();
	// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la
	// clase EntityManager
		try {
			Comic comic = em.find(Comic.class, idComic);
	// validación para saber si existe o no el comic
			if (comic != null) {
				result.setExitoso(true);
				result.setMensajeEjecucion("El comic existe");
			} else {
				result.setExitoso(false);
				result.setMensajeEjecucion("El comic no existe");
			}
		} catch (Exception e) {
			result.setExitoso(false);
			result.setMensajeEjecucion("Ha ocurrido un error tecnico");
		}
		// Retorna true o false
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicEstadoDTO consultarComicEstado() {
		ConsultarComicEstadoDTO consultarComicEstadoDTOResult = new ConsultarComicEstadoDTO();
		List<Comic> listaComics = new ArrayList<Comic>();
		try {
			String consultaComics = " SELECT cm FROM Comic cm ";
			Query queyConsultaComics = em.createQuery(consultaComics);
			listaComics = queyConsultaComics.getResultList();
			for (Comic comic : listaComics) {
				ComicDTO comicDTO = convertirComicToComicDTO(comic);
				if (comicDTO.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
					consultarComicEstadoDTOResult.getListaComicsActivos().add(comicDTO);
				} else {
					consultarComicEstadoDTOResult.getListaComicsInactivos().add(comicDTO);
				}
			}
			consultarComicEstadoDTOResult.setExitoso(true);
			consultarComicEstadoDTOResult.setMensajeEjecucion("El servicio se ejecuto correctamente");
		} catch (Exception e) {
			consultarComicEstadoDTOResult.setExitoso(false);
			consultarComicEstadoDTOResult.setMensajeEjecucion("Ha ocurrido un error tecnico");
		}
		return consultarComicEstadoDTOResult;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO actualizarCantidadComic(DatosActualizarCantidadDTO datosActualizarCantidad) {
		ResultadoDTO result = new ResultadoDTO();
		try {
			if (existeComic(datosActualizarCantidad.getIdComic())) {
				String actualizarCantidadComic = " UPDATE Comic cm SET cm.cantidad = :cantidadComic WHERE cm.id = :idComic";
				Query queryActualizarCantidad = em.createQuery(actualizarCantidadComic);
				queryActualizarCantidad.setParameter("cantidadComic", datosActualizarCantidad.getCantidadComic());
				queryActualizarCantidad.setParameter("idComic", datosActualizarCantidad.getIdComic());
				queryActualizarCantidad.executeUpdate();
				result.setExitoso(true);
				result.setMensajeEjecucion("Cantidad de comic actualizada");
			} else {
				result.setExitoso(false);
				result.setMensajeEjecucion("El comic no esxiste en la BD");
			}
		} catch (Exception e) {
			result.setExitoso(false);
			result.setMensajeEjecucion("Se ha producido un error tecnico");
		}
		return result;
	}
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private boolean existeComic(Long idComic) {
		
		boolean resultado = false;
		Comic comic = null;
		try {
			String existeComic = " SELECT cm FROM Comic cm WHERE cm.id = :idComic ";
			Query queryExiste = em.createQuery(existeComic);
			queryExiste.setParameter("idComic", idComic);
			comic = (Comic) queryExiste.getSingleResult();
			if (comic != null) {
				resultado = true;
			}else {
				resultado = false;
			}
		} catch (Exception e) {
			return false;
		}
		return resultado;
	}
	/**
	 * @author Miguel Castaño
	 * @Caso_de_Uso Metodo encargado de transformar un comic a un comicDTO
	 * @param Comic
	 * @return ComicDTO
	 */
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
	 * @author Miguel Castaño
	 * @Caso_de_Uso Metodo encargado de transformar un ComicDTO a Comic
	 * @param ComicDTO
	 * @return Comic
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}


	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> obtenerComics() {
		List<Comic> comicsDB = new ArrayList<>();
		List<ComicDTO> comics = new ArrayList<>();
		String consultaComics = "SELECT c FROM Comic c";
		try {
			Query queryConsultaComics = em.createQuery(consultaComics);
			comicsDB = queryConsultaComics.getResultList();
			if(comicsDB.isEmpty()) {
				ComicDTO dto = new ComicDTO();
				dto.setExitoso(Boolean.FALSE);
				dto.setMensajeEjecucion("No existen comics");
				comics.add(dto);
				return comics;
			}
			
			for (Comic comic : comicsDB) {
				comics.add(this.convertirComicToComicDTO(comic));
			}
			comics.get(0).setExitoso(Boolean.TRUE);
			comics.get(0).setMensajeEjecucion("Se ha ejecutado exitosamente");
		} catch (Exception e) {
			ComicDTO dto = new ComicDTO();
			dto.setExitoso(Boolean.FALSE);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico");
			comics.add(dto);
			
		}
		return comics;
	}
}