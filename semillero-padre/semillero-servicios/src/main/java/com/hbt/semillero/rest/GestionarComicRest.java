/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.DatosActualizarCantidadDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.dtos.ConsultarComicEstadoDTO;
import com.hbt.semillero.interfaces.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:<b> Clase que contiene el catalogo de servicios o apis que
 * contienen la logica de gestionar un comic o el CRUD <b>Caso de Uso:<b>
 * SEMILLERO 2022
 * 
 * @author Diego Alvarez 
 * @author Usuario Miguel Castaño
 * @version
 */
@Path("/gestionarComic")
public class GestionarComicRest {
	/**
	 * 
	 */
	@EJB
	private IGestionarComicLocal gestionarComicLocal;

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @POST Es utilizado para solicitar la creación de un nuevo registro, es decir,
	 *       algo que no existía previamente, es decir, es equivalente a realizar un
	 *       INSERT en la base de datos. Soporta el envío del
	 *       payload. @Path("/crearComic")
	 * @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON) @param
	 *                                       comicDTO
	 * @return
	 * 
	 */
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) throws IOException {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.crearComic(comicDTO);
		} catch (Exception e) {
			// Mensajes que genieran de la conexion ComicDTO y su extens Resultado
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("ERROR TECNICO: " + e.getMessage());
		}
		return comicDTOResult;
	}

	/**
	 * 
	 * <b>Caso de Uso</b>Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @POST Se utiliza para crear recursos subordinados EN ESTE CASO ACTUALIZAR UN
	 *       COMIC EN ESPEFICICO @Path("/consultarComic")
	 * @Produces(MediaType.APPLICATION_JSON) @param idComic
	 * @return
	 */
	@POST
	@Path("/actualizarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO actualizarComic(ComicDTO comicDTO) throws IOException {
		ComicDTO comicDTOResult = new ComicDTO();
		if (comicDTO.getId() != null) {
			try {
				comicDTOResult = this.gestionarComicLocal.actualizarComic(comicDTO);
			} catch (Exception e) {
				comicDTOResult.setExitoso(false);
				comicDTOResult.setMensajeEjecucion("ERROR TECNICO: " + e.getMessage());
			}
		} else {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("El campo id es requerido para editar el comic");
		}
		return comicDTOResult;
	}

	

	/**
	 * 
	 * <b>Caso de Uso</b>Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @POST Se utiliza para crear recursos subordinados EN ESTE CASO CONSULTAR UN
	 *       COMIC EN ESPEFICICO
	 * @Path("/consultarComic")
	 * @Produces(MediaType.APPLICATION_JSON) @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		ComicDTO comicDTOResult = new ComicDTO();
		if (idComic != null && idComic != 0) {
			comicDTOResult = this.gestionarComicLocal.consultarComic(idComic);
		}
		return comicDTOResult;
	}

	/**
	 * 
	 * <b>Caso de Uso</b> Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @POST Se utiliza para crear recursos subordinados COMO ESTE CASO ELIMINAR UN
	 *       COMIC ESPECIFICO
	 * @Path("/eliminarComic")
	 * @Produces(MediaType.APPLICATION_JSON) @param idComic
	 * @return
	 * 
	 */
	@POST
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(Long idComic) throws IOException {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		if (idComic == null) {
			try {
				resultadoDTO.setExitoso(true);
				resultadoDTO.setMensajeEjecucion("El campo id es requerido para modificar el comic");
			} catch (Exception e) {
				resultadoDTO.setExitoso(true);
				resultadoDTO.setMensajeEjecucion("ERROR TECNICO " + e.getMessage());
			}
		} else {
			resultadoDTO = this.gestionarComicLocal.eliminarComic(idComic);
		}
		return resultadoDTO;
	}

	/**
	 * <b>Caso de Uso</b> Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @GET OBTENER se usan solo para leer datos y no para cambiarlos EN ESTE CASO
	 *      OBTENEMOS LOS QUE SUPERAN Y NO CANTIDAD ASIGNADA POR POSTMAN
	 * @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON) @param
	 *                                       lengthComic Tamaño Comic
	 * @return
	 * 
	 */

	@GET
	@Path("/consultarComicTamanioNombre")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic) {
		return this.gestionarComicLocal.consultarComicTamanioNombre(lengthComic);
	}

	/**
	 * 
	 * <b>Caso de Uso</b> Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @GET OBTENER se usan solo para leer datos y no para cambiarlos VER LOS ESTADO
	 *      DE LOS COMIC POR POSTMAN @Path("/consultarEstadoComic")
	 * @Produces(MediaType.APPLICATION_JSON)
	 * @return
	 * 
	 */
	@GET
	@Path("/consultarEstadoComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultarComicEstadoDTO consultarComicEstado() {
		return this.gestionarComicLocal.consultarComicEstado();
	}

	/**
	 * 
	 * <b>Caso de Uso</b> Semillero 2022
	 * 
	 * @author Usuario Miguel Castaño
	 * @POST Se utiliza para crear recursos subordinados COMO ESTE CASO ACTULIZAR LA
	 * CANTIAD DE COMIC
	 * @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON) 
	 * @param
	 *     
	 * @return
	 * 
	 */
	@POST
	@Path("/actualizarCantidadComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO actualizarCantidadComic(DatosActualizarCantidadDTO datosActualizarCantidad) {
		return this.gestionarComicLocal.actualizarCantidadComic(datosActualizarCantidad);
	}
	/**
	 * Metodo encargado de <b>Caso de Uso</b>Semillero 2022
	 * 
	 * @author Diego Alvarez Modificado Miguel Castaño
	 * @GET Metodo para Obtener Todos Comic 
	 * @Path("/obtenerComics")
	 * @Produces(MediaType.APPLICATION_JSON) 
	 *  @return
	 */
	
	@GET
	@Path("/obtenerComics")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> obtenerComics() {
		return this.gestionarComicLocal.obtenerComics();
	}

}
