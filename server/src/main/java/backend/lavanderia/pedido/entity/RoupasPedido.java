package backend.lavanderia.pedido.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@IdClass(RoupasPedidoKey.class)
@Table(name="RoupasPedido")
public class RoupasPedido implements Serializable
{
	@Id
	@ManyToOne
	@JoinColumn(name="FK_idPedido", referencedColumnName="idPedido")
	private Pedido pedido;
	
	@Id
	@OneToOne
	@JoinColumn(name="FK_idRoupa", referencedColumnName="idRoupa")
	private Roupa roupa;
	
	@Column(name="qtdRoupa")
	private Long qtdRoupa;
	
	@Column(name="valorTotalRoupa")
	private Double valorTotalRoupa;

	public RoupasPedido() {
		super();
	}

	public RoupasPedido(Pedido pedido, Roupa roupa, Long qtdRoupa, Double valorTotalRoupa) {
		super();
		this.pedido = pedido;
		this.roupa = roupa;
		this.qtdRoupa = qtdRoupa;
		this.valorTotalRoupa = valorTotalRoupa;
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

	public Long getQtdRoupa() {
		return qtdRoupa;
	}

	public void setQtdRoupa(Long qtdRoupa) {
		this.qtdRoupa = qtdRoupa;
	}

	public Double getValorTotalRoupa() {
		return valorTotalRoupa;
	}

	public void setValorTotalRoupa(Double valorTotalRoupa) {
		this.valorTotalRoupa = valorTotalRoupa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, qtdRoupa, roupa, valorTotalRoupa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoupasPedido other = (RoupasPedido) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(qtdRoupa, other.qtdRoupa)
				&& Objects.equals(roupa, other.roupa) && Objects.equals(valorTotalRoupa, other.valorTotalRoupa);
	}
}