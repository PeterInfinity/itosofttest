/**
 * 
 */
package com.ito.itosofttest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Peter
 *
 */
@Entity
@Table(name = "PEDROMONCADA_ROL")
@Data
public class PedroMoncadaRol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "ELIMINADO")
	private Long eliminado;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "ACTIVO")
	private Long activo;
}
