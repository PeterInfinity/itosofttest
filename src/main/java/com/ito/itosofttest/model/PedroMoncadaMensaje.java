/**
 * 
 */
package com.ito.itosofttest.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Peter
 *
 */
@Entity
@Table(name = "PEDROMONCADA_MENSAJE")
@Data
public class PedroMoncadaMensaje {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ACTIVO")
	private Long activo;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "DESTINATARIO_ID", nullable = false)
	private PedroMoncadaUsuario destinatario;

	@Column(name = "ELIMINADO")
	private Long eliminado;

	@Column(name = "FECHA_REGISTRO")
	private Date fechaRegistro;

	@Column(name = "LEIDO")
	private Long leido;

	@Column(name = "MENSAJE")
	private String mensaje;

	@Column(name = "ORIGEN")
	private String origen;
}
