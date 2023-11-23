package backend.lavanderia.login.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.login.model.Login;
import backend.lavanderia.usuario.cargos.CargosUsuario;
import backend.lavanderia.usuario.entity.Usuario;

@CrossOrigin
@RestController
public class UsuarioREST {
	public static List<Usuario> lista = new ArrayList<>();

	@PostMapping("/login")
	Usuario login(@RequestBody Login login) {
		Usuario usuario = lista.stream().filter(
				us -> us.getEmail().equals(login.getEmail()) && us.getSenha().equals(login.getSenha()))
				.findAny().orElse(null);
		return usuario;
	}

	@GetMapping("/login")
	List<Usuario> listarTodos() {
		return lista;
	}

	static {
		lista.add(new Usuario(null, "Endereco XV", "1234", "joao@gmail.com", "João", "11111111111", "4136210493", CargosUsuario.CLIENTE ));
		lista.add(new Usuario(null, "Endereco XX", "1235", "jose@gmail.com", "José", "11111111112", "4136210494", CargosUsuario.CLIENTE));
		lista.add(new Usuario(null, "Endereco XY", "1236", "joana@gmail.com", "Joana", "11111111113", "4136210495", CargosUsuario.CLIENTE));
		lista.add(new Usuario(null, "Endereco XY", "admin", "admin@email.com", "admin", "11111111110", "4136210493", CargosUsuario.FUNCIONARIO));
	}
}