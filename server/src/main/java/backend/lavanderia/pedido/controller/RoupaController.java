package backend.lavanderia.pedido.controller;

import backend.lavanderia.pedido.repository.RoupaRepository;
import backend.lavanderia.usuario.dto.FuncionarioDTO;
import backend.lavanderia.usuario.entity.Funcionario;
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
public class RoupaController {
	@Autowired
	private RoupaRepository repoRoupa;
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/roupas")
	public List<RoupaDTO> obterTodasRoupas() {
		List<Roupa> buscaRoupas = repoRoupa.findAll();
		List<RoupaDTO> lista = new ArrayList<>();

		for (Roupa roupa : buscaRoupas)
			lista.add(mapper.map(roupa, RoupaDTO.class));

		return lista;
	}

	@GetMapping("/roupas/{id}")
	public RoupaDTO getById(@PathVariable("id") String longId) {
		Optional<Roupa> buscaRoupa = repoRoupa.findById(Long.valueOf(longId));

		if (buscaRoupa.isEmpty())
			throw new RuntimeException("Não existe funcionario com esse id!");

		return mapper.map(buscaRoupa, RoupaDTO.class);
	};

	@GetMapping("/roupas/atualizar/{id}/{nome}/{prazo}/{valor}/{imagem}")
	public String atualizarRoupa(@PathVariable Long id,
			@PathVariable String nome,
			@PathVariable String prazo,
			@PathVariable String valor,
			@PathVariable String imagem) {
		Optional<Roupa> buscaRoupa = repoRoupa.findById(id);

		if (buscaRoupa.isEmpty())
			throw new RuntimeException("Não existe roupa com esse id!");
		buscaRoupa.get().setNomeRoupa(nome);
		buscaRoupa.get().setPrazo(Integer.valueOf(prazo));
		buscaRoupa.get().setValor(Double.valueOf(valor));
		buscaRoupa.get().setImagem(imagem);

		repoRoupa.save(buscaRoupa.get());
		return "Roupa atualizada com sucesso!";
	}

	@GetMapping("/roupas/excluir/{id}")
	public String removerRoupa(@PathVariable("id") Long id) {
		Optional<Roupa> buscaRoupa = repoRoupa.findById(id);

		if (buscaRoupa.isEmpty())
			throw new RuntimeException("Não existe roupa com esse id!");

		repoRoupa.deleteById(id);
		return "Roupa excluida com sucesso!";
	}
}
