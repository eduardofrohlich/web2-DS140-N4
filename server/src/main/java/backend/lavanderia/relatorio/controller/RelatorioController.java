package backend.lavanderia.relatorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.relatorio.dto.RelatorioClienteDTO;
import backend.lavanderia.relatorio.dto.RelatorioClienteFielDTO;
import backend.lavanderia.relatorio.dto.RelatorioReceitaDTO;
import backend.lavanderia.relatorio.service.RelatorioService;

@CrossOrigin
@RestController
@RequestMapping("relatorios")
public class RelatorioController {

	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping("/clientes")
	public List<RelatorioClienteDTO> listarClientes(){
		return relatorioService.listarClientes();
	}
	
	@GetMapping("/receita")
	public List<RelatorioReceitaDTO> listarReceitas(@RequestParam(value = "dataInicial", required = false) String dataInicial, @RequestParam(value="dataFinal", required = false) String dataFinal){
		return relatorioService.listarRelatorioReceita(dataInicial, dataFinal);
	}

	@GetMapping("/clientes-fieis")
	public List<RelatorioClienteFielDTO> listarClientesFieis(){
		return relatorioService.listarClientesFieis();
	}
}
