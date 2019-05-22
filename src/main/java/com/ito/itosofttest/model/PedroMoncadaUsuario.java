package com.ito.itosofttest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "PEDROMONCADA_USUARIO")
@Data
@Builder
public class PedroMoncadaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ACTIVO")
	private Long activo;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "CLAVE")
	private String clave;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "ELIMINADO")
	private Long eliminado;

	@Column(name = "IDENTIFICACION")
	private String identificacion;

	@Column(name = "INTENTOS_EXITOSOS")
	private Long intentosExitosos;

	@Column(name = "INTENTOS_FALLIDOS")
	private Long intentosFallidos;

	@Column(name = "NOMBRES")
	private String nombres;

	@Column(name = "ORIGEN_ID")
	private Long origenId;

	@Column(name = "USUARIO")
	private String usuario;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PEDROMONCADA_ROL_USUARIO", joinColumns = {
			@JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROL_ID", referencedColumnName = "ID") })
	private List<PedroMoncadaRol> roles;

	public PedroMoncadaUsuario() {

	}

	/**
	 * @param usuario
	 */
	public PedroMoncadaUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param id
	 * @param activo
	 * @param apellidos
	 * @param clave
	 * @param correo
	 * @param eliminado
	 * @param identificacion
	 * @param intentosExitosos
	 * @param intentosFallidos
	 * @param nombres
	 * @param origenId
	 * @param usuario
	 * @param roles
	 */
	public PedroMoncadaUsuario(Integer id, Long activo, String apellidos, String clave, String correo, Long eliminado,
			String identificacion, Long intentosExitosos, Long intentosFallidos, String nombres, Long origenId,
			String usuario, List<PedroMoncadaRol> roles) {
		this.id = id;
		this.activo = activo;
		this.apellidos = apellidos;
		this.clave = clave;
		this.correo = correo;
		this.eliminado = eliminado;
		this.identificacion = identificacion;
		this.intentosExitosos = intentosExitosos;
		this.intentosFallidos = intentosFallidos;
		this.nombres = nombres;
		this.origenId = origenId;
		this.usuario = usuario;
		this.roles = roles;
	}

	/**
	 * @param id
	 */
	public PedroMoncadaUsuario(Integer id) {
		this.id = id;
	}

}
