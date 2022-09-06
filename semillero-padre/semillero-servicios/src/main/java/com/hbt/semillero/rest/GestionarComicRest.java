/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

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
import com.hbt.semillero.interfaces.IGestionarComicLocal;
/**
 * 
 * <b>Descripción:<b> Clase que contiene el catalogo de servicios o apis que contienen
 * la logica de gestionar un comic o el CRUD
 * <b>Caso de Uso:<b> SEMILLERO 2022
 * @author Diego Fernado Alvarez Silva
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
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>Semillero 2022
	 * @author Usuario Miguel Castaño
	 * @POST Es utilizado para solicitar la creación de un nuevo registro,
	 * es decir, algo que no existía previamente, es decir, es equivalente 
	 * a realizar un INSERT en la base de datos. Soporta el envío del 
	 * payload.
	 * @Path("/crearComic")
	 * @Produces(MediaType.APPLICATION_JSON)
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * @param comicDTO
	 * @return
	 * 
	 */
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.crearComic(comicDTO);
		}  catch (Exception e) {
			//Mensajes  que genieran de la conexion ComicDTO y su extens Resultado 
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 
	/**
	 * 
	 * Metodo encargado de Consultar Comic Tamanio del Nombre DTO
	 * <b>Caso de Uso</b> Semillero 2022
	 * @author Usuario Miguel Castaño
	 * @GET Es utilizado únicamente para consultar información al servidor, muy parecidos a realizar un SELECT 
	 * a la base de datos. No soporta el envío del payload
	 * @Path("/consultarComicTamanioNombre") Nombre de la ruta 
	 * @Consumes(MediaType.APPLICATION_JSON) 
	 * @param lengthComic Tamaño Comic
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
	
}
