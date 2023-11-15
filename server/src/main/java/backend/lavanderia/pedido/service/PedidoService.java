package backend.lavanderia.pedido.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.repository.PedidoRepository;
import backend.lavanderia.usuario.entity.Cliente;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Pedido> obterPorCliente(Cliente cliente) {
		return repository.findByCliente(cliente);
	}

    public List<Pedido> obterPorDataHora(String dataString) {
        return repository.findByDataHoraContaining(dataString);
    }
}
