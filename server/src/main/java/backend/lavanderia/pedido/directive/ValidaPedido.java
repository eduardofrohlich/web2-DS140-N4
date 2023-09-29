package backend.lavanderia.pedido.directive;

import backend.lavanderia.pedido.dto.PedidoDTO;
import backend.lavanderia.usuario.directive.ValidaUsuario;

public class ValidaPedido {
	public static void pedido(PedidoDTO pedido) throws RuntimeException {
		ValidaUsuario.usuario(pedido.getCliente());

		/*
		 * Implementar validação do estado do pedido if(???) throw new
		 * RuntimeException("Estado do pedido inválido!");
		 */

		if (pedido.getValorTotal() < 0)
			throw new RuntimeException("O valor total deve ser positivo!");

		if (pedido.getPrazoEntrega() < 0)
			throw new RuntimeException("O prazo de entrega deve ser positivo!");

		validaDataHora(pedido.getDataHora());
	}

	private static void validaDataHora(String dataHora) throws RuntimeException {
		// Implementar
	}
}
