package backend.lavanderia.relatorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.relatorio.dto.RelatorioClienteDTO;
import backend.lavanderia.relatorio.dto.RelatorioClienteFielDTO;
import backend.lavanderia.relatorio.dto.RelatorioReceitaDTO;
import backend.lavanderia.relatorio.dto.RelatorioReceitaDatasDTO;
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
	public List<RelatorioReceitaDTO> listarReceitas(@RequestBody @Nullable RelatorioReceitaDatasDTO api){
		return relatorioService.listarRelatorioReceita(api);
	}

	@GetMapping("/clientes-fieis")
	public List<RelatorioClienteFielDTO> listarClientesFieis(){
		return relatorioService.listarClientesFieis();
	}
}
