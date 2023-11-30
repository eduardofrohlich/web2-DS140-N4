package backend.lavanderia.pedido.entity.enums;

public enum PedidoStatus {
	ABERTO(1),
	REJEITADO(2),
	CANCELADO(3),
	RECOLHIDO(4),
	AGUARDANDO_PAGAMENTO(5),
	PAGO(6),
	FINALIZADO(7);
	
	private int code;

	private PedidoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código PedidoStatus inválido!");
	}
	
	public static PedidoStatus getFromString(String status) {
		switch (status) {
		case "ABERTO":
			return PedidoStatus.ABERTO;
		case "REJEITADO":
			return PedidoStatus.REJEITADO;
		case "CANCELADO":
			return PedidoStatus.CANCELADO;
		case "RECOLHIDO":
			return PedidoStatus.RECOLHIDO;
		case "AGUARDANDO_PAGAMENTO":
			return PedidoStatus.AGUARDANDO_PAGAMENTO;
		case "PAGO":
			return PedidoStatus.PAGO;
		case "FINALIZADO":
			return PedidoStatus.FINALIZADO;
		default:
			throw new IllegalArgumentException("Código PedidoStatus inválido!");
		}
	}
}
