package backend.lavanderia.pedido.controller;

import backend.lavanderia.pedido.repository.RoupaRepository;
import backend.lavanderia.pedido.entity.Roupa;
import backend.lavanderia.pedido.dto.RoupaDTO;
import backend.lavanderia.pedido.directive.ValidaRoupa;
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
public class RoupaController 
{
	@Autowired
	private RoupaRepository repoRoupa;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/roupas")
	public List<RoupaDTO> obterTodasRoupas()
	{
		List<Roupa> buscaRoupas = repoRoupa.findAll();
		List<RoupaDTO> lista = new ArrayList<>();
		
		for(Roupa roupa : buscaRoupas)
			lista.add(mapper.map(roupa, RoupaDTO.class));
		
		return lista;
	}
	
	@GetMapping("/roupas/{id}")
	public RoupaDTO obterRoupaComId(@PathVariable Long id)
	{
		Optional<Roupa> buscaRoupa = repoRoupa.findById(id);
		
		if(buscaRoupa.isEmpty())
			throw new RuntimeException("Não existe roupa com esse id!");
		
		return mapper.map(buscaRoupa, RoupaDTO.class);
	}
	
	@PostMapping("/roupas")
	public RoupaDTO inserirRoupa(@RequestBody RoupaDTO roupa)
	{
		if(!repoRoupa.findByNomeRoupa(roupa.getNomeRoupa()).isEmpty())
			throw new RuntimeException("A roupa já existe!");
		
		ValidaRoupa.roupa(roupa);
		
		Roupa roupaInserida = repoRoupa.save(mapper.map(roupa, Roupa.class));
		return mapper.map(roupaInserida, RoupaDTO.class);
	}
	
	@PutMapping("/roupas/{id}")
	public RoupaDTO atualizarRoupa(@PathVariable Long id, @RequestBody RoupaDTO roupa)
	{
		Optional<Roupa> buscaRoupa = repoRoupa.findById(id);
		
		if(buscaRoupa.isEmpty())
			throw new RuntimeException("Não existe roupa com esse id!");
		
		ValidaRoupa.roupa(roupa);
		
		buscaRoupa.get().setNomeRoupa(roupa.getNomeRoupa());
		buscaRoupa.get().setPrazo(Long.valueOf(roupa.getPrazo()));
		buscaRoupa.get().setValor(roupa.getValor());
		buscaRoupa.get().setImagem(roupa.getImagem());
		
		repoRoupa.save(buscaRoupa.get());
		return mapper.map(buscaRoupa, RoupaDTO.class);
	}
	
	@DeleteMapping("/roupas/{id}")
	public RoupaDTO removerRoupa(@PathVariable("id") Long id)
	{
		Optional<Roupa> buscaRoupa = repoRoupa.findById(id);
		
		if(buscaRoupa.isEmpty())
			throw new RuntimeException("Não existe roupa com esse id!");
		
		repoRoupa.deleteById(id);
		return mapper.map(buscaRoupa, RoupaDTO.class);
	}
}
