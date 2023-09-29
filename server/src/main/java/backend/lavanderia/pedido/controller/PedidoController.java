package backend.lavanderia.pedido.controller;

import backend.lavanderia.pedido.repository.PedidoRepository;
import backend.lavanderia.pedido.repository.RoupaRepository;
import backend.lavanderia.pedido.repository.RoupasPedidoRepository;
import backend.lavanderia.usuario.repository.ClienteRepository;
import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.entity.Roupa;
import backend.lavanderia.pedido.entity.RoupasPedido;
import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.pedido.dto.PedidoDTO;
import backend.lavanderia.pedido.dto.RoupaDTO;
import backend.lavanderia.pedido.dto.RoupasPedidoDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import backend.lavanderia.pedido.service.OrderStatus;

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
public class PedidoController {
	@Autowired
	private PedidoRepository repoPedido;
	@Autowired
	private ClienteRepository repoCliente;
	@Autowired
	private RoupasPedidoRepository repoRoupasPedido;
	@Autowired
	private RoupaRepository repoRoupa;
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/pedidos")
	public List<PedidoDTO> buscarTodosPedidos() {
		List<Pedido> buscaPedidos = repoPedido.findAll();
		List<PedidoDTO> lista = new ArrayList<>();

		for (Pedido pedido : buscaPedidos) {
			PedidoDTO p = mapper.map(pedido, PedidoDTO.class);
			p.setEstado(OrderStatus.getStatusString(pedido.getEstado()));

			lista.add(p);
		}

		return lista;
	}

	@GetMapping("/pedidos/{id}")
	public PedidoDTO buscarPedidoComId(@PathVariable Long id) {
		Optional<Pedido> buscaPedido = repoPedido.findById(id);

		if (buscaPedido.isEmpty())
			throw new RuntimeException("Não existe pedido com esse id!");

		PedidoDTO p = mapper.map(buscaPedido, PedidoDTO.class);
		p.setEstado(OrderStatus.getStatusString(buscaPedido.get().getEstado()));

		return p;
	}

	@PostMapping("/pedidos")
	public PedidoDTO inserirPedido(@RequestBody PedidoDTO pedido) {
		Optional<Cliente> buscaCliente = repoCliente.findById(Long.valueOf(pedido.getCliente().getIdCliente()));

		if (buscaCliente.isEmpty())
			throw new RuntimeException("O cliente associado à esse pedido não existe!");

		List<RoupasPedido> roupas = new ArrayList<>();

		for (RoupasPedidoDTO rp : pedido.getRoupas()) {
			Optional<Roupa> roupa = repoRoupa.findById(Long.valueOf(rp.getRoupa().getIdRoupa()));

			if (roupa.isEmpty())
				throw new RuntimeException("Não existe roupa com o id " + rp.getRoupa().getIdRoupa());

			rp.setRoupa(mapper.map(roupa, RoupaDTO.class));
			// Fazer o calculo do valorTotal da roupa...
			roupas.add(mapper.map(rp, RoupasPedido.class));
		}

		Pedido pedidoInserido = new Pedido();
		pedidoInserido.setRoupas(roupas);
		pedidoInserido.setCliente(buscaCliente.get());
		pedidoInserido.setDataHora(pedido.getDataHora());
		pedidoInserido.setEstado(OrderStatus.getStatusCode(pedido.getEstado()));
		pedidoInserido.setPrazoEntrega(Long.valueOf(pedido.getPrazoEntrega()));
		pedidoInserido.setValorTotal(pedido.getValorTotal());

		pedidoInserido = repoPedido.save(pedidoInserido);

		// Setar o atributo "pedido" nas roupas para poder salvar no repoRoupasPedido
		for (int i = 0; i < pedidoInserido.getRoupas().size(); i++)
			pedidoInserido.getRoupas().get(i).setPedido(pedidoInserido);

		repoRoupasPedido.saveAll(pedidoInserido.getRoupas());

		pedido = mapper.map(pedidoInserido, PedidoDTO.class);
		pedido.setEstado(OrderStatus.getStatusString(pedidoInserido.getEstado()));

		return pedido;
	}

	// Não é necessário Atualizar :/
	@PutMapping("/pedidos/{id}")
	public PedidoDTO atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedido) {
		Optional<Pedido> buscaPedido = repoPedido.findById(id);

		if (buscaPedido.isEmpty())
			throw new RuntimeException("Não existe pedido com esse id!");

		Optional<Cliente> buscaCliente = repoCliente.findById(Long.valueOf(pedido.getCliente().getIdCliente()));

		if (buscaCliente.isEmpty())
			throw new RuntimeException("O cliente desse pedido não está registrado!");

		buscaPedido.get().setCliente(buscaCliente.get());
		buscaPedido.get().setEstado(OrderStatus.getStatusCode(pedido.getEstado()));
		buscaPedido.get().setValorTotal(pedido.getValorTotal());
		buscaPedido.get().setPrazoEntrega(Long.valueOf(pedido.getPrazoEntrega()));
		buscaPedido.get().setDataHora(pedido.getDataHora());

		repoPedido.save(buscaPedido.get());
		PedidoDTO pedidoAtualizado = mapper.map(buscaPedido, PedidoDTO.class);

		pedidoAtualizado.setEstado(OrderStatus.getStatusString(buscaPedido.get().getEstado()));
		return pedidoAtualizado;
	}

	@PutMapping("/pedidos/{idPedido}/estado/{novoEstado}")
	public PedidoDTO atualizarEstadoPedido(@PathVariable("idPedido") Long idPedido,
			@PathVariable("novoEstado") String novoEstado) {
		Optional<Pedido> buscaPedido = repoPedido.findById(idPedido);

		if (buscaPedido.isEmpty())
			throw new RuntimeException("Não existe pedido com esse id!");

		Long codigoEstado = OrderStatus.getStatusCode(novoEstado);
		buscaPedido.get().setEstado(codigoEstado);

		Pedido pedidoInserido = repoPedido.save(buscaPedido.get());
		PedidoDTO p = mapper.map(pedidoInserido, PedidoDTO.class);

		p.setEstado(OrderStatus.getStatusString(pedidoInserido.getEstado()));
		return p;
	}

	// Não é necessário Remover :/
	@DeleteMapping("/pedidos/{id}")
	public PedidoDTO removerPedido(@PathVariable("id") Long id) {
		Optional<Pedido> buscaPedido = repoPedido.findById(id);

		if (buscaPedido.isEmpty())
			throw new RuntimeException("Não existe pedido com esse id!");

		repoPedido.deleteById(id);
		PedidoDTO p = mapper.map(buscaPedido, PedidoDTO.class);

		p.setEstado(OrderStatus.getStatusString(buscaPedido.get().getEstado()));
		return p;
	}

	/* TESTES */
	@GetMapping("/roupas-pedido")
	public List<RoupasPedidoDTO> obterItensPedidos() {
		List<RoupasPedido> buscaPedidos = repoRoupasPedido.findAll();
		List<RoupasPedidoDTO> lista = new ArrayList<>();

		for (RoupasPedido pedido : buscaPedidos)
			lista.add(mapper.map(pedido, RoupasPedidoDTO.class));

		return lista;
	}
}
