package com.hbt.semillero.rest;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
				/**
				 * 
				 * <b>Descripción:<b> Clase que determina
				 * <b>Caso de Uso:<b> 
				 * @author Usuario Miguel Castaño 
				 * @version
				 */

	@Path("/SemilleroJPQLRest")
	@Produces(MediaType.APPLICATION_JSON)
	@Stateless
	@TransactionManagement(TransactionManagementType.CONTAINER)
	public class SemilleroJPQLRest{
		
		//
		//Constante que contendra el log de la clase AritmeticaTest
		//
		private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);
		
		@PersistenceContext
		private EntityManager em;


		@GET
		@Path("/test")
		@Produces(MediaType.APPLICATION_JSON)
		@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
		public String obtenerUnComic() {
			//BasicConfigurator.configure();
			Comic comic = null;
			try {
				// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la clase EntityManager
				// SELECT * FROM COMIC WHERE ID = 2;
				comic = em.find(Comic.class, 2L);
				
				//Consults en JPQL para obtener un comic con el id 24 pero quemado haciendo uso del metodo getSingleResult
				String consultaUnComic = " SELECT c FROM Comic c WHERE c.id = 4 ";
				Query queryUnComic = em.createQuery(consultaUnComic);
				comic = (Comic) queryUnComic.getSingleResult();
				
				//Consulta en JPQL para obtener un comic con el id 24 haciendo uso del metodo getSingleResult y setParameter
				String consultaUnComicConParametro = " SELECT c FROM Comic c WHERE c.id = :idComic "
						+ " AND c.estadoEnum = :estadoComic "
						+ " ORDER BY c.nombre DESC ";
				Query queryUnComicConParametro = em.createQuery(consultaUnComicConParametro);
				queryUnComicConParametro.setParameter("idComic", 4L);
				queryUnComicConParametro.setParameter("estadoComic", EstadoEnum.ACTIVO);
				comic = (Comic) queryUnComicConParametro.getSingleResult();
											
				
				// Actualizar y eliminar mediante un identificador
				String actualizarComic = " UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id = :idComic";
				Query queryActualizar = em.createQuery(actualizarComic);
				queryActualizar.setParameter("estado", EstadoEnum.ACTIVO);
				queryActualizar.setParameter("idComic", 2L);
				queryActualizar.executeUpdate();
				
				String eliminarComic = " DELETE FROM Comic WHERE id = :idComic";
				Query queryEliminar = em.createQuery(eliminarComic);
				queryEliminar.setParameter("idComic", 3L);
				queryEliminar.executeUpdate();
				
				String eliminarComics = " DELETE FROM Comic WHERE id = :idComic";
				Query queryEliminare = em.createQuery(eliminarComics);
				queryEliminar.setParameter("idComic", 3L);
				queryEliminare.executeUpdate();
				
				List<Long> idsComics = new ArrayList<>();
				idsComics.add(3L);
				idsComics.add(2L);
				idsComics.add(5L);
				idsComics.add(7L);
				String actualizarComicVarios = "UPDATE Comic c SET c.estadoEnum = :estado WHERE c.id IN (:listIdComics)";
				Query queryActualizarVarios = em.createQuery(actualizarComicVarios);
				queryActualizarVarios.setParameter("estado", EstadoEnum.ACTIVO);
				queryActualizarVarios.setParameter("listIdComics", idsComics);
				queryActualizarVarios.executeUpdate();
				
				String eliminarComicVarios = " DELETE FROM Comic WHERE id = :idComic";
				Query queryEliminarVarios = em.createQuery(eliminarComicVarios);
				queryEliminarVarios.setParameter("idComic", 7L);
				queryEliminarVarios.executeUpdate();
				
//				
			} catch (NonUniqueResultException nur) {
				log.info("EXISTE MAS DE UN REGISTRO " + nur.getMessage());			
			} catch (NoResultException nre) {
				log.info("NO SE HAN ENCONTRADO REGISTROS CON EL ID " + 9L + nre.getMessage());
			} catch (Exception e) {
				log.info("SE HA PRESENTADO UN ERROR TECNICO " + e.getMessage());
				return e.getMessage();
			}
			
			return comic.toString();
		}

		
		}
	

