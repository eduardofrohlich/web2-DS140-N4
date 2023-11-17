package backend.lavanderia.usuario.cargos;

public enum CargosUsuario {
	CLIENTE(1),
	FUNCIONARIO(2);
	
	private int code;

	private CargosUsuario(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static CargosUsuario valueOf(int code) {
		for (CargosUsuario value : CargosUsuario.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código PedidoStatus inválido!");
	}
}
