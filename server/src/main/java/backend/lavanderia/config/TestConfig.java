package backend.lavanderia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.usuario.entity.Funcionario;
import backend.lavanderia.usuario.repository.ClienteRepository;
import backend.lavanderia.usuario.repository.FuncionarioRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clientRepository;
	
	@Autowired
	private FuncionarioRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente("Endereco XV", "1234", "joao@gmail.com", "João", "11111111111", "4136210493");
		Cliente c2 = new Cliente("Endereco XX", "1235", "jose@gmail.com", "José", "11111111112", "4136210494");
		Cliente c3 = new Cliente("Endereco XY", "1236", "joana@gmail.com", "Joana", "11111111113", "4136210495");
		Cliente c4 = new Cliente("Endereco XZ", "1237", "joaquina@gmail.com", "Joaquina", "11111111114", "4136210496");
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Funcionario emp1 = new Funcionario(null, "Endereco XA", "1234", "maria@gmail.com", "Maria", "1111122222", "4136210497", "11/10/1990");
		
		Funcionario emp2 = new Funcionario(null, "Endereco XA", "1234", "mario@gmail.com", "Mario", "11111133333", "4136210494", "10/11/1991");
		employeeRepository.saveAll(Arrays.asList(emp1, emp2));
		
	}
	

}
