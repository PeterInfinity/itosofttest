package com.ito.itosofttest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ito.itosofttest.model.PedroMoncadaUsuario;
import com.ito.itosofttest.model.PedroMoncadaUsuario.PedroMoncadaUsuarioBuilder;
import com.ito.itosofttest.repository.PedroMoncadaUsuarioRepository;

/**
 * 
 * @author Peter
 *
 */
@RestController
@RequestMapping("/users")
public class UsuarioController {

	@Autowired
	PedroMoncadaUsuarioRepository usuarioRepository;

	/**
	 * @author Peter
	 * @return
	 */
	@GetMapping("/0")
	public String userserviceok() {
		return "user service accessed!";
	}

	/**
	 * @author Peter
	 * @return
	 */
	@GetMapping("/1/{username}")
	public ResponseEntity<PedroMoncadaUsuario> findUser(@PathVariable("username") String username) {
		Optional<PedroMoncadaUsuario> optionalUser = usuarioRepository.findByUsuario(username);
		if (optionalUser.isPresent()) {
			PedroMoncadaUsuario user = optionalUser.get();
			return new ResponseEntity<PedroMoncadaUsuario>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @author Peter
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/2")
	public ResponseEntity<PedroMoncadaUsuario> createUser(@Valid @RequestBody PedroMoncadaUsuario user) {
		PedroMoncadaUsuarioBuilder usuarioBuilder = PedroMoncadaUsuario.builder()//
				.nombres(user.getNombres())//
				.apellidos(user.getApellidos())//
				.identificacion(user.getIdentificacion())//
				.usuario(user.getUsuario())//
				.correo(user.getCorreo())//
				.clave(user.getClave())//
				.activo(1l);
		usuarioRepository.save(usuarioBuilder.build());
		return new ResponseEntity<PedroMoncadaUsuario>(user, HttpStatus.OK);
	}

	/**
	 * @author Peter
	 * @param id
	 * @param usuarioParam
	 * @return
	 */
	@PutMapping(value = "/3/{id}")
	public ResponseEntity<PedroMoncadaUsuario> updateUser(@RequestBody PedroMoncadaUsuario usuarioParam,
			@PathVariable("id") Integer id) {
		List<PedroMoncadaUsuario> listUsuario = usuarioRepository.findByIde(id);
		if (!listUsuario.isEmpty()) {
			PedroMoncadaUsuario usuario = listUsuario.get(0);
			usuario.setUsuario(usuarioParam.getUsuario());
			usuario.setCorreo(usuarioParam.getCorreo());
			return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @author Peter
	 * @param id
	 * @return
	 */
	@DeleteMapping("/4/{id}")
	public String deleteUser(@PathVariable Integer id) {
		List<PedroMoncadaUsuario> listUsuario = usuarioRepository.findByIde(id);
		if (!listUsuario.isEmpty()) {
			PedroMoncadaUsuario usuario = listUsuario.get(0);
			usuario.setEliminado(2l);
			usuarioRepository.save(usuario);
			return "User has been deleted!";
		} else {
			return "User not found";
		}
	}
}
