package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Descripción:<b> Clase que determina la entidad comic
 * <b>Caso de Uso:<b> 
 * @author Usuario Miguel Castaño 
 * @version 
 */
@Entity
@Table(name = "COMIC")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comic implements Serializable {

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;ediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	@Column(name = "SCID")
	private Long id; // Atributo que determina el id de un comic
	@Column(name = "SCNOMBRE")
	private String nombre; // Atributo que determina el nombre de un comic
	@Column(name = "SCCOLECCION")
	private String editorial; // Atributo que determina la editorial de un comic
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING)
	private TematicaEnum tematicaEnum; // Atributo que determina la tematica de un comic
	@Column(name = "SCCOLECCION")
	private String coleccion; // Atributo que determina la coleccion de un comic
	@Column(name = "SCNUMEROPAGINAS")
	private Integer numeroPaginas; // Atributo que determina el numero de paginas de un comic
	@Column(name = "SCPRECIO")
	private BigDecimal precio; // Atributo que determina el precio de un comic
	@Column(name = "SCAUTORES")
	private String autores; // Atributo que determina el id de un comic
	@Column(name = "SCCOLOR")
	private Boolean color; // Atributo que determina los autores de un comic
	@Column(name = "SCFECHA_VENTA")
	private LocalDate fechaVenta; // Atributo que determina la fecha de venta de un comic
	@Column(name = "SCESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estadoEnum; // Atributo que determina el estado de un comic
	@Column(name = "SCCANTIDAD")
	private Long cantidad; // Atributo que determina la cantidad en stock de un comic
	
	
}
