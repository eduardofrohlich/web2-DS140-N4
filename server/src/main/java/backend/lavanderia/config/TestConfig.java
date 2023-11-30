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

		Pedido p10 = new Pedido(null, c1, roupasPedido, PedidoStatus.REJEITADO, 28.00, 6L, "01/11/2023 09:00");
		Pedido p11 = new Pedido(null, c2, roupasPedido, PedidoStatus.CANCELADO, 30.00, 7L, "09/09/2023 10:30");
		Pedido p12 = new Pedido(null, c3, roupasPedido, PedidoStatus.RECOLHIDO, 32.00, 5L, "02/10/2023 11:45");
		Pedido p13 = new Pedido(null, c4, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 31.00, 8L,
				"12/10/2023 13:15");
		Pedido p14 = new Pedido(null, c1, roupasPedido, PedidoStatus.PAGO, 29.00, 9L, "02/09/2023 14:45");
		Pedido p15 = new Pedido(null, c2, roupasPedido, PedidoStatus.FINALIZADO, 33.00, 6L, "08/10/2023 16:00");
		Pedido p16 = new Pedido(null, c3, roupasPedido, PedidoStatus.ABERTO, 27.00, 7L, "10/08/2023 17:30");
		Pedido p17 = new Pedido(null, c4, roupasPedido, PedidoStatus.REJEITADO, 31.00, 5L, "09/10/2023 18:45");
		Pedido p18 = new Pedido(null, c1, roupasPedido, PedidoStatus.CANCELADO, 29.00, 6L, "04/08/2023 20:00");
		Pedido p19 = new Pedido(null, c2, roupasPedido, PedidoStatus.RECOLHIDO, 28.00, 8L, "10/08/2023 09:00");
		Pedido p20 = new Pedido(null, c3, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 30.00, 7L,
				"02/11/2023 10:30");
		Pedido p21 = new Pedido(null, c4, roupasPedido, PedidoStatus.PAGO, 32.00, 5L, "02/11/2023 11:45");
		Pedido p22 = new Pedido(null, c1, roupasPedido, PedidoStatus.FINALIZADO, 31.00, 8L, "01/09/2023 13:15");
		Pedido p23 = new Pedido(null, c2, roupasPedido, PedidoStatus.ABERTO, 29.00, 9L, "03/10/2023 14:45");
		Pedido p24 = new Pedido(null, c3, roupasPedido, PedidoStatus.REJEITADO, 33.00, 6L, "18/10/2023 16:00");
		Pedido p25 = new Pedido(null, c4, roupasPedido, PedidoStatus.CANCELADO, 27.00, 7L, "13/09/2023 17:30");
		Pedido p26 = new Pedido(null, c1, roupasPedido, PedidoStatus.RECOLHIDO, 31.00, 5L, "29/11/2023 18:45");
		Pedido p27 = new Pedido(null, c2, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 29.00, 6L,
				"10/09/2023 20:00");
		Pedido p28 = new Pedido(null, c3, roupasPedido, PedidoStatus.PAGO, 28.00, 8L, "29/10/2023 09:00");
		Pedido p29 = new Pedido(null, c4, roupasPedido, PedidoStatus.FINALIZADO, 30.00, 7L, "21/10/2023 10:30");
		Pedido p30 = new Pedido(null, c1, roupasPedido, PedidoStatus.ABERTO, 32.00, 9L, "02/11/2023 11:45");
		Pedido p31 = new Pedido(null, c2, roupasPedido, PedidoStatus.REJEITADO, 31.00, 5L, "18/09/2023 13:15");
		Pedido p32 = new Pedido(null, c3, roupasPedido, PedidoStatus.CANCELADO, 29.00, 6L, "20/08/2023 14:45");
		Pedido p33 = new Pedido(null, c4, roupasPedido, PedidoStatus.RECOLHIDO, 33.00, 8L, "16/11/2023 16:00");
		Pedido p34 = new Pedido(null, c1, roupasPedido, PedidoStatus.AGUARDANDO_PAGAMENTO, 27.00, 7L,
				"11/08/2023 17:30");
		Pedido p35 = new Pedido(null, c2, roupasPedido, PedidoStatus.PAGO, 31.00, 5L, "01/11/2023 18:45");
		Pedido p36 = new Pedido(null, c3, roupasPedido, PedidoStatus.FINALIZADO, 29.00, 6L, "05/10/2023 20:00");
		Pedido p37 = new Pedido(null, c3, roupasPedido, PedidoStatus.ABERTO, 27.00, 7L, "24/11/2023 17:30");

		Pedido p38 = new Pedido(null, c4, roupasPedido, PedidoStatus.ABERTO, 31.00, 5L, "13/09/2023 18:45");
		Pedido p39 = new Pedido(null, c1, roupasPedido, PedidoStatus.ABERTO, 29.00, 6L, "22/10/2023 20:00");
		Pedido p40 = new Pedido(null, c2, roupasPedido, PedidoStatus.ABERTO, 28.00, 8L, "17/08/2023 09:00");
		Pedido p41 = new Pedido(null, c3, roupasPedido, PedidoStatus.ABERTO, 30.00, 7L, "12/09/2023 10:30");
		Pedido p42 = new Pedido(null, c4, roupasPedido, PedidoStatus.ABERTO, 32.00, 5L, "06/09/2023 11:45");
		Pedido p43 = new Pedido(null, c1, roupasPedido, PedidoStatus.ABERTO, 31.00, 8L, "22/10/2023 13:15");


		orderRepository.saveAll(Arrays.asList(p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
				p20, p21, p22, p23, p24, p25, p26, p27, p28, p29,
				p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43));

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
