package backend.lavanderia.usuario.controller;

import backend.lavanderia.usuario.repository.FuncionarioRepository;
import backend.lavanderia.usuario.repository.EnderecoRepository;
import backend.lavanderia.usuario.entity.Funcionario;
import backend.lavanderia.usuario.entity.Endereco;
import backend.lavanderia.usuario.dto.FuncionarioDTO;
import backend.lavanderia.usuario.dto.EnderecoDTO;
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
public class FuncionarioController 
{
	@Autowired
	private FuncionarioRepository repoFuncionario;
	@Autowired
	private EnderecoRepository repoEndereco;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/funcionarios")
	public List<FuncionarioDTO> obterTodosFuncionarios()
	{
		List<Funcionario> buscaLista = repoFuncionario.findAll();
		List<FuncionarioDTO> lista = new ArrayList<>();
		
		for(Funcionario funcionario : buscaLista)
			lista.add(mapper.map(funcionario, FuncionarioDTO.class));
		
		return lista;
	}

	
	@GetMapping("/funcionarios/{id}")
	public FuncionarioDTO obterFuncionarioComId(@PathVariable("id") Long id)
	{
		Optional<Funcionario> buscaFuncionario = repoFuncionario.findById(id);
		
		if(buscaFuncionario.isEmpty())
			throw new IllegalArgumentException("Não existe cliente com esse id!");
		
		return mapper.map(buscaFuncionario, FuncionarioDTO.class);
	}
	
	@PostMapping("/funcionarios")
	public FuncionarioDTO inserirCliente(@RequestBody FuncionarioDTO funcionario)
	{
		if(!repoFuncionario.findByCpf(funcionario.getCpf()).isEmpty())
			throw new IllegalArgumentException("O cliente já existe!");
		
		ValidaUsuario.usuario(funcionario);
		Optional<Endereco> endereco = repoEndereco.findByCepAndNumero(funcionario.getEndereco().getCep(), Long.valueOf(funcionario.getEndereco().getNumero()));
		
		if(endereco.isEmpty())
			endereco = Optional.of(repoEndereco.save(mapper.map(funcionario.getEndereco(), Endereco.class)));
		
		funcionario.setEndereco(mapper.map(endereco.get(), EnderecoDTO.class)); // Garante que o endereço vai estar correto
		Funcionario funcionarioInserido = repoFuncionario.save(mapper.map(funcionario, Funcionario.class));
		
		return mapper.map(funcionarioInserido, FuncionarioDTO.class);
	}
	
	@PutMapping("/funcionarios/{id}")
	public FuncionarioDTO atualizarFuncionario(@PathVariable("id") int id, @RequestBody FuncionarioDTO funcionario)
	{
		Optional<Funcionario> buscaFuncionario = repoFuncionario.findById(Long.valueOf(id));
		
		if(buscaFuncionario.isEmpty())
			throw new IllegalArgumentException("Não existe cliente com esse id!");
		
		ValidaUsuario.usuario(funcionario);
		Long idEndereco = buscaFuncionario.get().getEndereco().getIdEndereco();
		
		switch(Math.toIntExact(repoFuncionario.countByEndereco(buscaFuncionario.get().getEndereco())))
		{
			case 0:
				throw new IllegalArgumentException("Não existe endereço com esse id!");
			
			// Pode sobreescrever o endereço
			case 1:
				buscaFuncionario.get().setEndereco(mapper.map(funcionario.getEndereco(), Endereco.class));
				buscaFuncionario.get().getEndereco().setIdEndereco(idEndereco);
				repoEndereco.save(buscaFuncionario.get().getEndereco());
				break;
				
			// Deve criar um novo endereço (caso em que clientes estão em um mesmo endereço e um cliente muda de endereço)
			default:
				Endereco endereco = repoEndereco.save(mapper.map(funcionario.getEndereco(), Endereco.class));
				buscaFuncionario.get().setEndereco(endereco);
				break;
		}
		
		buscaFuncionario.get().setCpf(funcionario.getCpf());
		buscaFuncionario.get().setEmail(funcionario.getEmail());
		buscaFuncionario.get().setNome(funcionario.getNome());
		buscaFuncionario.get().setSenha(Long.valueOf(funcionario.getSenha()));
		buscaFuncionario.get().setTelefone(funcionario.getTelefone());
		buscaFuncionario.get().setDataNascimento(funcionario.getDataNascimento());
		
		repoFuncionario.save(buscaFuncionario.get());
		
		return mapper.map(buscaFuncionario.get(), FuncionarioDTO.class);
	}
	
	@DeleteMapping("/funcionarios/{id}")
	public FuncionarioDTO removerCliente(@PathVariable("id") int id)
	{
		Optional<Funcionario> buscaFuncionario = repoFuncionario.findById(Long.valueOf(id));
		
		if(buscaFuncionario.isEmpty())
			throw new IllegalArgumentException("Não existe cliente com esse id!");
		
		repoFuncionario.deleteById(buscaFuncionario.get().getIdFuncionario());
		
		if(repoFuncionario.countByEndereco(buscaFuncionario.get().getEndereco()) == 0L)
			repoEndereco.deleteById(buscaFuncionario.get().getEndereco().getIdEndereco());
		
		return mapper.map(buscaFuncionario, FuncionarioDTO.class);
	}
}
