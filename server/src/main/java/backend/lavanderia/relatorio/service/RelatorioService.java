package backend.lavanderia.relatorio.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.service.PedidoService;
import backend.lavanderia.relatorio.dto.RelatorioClienteDTO;
import backend.lavanderia.relatorio.dto.RelatorioClienteFielDTO;
import backend.lavanderia.relatorio.dto.RelatorioReceitaDTO;
import backend.lavanderia.relatorio.dto.RelatorioReceitaDatasDTO;
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
        Collections.sort(result, (c1, c2) -> Integer.compare(c2.getCount(), c1.getCount()));
        return result.subList(0, Math.min(result.size(), 3));
	}
	
	public List<RelatorioReceitaDTO> listarRelatorioReceita(RelatorioReceitaDatasDTO api){
			LocalDate data = LocalDate.of(api.dataInicial().getYear(), api.dataInicial().getMonthValue(), api.dataInicial().getDayOfMonth());
			List<RelatorioReceitaDTO> result = new ArrayList<>();
			for(LocalDate dataaa = data; !dataaa.isAfter(api.dataFinal());dataaa = dataaa.plusDays(1)){
				String dataString = dataaa.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				List<Pedido> pedidos = pedidoService.obterPorDataHora(dataString);
				if (!(pedidos.isEmpty())) {
					double valorTotalGasto = pedidos.stream().mapToDouble(Pedido::getValorTotal).sum();
					result.add(new RelatorioReceitaDTO(dataString, pedidos.size(), valorTotalGasto));
				}
			}
			return result;
	}
}
