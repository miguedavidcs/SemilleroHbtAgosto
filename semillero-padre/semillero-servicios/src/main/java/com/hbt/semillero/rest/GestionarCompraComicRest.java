/**
 * 
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.CantidadDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

/**
 * @author Usuario Miguel Castaño
 *
 */
@Path("/gestionarCompra")
public class GestionarCompraComicRest {
	@EJB
	private IGestionarCompraComic gestionarCompraComic;
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO comprarComic(CantidadDTO CantidadDTO) {
		ResultadoDTO resultCompra = new ResultadoDTO();
		try {
			resultCompra = this.gestionarCompraComic.comprarComic(CantidadDTO);
		}catch (Exception e) {
			resultCompra.setExitoso(false);
			resultCompra.setMensajeEjecucion(e.getMessage());
		}
		return resultCompra;
	} 
}
