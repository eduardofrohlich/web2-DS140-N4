package backend.lavanderia.pedido.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backend.lavanderia.pedido.entity.enums.PedidoStatus;
import backend.lavanderia.usuario.entity.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Pedido")
public class Pedido implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPedido;
	
	@OneToOne
	@JoinColumn(name="FK_idCliente", referencedColumnName="idCliente")
	private Cliente cliente;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pedido", fetch=FetchType.EAGER)
	private List<RoupasPedido> roupas;
	
	private Integer pedidoStatus;
	private Double valorTotal;
	private Long prazoEntrega;
	private String dataHora;

	public Pedido() {
	}

	public Pedido(Long idPedido, Cliente cliente, List<RoupasPedido> roupas, PedidoStatus pedidoStatus, Double valorTotal, Long prazoEntrega, String dataHora) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.roupas = roupas;
		setPedidoStatus(pedidoStatus);
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

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCode();
		}
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
		return Objects.hash(idPedido);
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
		return Objects.equals(idPedido, other.idPedido);
	}

	
}
