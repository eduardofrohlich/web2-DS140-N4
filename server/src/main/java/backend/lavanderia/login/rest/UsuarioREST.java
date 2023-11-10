package backend.lavanderia.login.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.login.model.Login;
import backend.lavanderia.usuario.entity.Cliente;

@CrossOrigin
@RestController
public class UsuarioREST {
	public static List<Cliente> lista = new ArrayList<>();

	@PostMapping("/login")
	Cliente login(@RequestBody Login login) {
		Cliente Cliente = lista.stream().filter(
				client -> client.getEmail().equals(login.getEmail()) && client.getSenha().equals(login.getSenha()))
				.findAny().orElse(null);
		return Cliente;
	}

	@GetMapping("/login")
	List<Cliente> listarTodos() {
		return lista;
	}

	static {
		lista.add(new Cliente(null, "Endereco XV", "1234", "joao@gmail.com", "João", "11111111111", "4136210493"));
		lista.add(new Cliente(null, "Endereco XX", "1235", "jose@gmail.com", "José", "11111111112", "4136210494"));
		lista.add(new Cliente(null, "Endereco XY", "1236", "joana@gmail.com", "Joana", "11111111113", "4136210495"));
		lista.add(new Cliente(null, "Endereco XY", "1236", "joana@gmail.com", "Joana", "11111111113", "4136210495"));
	}
}
