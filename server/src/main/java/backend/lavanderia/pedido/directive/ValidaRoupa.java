package backend.lavanderia.pedido.directive;

import backend.lavanderia.pedido.dto.RoupaDTO;

public class ValidaRoupa {
	public static void roupa(RoupaDTO roupa) throws RuntimeException {
		if (roupa.getNomeRoupa().length() > 30)
			throw new RuntimeException("O nome da roupa deve ter menos de 30 caracteres!");

		if (roupa.getValor() < 0)
			throw new RuntimeException("O valor deve ser positivo!");

		if (roupa.getPrazo() < 0)
			throw new RuntimeException("O prazo deve ser positivo!");
	}
}
