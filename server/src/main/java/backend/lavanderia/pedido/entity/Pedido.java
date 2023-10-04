package backend.lavanderia.pedido.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import backend.lavanderia.usuario.entity.Cliente;

import jakarta.persistence.*;


@Entity
@Table(name="Pedido")
public class Pedido implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedido_idpedido_seq")
	@SequenceGenerator(name="pedido_idpedido_seq", allocationSize=1)
	private Long idPedido;
	
	@OneToOne
	@JoinColumn(name="FK_idCliente", referencedColumnName="idCliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", fetch=FetchType.EAGER)
	private List<RoupasPedido> roupas;
	
	@Column(name="estado")
	private Long estado;
	
	@Column(name="valorTotal")
	private Double valorTotal;
	
	@Column(name="prazoEntrega")
	private Long prazoEntrega;
	
	@Column(name="dataHora")
	private String dataHora;

	public Pedido() {
		super();
	}

	public Pedido(Long idPedido, Cliente cliente, List<RoupasPedido> roupas, Long estado, Double valorTotal, Long prazoEntrega, String dataHora) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.roupas = roupas;
		this.estado = estado;
		this.valorTotal = valorTotal;
		this.prazoEntrega = prazoEntrega;
		this.dataHora = dataHora;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<RoupasPedido> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<RoupasPedido> roupas) {
		this.roupas = roupas;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Long prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataHora, estado, idPedido, prazoEntrega, roupas, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataHora, other.dataHora)
				&& Objects.equals(estado, other.estado) && Objects.equals(idPedido, other.idPedido)
				&& Objects.equals(prazoEntrega, other.prazoEntrega) && Objects.equals(roupas, other.roupas)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
}
