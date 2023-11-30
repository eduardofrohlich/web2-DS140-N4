package backend.lavanderia.usuario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.usuario.directive.ValidaUsuario;
import backend.lavanderia.usuario.dto.ClienteDTO;
import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.usuario.repository.ClienteRepository;
import backend.lavanderia.usuario.service.Criptografia;


@CrossOrigin
@RestController
public class ClienteController 
{
	@Autowired
	private ClienteRepository repoCliente;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/clientes")
	public List<ClienteDTO> obterTodosClientes()
	{
		List<Cliente> buscaLista = repoCliente.findAll();
		List<ClienteDTO> lista = new ArrayList<>();
		
		for(Cliente cliente : buscaLista)
			lista.add(mapper.map(cliente, ClienteDTO.class));
		
		return lista;
	}
	
	// Login
	@GetMapping("/clientes/{email}/{senha}")
	public ClienteDTO identificarCliente(@PathVariable("email") String email, @PathVariable("senha") String senha)
	{
		Optional<Cliente> buscaCliente = repoCliente.findByEmailAndSenha(email, Criptografia.criptografarSenha(senha));
		
		if(buscaCliente.isEmpty())
			throw new RuntimeException("Não existe cliente com esse email e senha!");
		
		return mapper.map(buscaCliente, ClienteDTO.class);
	}
	
	@PostMapping("/clientes")
	public ClienteDTO inserirCliente(@RequestBody ClienteDTO cliente)
	{
		if(!repoCliente.findByCpf(cliente.getCpf()).isEmpty())
			throw new IllegalArgumentException("O cliente já existe!");
		
		ValidaUsuario.usuario(cliente);
		Cliente clienteCriado = new Cliente(cliente.getEndereco(), cliente.getSenha(), cliente.getEmail(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone());

		cliente.setSenha(Criptografia.criptografarSenha(cliente.getSenha()));
		clienteCriado.setSenha(cliente.getSenha());
		
		repoCliente.save(clienteCriado);
		
		return cliente;
	}
}