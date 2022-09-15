/**
 * 
 */
package com.hbt.semillero.bean;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dtos.CantidadDTO;
import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

/**
 * @author Usuario
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {

	
	@PersistenceContext
	public EntityManager em;
	/**
	 * @author Miguel Castaño
	 * @Caso_de_Uso Metodo encargado de comprar Comic JPQL Consulta
	 * @param CantidadDTO
	 * @obj comic
	 * @param stock
	 * @return resultCompra
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO comprarComic(CantidadDTO CantidadDTO) throws Exception {
		Long idComic = CantidadDTO.getId();
		int cantidadComic = CantidadDTO.getCantidad();
		Comic comic = new Comic();
		ResultadoDTO resultCompra = new ResultadoDTO();
		String comicConsulta = "SELECT cm FROM Comic cm WHERE cm.id = :idComic";
		try {
			Query queryComic = em.createQuery(comicConsulta);
			queryComic.setParameter("idComic", idComic);
			comic = (Comic) queryComic.getSingleResult();

			if(comic.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
				if(comic.getCantidad() >= cantidadComic) {
					long stock = (comic.getCantidad() - cantidadComic);
					if (stock > 0) {
						comic.setCantidad(stock);;
						comic.setFechaVenta(LocalDate.now());
					}else {
						comic.setCantidad(stock);
						comic.setEstadoEnum(EstadoEnum.INACTIVO);
						comic.setFechaVenta(LocalDate.now());
					}
					resultCompra.setExitoso(true);
					resultCompra.setMensajeEjecucion("La compra fue exitosa"+comic.getNombre());
					em.merge(comic);
				}else {
					String respuesta = "La cantidad existente del comic es: " + comic.getCantidad() + ", y supera la ingresada";
					throw new Exception(respuesta);
				}
			}else {
				throw new Exception("El comic seleccionado no cuenta con stock en bodega");
			}
		}catch (Exception e) {
			resultCompra.setExitoso(false);
			resultCompra.setMensajeEjecucion("El error tecnico presentado es: "+e.getMessage());
		}
		return resultCompra;
	}
	/**
	 * @author Miguel Castaño
	 * @Caso_de_Uso Metodo encargado de transformar un comic a un comicDTO
	 * @param Comic
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
	 * @author Miguel Castaño
	 * @Caso_de_Uso Metodo encargado de transformar un ComicDTO a Comic
	 * @param ComicDTO
	 * @return Comic
	 */
	@SuppressWarnings("unused")
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


}