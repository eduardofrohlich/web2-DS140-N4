package backend.lavanderia.pedido.dto;

import java.io.Serializable;
import java.util.List;

import backend.lavanderia.pedido.entity.enums.PedidoStatus;
import backend.lavanderia.usuario.dto.ClienteDTO;

public class PedidoDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private ClienteDTO cliente;
	private List<RoupasPedidoDTO> roupas; 
	private Integer pedidoStatus;
	private double valorTotal;
	private int prazoEntrega;
	private String dataHora;
	
	public PedidoDTO() {
		super();
	}

	public PedidoDTO(int idPedido, ClienteDTO cliente, List<RoupasPedidoDTO> roupas, PedidoStatus pedidoStatus, double valorTotal, int prazoEntrega, String dataHora) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.roupas = roupas;
		setPedidoStatus(pedidoStatus);
		this.valorTotal = valorTotal;
		this.prazoEntrega = prazoEntrega;
		this.dataHora = dataHora;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCode();
		}
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<RoupasPedidoDTO> getRoupas() {
		return roupas;
	}

	public void setRoupas(List<RoupasPedidoDTO> roupas) {
		this.roupas = roupas;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
}