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
	public List<PedidoDTO> obterPedidosAbertos() {
		List<Pedido> buscaLista = repoPedido.findAll();
		List<PedidoDTO> lista = new ArrayList<>();
		for (Pedido pedido : buscaLista)
			if (pedido.getPedidoStatus() == PedidoStatus.ABERTO) {
				lista.add(mapper.map(pedido, PedidoDTO.class));
			}
		return lista;
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * @Autowired
	 * private PedidoRepository repoPedido;
	 * 
	 * @Autowired
	 * private ClienteRepository repoCliente;
	 * 
	 * @Autowired
	 * private RoupasPedidoRepository repoRoupasPedido;
	 * 
	 * @Autowired
	 * private RoupaRepository repoRoupa;
	 * 
	 * @Autowired
	 * private ModelMapper mapper;
	 * 
	 * @GetMapping("/pedidos")
	 * 
	 * 
	 * 
	 * 
	 * /*public List<PedidoDTO> buscarTodosPedidos()
	 * {
	 * List<Pedido> buscaPedidos = repoPedido.findAll();
	 * List<PedidoDTO> lista = new ArrayList<>();
	 * 
	 * for(Pedido pedido : buscaPedidos)
	 * {
	 * PedidoDTO p = mapper.map(pedido, PedidoDTO.class);
	 * p.setEstado(OrderStatus.getStatusString(pedido.getEstado()));
	 * 
	 * lista.add(p);
	 * }
	 * 
	 * return lista;
	 * }
	 */
	/*
	 * 
	 * @GetMapping("/pedidos/{id}")
	 * public PedidoDTO buscarPedidoComId(@PathVariable Long id)
	 * {
	 * Optional<Pedido> buscaPedido = repoPedido.findById(id);
	 * 
	 * if(buscaPedido.isEmpty())
	 * throw new RuntimeException("Não existe pedido com esse id!");
	 * 
	 * PedidoDTO p = mapper.map(buscaPedido, PedidoDTO.class);
	 * p.setEstado(OrderStatus.getStatusString(buscaPedido.get().getEstado()));
	 * 
	 * return p;
	 * }
	 * 
	 * @GetMapping("/pedidos/aberto")
	 * public List<PedidoDTO> buscarTodosPedidosAberto()
	 * {
	 * List<Pedido> buscaPedidos = repoPedido.findAll();
	 * List<PedidoDTO> lista = new ArrayList<>();
	 * 
	 * for(Pedido pedido : buscaPedidos)
	 * if(Math.toIntExact(pedido.getEstado()) == 1)
	 * {
	 * PedidoDTO p = mapper.map(pedido, PedidoDTO.class);
	 * p.setEstado(OrderStatus.getStatusString(pedido.getEstado()));
	 * 
	 * lista.add(p);
	 * }
	 * 
	 * return lista;
	 * }
	 * 
	 * @GetMapping("/pedidos/cliente/{id}")
	 * public List<PedidoDTO> buscarTodosPedidosCliente(@PathVariable Long id)
	 * {
	 * Optional<Cliente> buscaCliente = repoCliente.findById(id);
	 * 
	 * if(buscaCliente.isEmpty())
	 * throw new RuntimeException("Não existe cliente com esse id!");
	 * 
	 * List<Pedido> buscaPedidos = repoPedido.findAll();
	 * List<PedidoDTO> lista = new ArrayList<>();
	 * 
	 * for(Pedido pedido : buscaPedidos)
	 * if(pedido.getCliente().getIdCliente() == id)
	 * {
	 * PedidoDTO p = mapper.map(pedido, PedidoDTO.class);
	 * p.setEstado(OrderStatus.getStatusString(pedido.getEstado()));
	 * 
	 * lista.add(p);
	 * }
	 * 
	 * 
	 * return lista;
	 * }
	 * 
	 * @GetMapping("/pedidos/cliente/{id}/aberto")
	 * public List<PedidoDTO> buscarTodosPedidosAbertoCliente(@PathVariable Long id)
	 * {
	 * Optional<Cliente> buscaCliente = repoCliente.findById(id);
	 * 
	 * if(buscaCliente.isEmpty())
	 * throw new RuntimeException("Não existe cliente com esse id!");
	 * 
	 * List<Pedido> buscaPedidos = repoPedido.findAll();
	 * List<PedidoDTO> lista = new ArrayList<>();
	 * 
	 * for(Pedido pedido : buscaPedidos)
	 * if(pedido.getCliente().getIdCliente() == id &&
	 * Math.toIntExact(pedido.getEstado()) == 1)
	 * {
	 * PedidoDTO p = mapper.map(pedido, PedidoDTO.class);
	 * p.setEstado(OrderStatus.getStatusString(pedido.getEstado()));
	 * 
	 * lista.add(p);
	 * }
	 * 
	 * 
	 * return lista;
	 * }
	 * 
	 * @PostMapping("/pedidos")
	 * public PedidoDTO inserirPedido(@RequestBody PedidoDTO pedido)
	 * {
	 * Optional<Cliente> buscaCliente =
	 * repoCliente.findById(Long.valueOf(pedido.getCliente().getIdCliente()));
	 * 
	 * if(buscaCliente.isEmpty())
	 * throw new RuntimeException("O cliente associado à esse pedido não existe!");
	 * 
	 * List<RoupasPedido> roupas = new ArrayList<>();
	 * 
	 * double valorTotal = 0;
	 * int prazoEntrega = 0;
	 * 
	 * for(RoupasPedidoDTO rp : pedido.getRoupas())
	 * {
	 * Optional<Roupa> roupa =
	 * repoRoupa.findById(Long.valueOf(rp.getRoupa().getIdRoupa()));
	 * 
	 * if(roupa.isEmpty())
	 * throw new RuntimeException("Não existe roupa com o id " +
	 * rp.getRoupa().getIdRoupa());
	 * 
	 * rp.setRoupa(mapper.map(roupa, RoupaDTO.class));
	 * 
	 * if(rp.getQtdRoupa() < 1)
	 * throw new RuntimeException("A roupa com id " + rp.getRoupa().getIdRoupa() +
	 * " deve ter pelo menos 1 em qtdRoupa!");
	 * 
	 * rp.setValorTotalRoupa((rp.getRoupa().getValor() * rp.getQtdRoupa()));
	 * valorTotal += rp.getValorTotalRoupa();
	 * 
	 * if(rp.getRoupa().getPrazo() > prazoEntrega)
	 * prazoEntrega = rp.getRoupa().getPrazo();
	 * 
	 * roupas.add(mapper.map(rp, RoupasPedido.class));
	 * }
	 * 
	 * Pedido pedidoInserido = new Pedido();
	 * pedidoInserido.setRoupas(roupas);
	 * pedidoInserido.setCliente(buscaCliente.get());
	 * pedidoInserido.setEstado(1L);
	 * pedidoInserido.setPrazoEntrega(Long.valueOf(prazoEntrega));
	 * pedidoInserido.setValorTotal(valorTotal);
	 * 
	 * LocalDateTime dataHora = LocalDateTime.now();
	 * DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	 * 
	 * pedidoInserido.setDataHora(dataHora.format(formato));
	 * 
	 * // Setar o atributo "pedido" nas roupas para poder salvar no repoRoupasPedido
	 * for(int i = 0; i < pedidoInserido.getRoupas().size(); i++)
	 * pedidoInserido.getRoupas().get(i).setPedido(pedidoInserido);
	 * 
	 * pedido = mapper.map(pedidoInserido, PedidoDTO.class);
	 * pedido.setEstado("aberto");
	 * 
	 * pedidoInserido = repoPedido.save(pedidoInserido);
	 * repoRoupasPedido.saveAll(pedidoInserido.getRoupas());
	 * 
	 * pedido = mapper.map(pedidoInserido, PedidoDTO.class);
	 * pedido.setEstado(OrderStatus.getStatusString(pedidoInserido.getEstado()));
	 * 
	 * return pedido;
	 * }
	 * 
	 * @PutMapping("/pedidos/{idPedido}/estado/{novoEstado}")
	 * public PedidoDTO atualizarEstadoPedido(@PathVariable("idPedido") Long
	 * idPedido, @PathVariable("novoEstado") String novoEstado)
	 * {
	 * Optional<Pedido> buscaPedido = repoPedido.findById(idPedido);
	 * 
	 * if(buscaPedido.isEmpty())
	 * throw new RuntimeException("Não existe pedido com esse id!");
	 * 
	 * buscaPedido.get().setEstado(OrderStatus.getStatusCode(novoEstado));
	 * 
	 * LocalDateTime dataHora = LocalDateTime.now();
	 * DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	 * 
	 * buscaPedido.get().setDataHora(dataHora.format(formato));
	 * Pedido pedidoInserido = repoPedido.save(buscaPedido.get());
	 * 
	 * PedidoDTO p = mapper.map(pedidoInserido, PedidoDTO.class);
	 * p.setEstado(OrderStatus.getStatusString(pedidoInserido.getEstado()));
	 * 
	 * return p;
	 * }
	 */
}
