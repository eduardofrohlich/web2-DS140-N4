package backend.lavanderia.relatorio.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.lavanderia.relatorio.dto.RelatorioClienteDTO;
import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.usuario.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("relatorios")
public class RelatorioController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/clientes")
	public List<RelatorioClienteDTO> listarClientes(){
		List<Cliente> x = clienteService.findAll();
		List<RelatorioClienteDTO> y = new ArrayList<>();
		for(Cliente cliente : x)
			y.add(mapper.map(cliente, RelatorioClienteDTO.class));
		return y;
	}
	
//	@GetMapping("/receita")
//	public List<RelatorioClienteDTO> listarReceitas(@RequestBody DataReceitaApi api){
//		List<Cliente> x = service.findAll();
//		return x.map(mapper::toApi);
//	}
//	
//	@GetMapping("/clientes-fieis")
//	public List<RelatorioClienteDTO> listarClientesFieis(){
//		List<Cliente> x = service.findAll();
//		return x.map(mapper::toApi);
//	}
}
