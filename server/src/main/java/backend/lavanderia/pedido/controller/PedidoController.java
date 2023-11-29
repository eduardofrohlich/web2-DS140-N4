package backend.lavanderia.pedido.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.pedido.dto.PedidoAbertoDTO;
import backend.lavanderia.pedido.dto.PedidoDTO;
import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.entity.enums.PedidoStatus;
import backend.lavanderia.pedido.repository.PedidoRepository;
import backend.lavanderia.pedido.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@Autowired
	private PedidoRepository repoPedido;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(value = "/todos")
	public List<PedidoDTO> obterTodosPedidos() {
		List<Pedido> buscaLista = repoPedido.findAll();
		List<PedidoDTO> lista = new ArrayList<>();
		for (Pedido pedido : buscaLista)
			lista.add(mapper.map(pedido, PedidoDTO.class));
		return lista;
	}

	@GetMapping(value = "/abertos")
	public List<PedidoAbertoDTO> obterPedidosAbertos() {
		List<Pedido> buscaLista = repoPedido.findAll();
		List<PedidoAbertoDTO> lista = new ArrayList<>();
		for (Pedido pedido : buscaLista)
			if (pedido.getPedidoStatus() == PedidoStatus.ABERTO) {
				PedidoAbertoDTO dto = new PedidoAbertoDTO();
				dto.setNumPedido(pedido.getIdPedido().toString());
				dto.setNomeCliente(pedido.getCliente().getNome());
				dto.setDataPedido(pedido.getDataHora());
				dto.setStatus(pedido.getPedidoStatus().toString());
				dto.setPrazo(pedido.getPrazoEntrega().toString());
				dto.setValorTotal(pedido.getValorTotal().toString());
				lista.add(dto);
			}
		return lista;
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
}
