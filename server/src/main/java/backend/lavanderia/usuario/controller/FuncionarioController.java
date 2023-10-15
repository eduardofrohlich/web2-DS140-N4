package backend.lavanderia.usuario.controller;

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

import backend.lavanderia.usuario.directive.ValidaUsuario;
import backend.lavanderia.usuario.dto.FuncionarioDTO;
import backend.lavanderia.usuario.entity.Funcionario;
import backend.lavanderia.usuario.repository.FuncionarioRepository;
import backend.lavanderia.usuario.service.Criptografia;


@CrossOrigin
@RestController
public class FuncionarioController 
{
	@Autowired
	private FuncionarioRepository repoFuncionario;	
	
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
	
	// Login
	@GetMapping("/funcionarios/{email}/{senha}")
	public FuncionarioDTO identificarFuncionario(@PathVariable("email") String email, @PathVariable("senha") String senha)
	{
		Optional<Funcionario> buscaFuncionario = repoFuncionario.findByEmailAndSenha(email, Criptografia.criptografarSenha(senha));
		
		if(buscaFuncionario.isEmpty())
			throw new RuntimeException("Não existe funcionario com esse email e senha!");
		
		return mapper.map(buscaFuncionario, FuncionarioDTO.class);
	}
	
	@PostMapping("/funcionarios")
	public FuncionarioDTO inserirFuncionario(@RequestBody FuncionarioDTO funcionario)
	{
		if(!repoFuncionario.findByCpf(funcionario.getCpf()).isEmpty())
			throw new IllegalArgumentException("O cliente já existe!");
		
		ValidaUsuario.usuario(funcionario);
		
		funcionario.setSenha(Criptografia.criptografarSenha(funcionario.getSenha()));
		
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
	

		buscaFuncionario.get().setCpf(funcionario.getCpf());
		buscaFuncionario.get().setEmail(funcionario.getEmail());
		buscaFuncionario.get().setNome(funcionario.getNome());
		buscaFuncionario.get().setSenha(Criptografia.criptografarSenha(funcionario.getSenha()));
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
		


		return mapper.map(buscaFuncionario, FuncionarioDTO.class);
	}
}
