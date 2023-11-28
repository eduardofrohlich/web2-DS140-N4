package backend.lavanderia.relatorio.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.service.PedidoService;
import backend.lavanderia.relatorio.dto.RelatorioClienteDTO;
import backend.lavanderia.relatorio.dto.RelatorioClienteFielDTO;
import backend.lavanderia.relatorio.dto.RelatorioReceitaDTO;
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

	public List<RelatorioReceitaDTO> listarRelatorioReceita(String dataInicial, String dataFinal) {
	    LocalDate data1 = getDataInicial(dataInicial);
	    LocalDate data2 = getDataFinal(dataFinal);

	    validarDatas(data1, data2);

	    List<RelatorioReceitaDTO> result = new ArrayList<>();

	    for (LocalDate dataFor = data1; !dataFor.isAfter(data2); dataFor = dataFor.plusDays(1)) {
	        String dataString = formatarData(dataFor);
	        List<Pedido> pedidos = pedidoService.obterPorDataHora(dataString);

	        if (!pedidos.isEmpty()) {
	            double valorTotalGasto = pedidos.stream().mapToDouble(Pedido::getValorTotal).sum();
	            result.add(new RelatorioReceitaDTO(dataString, pedidos.size(), valorTotalGasto));
	        }
	    }

	    return result;
	}

	private LocalDate getDataInicial(String dataInicial) {
	    return (dataInicial != null) ? LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("yyyy-MM-dd")) : LocalDate.of(2023, 8, 1);
	}

	private LocalDate getDataFinal(String dataFinal) {
	    return (dataFinal != null) ? LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("yyyy-MM-dd")) : LocalDate.now();
	}

	private void validarDatas(LocalDate dataInicial, LocalDate dataFinal) {
	    if (dataInicial.isAfter(dataFinal)) {
	        throw new RuntimeException("A data inicial não pode ser maior que a final!");
	    }

	    if (dataInicial.isBefore(LocalDate.of(2023, 8, 1))) {
	        throw new RuntimeException("A data inicial deve ser no máximo 1 de agosto de 2023!");
	    }

	    if (dataFinal.isAfter(LocalDate.now())) {
	        throw new RuntimeException("A data final pode ser no máximo até o dia de hoje!");
	    }

	    if (dataInicial.isAfter(LocalDate.now())) {
	        throw new RuntimeException("A data inicial não pode ser maior que o dia de hoje!");
	    }
	}


	private String formatarData(LocalDate data) {
	    return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
