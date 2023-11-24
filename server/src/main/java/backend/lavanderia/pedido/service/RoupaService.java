package backend.lavanderia.pedido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.lavanderia.pedido.entity.Roupa;
import backend.lavanderia.pedido.repository.RoupaRepository;


@Service
public class RoupaService {
	
	@Autowired
	private RoupaRepository repository;
	
	public List<Roupa> findAll(){
		return repository.findAll();
	}
	
	public Roupa findById(Long id) {
		Optional<Roupa> obj = repository.findById(id);
		return obj.get();
	}
	

}
