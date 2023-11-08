package backend.lavanderia.relatorio.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.service.PedidoService;
import backend.lavanderia.relatorio.dto.RelatorioClienteDTO;
import backend.lavanderia.relatorio.dto.RelatorioClienteFielDTO;
import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.usuario.service.ClienteService;

@Service
public class RelatorioService {
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<RelatorioClienteDTO> listarClientes(){
		List<Cliente> clientes = clienteService.findAll();
		List<RelatorioClienteDTO> listaEnvio = new ArrayList<>();
		for(Cliente cliente : clientes)
			listaEnvio.add(mapper.map(cliente, RelatorioClienteDTO.class));
		return listaEnvio;
	}
	
	public List<RelatorioClienteFielDTO> listarClientesFieis(){
		List<Cliente> clientes = clienteService.findAll();
        List<RelatorioClienteFielDTO> result = new ArrayList<>();
        for (Cliente cliente : clientes) {
            List<Pedido> pedidos = pedidoService.obterPorCliente(cliente);
            double valorTotalGasto = pedidos.stream().mapToDouble(Pedido::getValorTotal).sum();
            result.add(new RelatorioClienteFielDTO(cliente.getNome(), pedidos.size(), valorTotalGasto));
        }
        return result;
	}
	
//	public List<RelatorioReceitaDTO> listarRelatorioReceita(DataReceitaApi api){
//		List<Pedido> lista = pedidoService.findAll();
//		List<LocalDate> datas = new ArrayList<>();
//		List<RelatorioReceitaDTO> result = new ArrayList<>();
//		if (api.dataInicial()==null && api.dataFinal()==null) {
//			for(Pedido pedidos : lista) {
//				LocalDate.parse(pedidos.getDataHora());
//				datas.add(LocalDate.parse(pedidos.getDataHora(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//				double valorTotalGasto = lista.stream().mapToDouble(Pedido::getValorTotal).sum();
//				result.add(new RelatorioReceitaDTO());
//			}
//		}
//		return null;
//	}
}
