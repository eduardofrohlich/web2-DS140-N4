package backend.lavanderia.pedido.entity;

import java.io.Serializable;
import java.util.Objects;


public class RoupasPedidoKey implements Serializable
{
	private Pedido pedido;
	private Roupa roupa;

	public RoupasPedidoKey() {
		super();
	}

	public RoupasPedidoKey(Pedido pedido, Roupa roupa) {
		super();
		this.pedido = pedido;
		this.roupa = roupa;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Roupa getRoupa() {
		return roupa;
	}

	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, roupa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoupasPedidoKey other = (RoupasPedidoKey) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(roupa, other.roupa);
	}
}
