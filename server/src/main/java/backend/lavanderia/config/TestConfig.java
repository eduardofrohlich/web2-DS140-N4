package backend.lavanderia.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.entity.Roupa;
import backend.lavanderia.pedido.entity.RoupasPedido;
import backend.lavanderia.pedido.entity.enums.PedidoStatus;
import backend.lavanderia.pedido.repository.PedidoRepository;
import backend.lavanderia.pedido.repository.RoupaRepository;
import backend.lavanderia.pedido.repository.RoupasPedidoRepository;
import backend.lavanderia.usuario.entity.Cliente;
import backend.lavanderia.usuario.entity.Funcionario;
import backend.lavanderia.usuario.repository.ClienteRepository;
import backend.lavanderia.usuario.repository.FuncionarioRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clientRepository;

	@Autowired
	private FuncionarioRepository employeeRepository;

	@Autowired
	private PedidoRepository orderRepository;

	@Autowired
	private RoupaRepository clothesRepository;

	@Autowired
	private RoupasPedidoRepository clothesOrderRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "Endereco XV", "1234", "joao@gmail.com", "João", "11111111111", "4136210493");
		Cliente c2 = new Cliente(null, "Endereco XX", "1235", "jose@gmail.com", "José", "11111111112", "4136210494");
		Cliente c3 = new Cliente(null, "Endereco XY", "1236", "joana@gmail.com", "Joana", "11111111113", "4136210495");
		Cliente c4 = new Cliente(null, "Endereco XZ", "1237", "joaquina@gmail.com", "Joaquina", "11111111114",
				"4136210496");
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Funcionario f1 = new Funcionario(null, "Endereco XA", "1234", "maria@gmail.com", "Maria", "1111122222",
				"4136210497", "11/10/1990");

		Funcionario f2 = new Funcionario(null, "Endereco XA", "1234", "mario@gmail.com", "Mario", "11111133333",
				"4136210494", "10/11/1991");
		employeeRepository.saveAll(Arrays.asList(f1, f2));

		Roupa r1 = new Roupa(null, "Calça", 2.0, 3, "calca.png");
		Roupa r2 = new Roupa(null, "Camisa", 1.0, 1, "camisa.png");
		Roupa r3 = new Roupa(null, "Camiseta", 1.5, 2, "camiseta.png");
		Roupa r4 = new Roupa(null, "Meia", 0.5, 1, "meia.png");
		Roupa r5 = new Roupa(null, "Cueca", 0.75, 2, "cueca.png");
		clothesRepository.saveAll(Arrays.asList(r1, r2, r3, r4, r5));

		RoupasPedido rp1 = new RoupasPedido(null, r1, 2L, 2.0);
		RoupasPedido rp2 = new RoupasPedido(null, r2, 1L, 1.0);
		RoupasPedido rp3 = new RoupasPedido(null, r3, 2L, 3.0);
		RoupasPedido rp4 = new RoupasPedido(null, r4, 1L, 0.5);
		RoupasPedido rp5 = new RoupasPedido(null, r5, 2L, 1.5);
		RoupasPedido rp6 = new RoupasPedido(null, r1, 2L, 2.0);
		RoupasPedido rp7 = new RoupasPedido(null, r2, 1L, 1.0);
		RoupasPedido rp8 = new RoupasPedido(null, r3, 2L, 3.0);
		RoupasPedido rp9 = new RoupasPedido(null, r4, 1L, 0.5);
		RoupasPedido rp10 = new RoupasPedido(null, r5, 2L, 1.5);
		RoupasPedido rp11 = new RoupasPedido(null, r1, 2L, 2.0);
		RoupasPedido rp12 = new RoupasPedido(null, r2, 1L, 1.0);
		RoupasPedido rp13 = new RoupasPedido(null, r3, 2L, 3.0);
		RoupasPedido rp14 = new RoupasPedido(null, r4, 1L, 0.5);
		RoupasPedido rp15 = new RoupasPedido(null, r5, 2L, 1.5);
		RoupasPedido rp16 = new RoupasPedido(null, r1, 2L, 2.0);
		RoupasPedido rp17 = new RoupasPedido(null, r2, 1L, 1.0);
		RoupasPedido rp18 = new RoupasPedido(null, r3, 2L, 3.0);
		RoupasPedido rp19 = new RoupasPedido(null, r4, 1L, 0.5);
		RoupasPedido rp20 = new RoupasPedido(null, r5, 2L, 1.5);

		List<RoupasPedido> roupasPedido = new ArrayList<>(
				Arrays.asList(rp1, rp2, rp3, rp4, rp5, rp6, rp7, rp8, rp9, rp10,
						rp11, rp12, rp13, rp14, rp15, rp16, rp17, rp18, rp19, rp20));

		Pedido p10 = new Pedido(null, c1, roupasPedido, PedidoStatus.REJEITADO, 2800.00, 6L, "01/12/2021 09:00");
		Pedido p11 = new Pedido(null, c2, roupasPedido, PedidoStatus.CANCELADO, 3000.00, 7L, "05/12/2021 10:30");
		Pedido p12 = new Pedido(null, c3, roupasPedido, PedidoStatus.RECOLHIDO, 3200.00, 5L, "10/12/2021 11:45");
		Pedido p13 = new Pedido(null, c4, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 3100.00, 8L,
				"15/12/2021 13:15");
		Pedido p14 = new Pedido(null, c1, roupasPedido, PedidoStatus.PAGO, 2900.00, 9L, "20/12/2021 14:45");
		Pedido p15 = new Pedido(null, c2, roupasPedido, PedidoStatus.FINALIZADO, 3300.00, 6L, "25/12/2021 16:00");
		Pedido p16 = new Pedido(null, c3, roupasPedido, PedidoStatus.ABERTO, 2700.00, 7L, "01/01/2022 17:30");
		Pedido p17 = new Pedido(null, c4, roupasPedido, PedidoStatus.REJEITADO, 3100.00, 5L, "05/01/2022 18:45");
		Pedido p18 = new Pedido(null, c1, roupasPedido, PedidoStatus.CANCELADO, 2900.00, 6L, "10/01/2022 20:00");
		Pedido p19 = new Pedido(null, c2, roupasPedido, PedidoStatus.RECOLHIDO, 2800.00, 8L, "15/01/2022 09:00");
		Pedido p20 = new Pedido(null, c3, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 3000.00, 7L,
				"20/01/2022 10:30");
		Pedido p21 = new Pedido(null, c4, roupasPedido, PedidoStatus.PAGO, 3200.00, 5L, "25/01/2022 11:45");
		Pedido p22 = new Pedido(null, c1, roupasPedido, PedidoStatus.FINALIZADO, 3100.00, 8L, "01/02/2022 13:15");
		Pedido p23 = new Pedido(null, c2, roupasPedido, PedidoStatus.ABERTO, 2900.00, 9L, "05/02/2022 14:45");
		Pedido p24 = new Pedido(null, c3, roupasPedido, PedidoStatus.REJEITADO, 3300.00, 6L, "10/02/2022 16:00");
		Pedido p25 = new Pedido(null, c4, roupasPedido, PedidoStatus.CANCELADO, 2700.00, 7L, "15/02/2022 17:30");
		Pedido p26 = new Pedido(null, c1, roupasPedido, PedidoStatus.RECOLHIDO, 3100.00, 5L, "20/02/2022 18:45");
		Pedido p27 = new Pedido(null, c2, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 2900.00, 6L,
				"25/02/2022 20:00");
		Pedido p28 = new Pedido(null, c3, roupasPedido, PedidoStatus.PAGO, 2800.00, 8L, "01/03/2022 09:00");
		Pedido p29 = new Pedido(null, c4, roupasPedido, PedidoStatus.FINALIZADO, 3000.00, 7L, "05/03/2022 10:30");
		Pedido p30 = new Pedido(null, c1, roupasPedido, PedidoStatus.ABERTO, 3200.00, 9L, "10/03/2022 11:45");
		Pedido p31 = new Pedido(null, c2, roupasPedido, PedidoStatus.REJEITADO, 3100.00, 5L, "15/03/2022 13:15");
		Pedido p32 = new Pedido(null, c3, roupasPedido, PedidoStatus.CANCELADO, 2900.00, 6L, "20/03/2022 14:45");
		Pedido p33 = new Pedido(null, c4, roupasPedido, PedidoStatus.RECOLHIDO, 3300.00, 8L, "25/03/2022 16:00");
		Pedido p34 = new Pedido(null, c1, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 2700.00, 7L,
				"01/04/2022 17:30");
		Pedido p35 = new Pedido(null, c2, roupasPedido, PedidoStatus.PAGO, 3100.00, 5L, "05/04/2022 18:45");
		Pedido p36 = new Pedido(null, c3, roupasPedido, PedidoStatus.FINALIZADO, 2900.00, 6L, "10/04/2023 20:00");

		orderRepository.saveAll(Arrays.asList(p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
				p20, p21, p22, p23, p24, p25, p26, p27, p28, p29,
				p30, p31, p32, p33, p34, p35, p36));

		rp1.setPedido(p10);
		rp2.setPedido(p11);
		rp3.setPedido(p12);
		rp4.setPedido(p13);
		rp5.setPedido(p14);
		rp6.setPedido(p15);
		rp7.setPedido(p16);
		rp8.setPedido(p17);
		rp9.setPedido(p18);
		rp10.setPedido(p19);
		rp11.setPedido(p20);
		rp12.setPedido(p21);
		rp13.setPedido(p22);
		rp14.setPedido(p23);
		rp15.setPedido(p24);
		rp16.setPedido(p25);
		rp17.setPedido(p26);
		rp18.setPedido(p27);
		rp19.setPedido(p28);
		rp20.setPedido(p29);

		clothesOrderRepository.saveAll(Arrays.asList(rp1, rp2, rp3, rp4, rp5, rp6, rp7, rp8, rp9, rp10,
				rp11, rp12, rp13, rp14, rp15, rp16, rp17, rp18, rp19, rp20));

	}

}
