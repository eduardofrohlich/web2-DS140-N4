package backend.lavanderia.usuario.controller;

import backend.lavanderia.usuario.repository.ClienteRepository;
import backend.lavanderia.usuario.repository.EnderecoRepository;
import backend.lavanderia.usuario.service.Criptografia;
import backend.lavanderia.usuario.dto.ClienteDTO;
import backend.lavanderia.usuario.dto.EnderecoDTO;
import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.usuario.entity.Endereco;
import backend.lavanderia.usuario.directive.ValidaUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class ClienteController 
{
	@Autowired
	private ClienteRepository repoCliente;
	@Autowired
	private EnderecoRepository repoEndereco;
	//@Autowired
	//private PedidoRepository repoPedido;
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
	
	// Retorna os 3 clientes que mais fizeram pedidos
	/*@GetMapping("/clientes_fieis")
	public List<ClienteDTO> obterClientesFieis()
	{
		List<Cliente> buscaClientes = repoCliente.findAll();
		
		if(buscaClientes.isEmpty())
			throw new RuntimeException("Não existe clientes!");
		
		List<Pedido> buscaPedidos = repoPedido.findAll();
		
		if(buscaPedidos.isEmpty())
			throw new RuntimeException("Não existe pedidos!");
		
		List<ClienteDTO> clientesFieis = new ArrayList<>();
		
		for(Cliente cliente : buscaClientes)
		{
			
		}
	}*/
	
	@PostMapping("/clientes")
	public ClienteDTO inserirCliente(@RequestBody ClienteDTO cliente)
	{
		if(!repoCliente.findByCpf(cliente.getCpf()).isEmpty())
			throw new IllegalArgumentException("O cliente já existe!");
		
		ValidaUsuario.usuario(cliente);
		Optional<Endereco> endereco = repoEndereco.findByCepAndNumero(cliente.getEndereco().getCep(), Long.valueOf(cliente.getEndereco().getNumero()));
		
		if(endereco.isEmpty())
			endereco = Optional.of(repoEndereco.save(mapper.map(cliente.getEndereco(), Endereco.class)));
		
		cliente.setEndereco(mapper.map(endereco.get(), EnderecoDTO.class)); // Garante que o endereço vai estar correto
		cliente.setSenha(Criptografia.criptografarSenha(cliente.getSenha()));
		
		Cliente clienteInserido = repoCliente.save(mapper.map(cliente, Cliente.class));
		
		return mapper.map(clienteInserido, ClienteDTO.class);
	}
	
	// Não é necessário :/
	/*
	@GetMapping("/clientes/{id}")
	public ClienteDTO obterClienteComId(@PathVariable("id") Long id)
	{
		Optional<Cliente> buscaCliente = repoCliente.findById(id);
		
		if(buscaCliente.isEmpty())
			throw new IllegalArgumentException("Não existe cliente com esse id!");
		
		return mapper.map(buscaCliente, ClienteDTO.class);
	}
	*/
	
	// Não é necessário atualizar :/
	/*
	@PutMapping("/clientes/{id}")
	public ClienteDTO atualizarCliente(@PathVariable("id") int id, @RequestBody ClienteDTO cliente)
	{
		Optional<Cliente> buscaCliente = repoCliente.findById(Long.valueOf(id));
		
		if(buscaCliente.isEmpty())
			throw new IllegalArgumentException("Não existe cliente com esse id!");
		
		ValidaUsuario.usuario(cliente);
		Long idEndereco = buscaCliente.get().getEndereco().getIdEndereco();
		
		switch(Math.toIntExact(repoCliente.countByEndereco(buscaCliente.get().getEndereco())))
		{
			case 0:
				throw new IllegalArgumentException("Não existe endereço com esse id!");
			
			// Pode sobreescrever o endereço
			case 1:
				buscaCliente.get().setEndereco(mapper.map(cliente.getEndereco(), Endereco.class));
				buscaCliente.get().getEndereco().setIdEndereco(idEndereco);
				repoEndereco.save(buscaCliente.get().getEndereco());
				break;
				
			// Deve criar um novo endereço (caso em que clientes estão em um mesmo endereço e um cliente muda de endereço)
			default:
				Endereco endereco = repoEndereco.save(mapper.map(cliente.getEndereco(), Endereco.class));
				buscaCliente.get().setEndereco(endereco);
				break;
		}
		
		buscaCliente.get().setCpf(cliente.getCpf());
		buscaCliente.get().setEmail(cliente.getEmail());
		buscaCliente.get().setNome(cliente.getNome());
		buscaCliente.get().setSenha(Long.valueOf(cliente.getSenha()));
		buscaCliente.get().setTelefone(cliente.getTelefone());
		
		repoCliente.save(buscaCliente.get());
		return mapper.map(buscaCliente.get(), ClienteDTO.class);
	}
	*/
	
	// Não é necessário remover :/
	/*
	@DeleteMapping("/clientes/{id}")
	public ClienteDTO removerCliente(@PathVariable("id") int id)
	{
		Optional<Cliente> buscaCliente = repoCliente.findById(Long.valueOf(id));
		
		if(buscaCliente.isEmpty())
			throw new IllegalArgumentException("Não existe cliente com esse id!");
		
		repoCliente.deleteById(buscaCliente.get().getIdCliente());
		
		if(repoCliente.countByEndereco(buscaCliente.get().getEndereco()) == 0L)
			repoEndereco.deleteById(buscaCliente.get().getEndereco().getIdEndereco());
		
		return mapper.map(buscaCliente, ClienteDTO.class);
	}
	*/
}