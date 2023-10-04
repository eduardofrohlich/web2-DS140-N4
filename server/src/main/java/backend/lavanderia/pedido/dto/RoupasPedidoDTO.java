package backend.lavanderia.pedido.dto;

import java.io.Serializable;

public class RoupasPedidoDTO implements Serializable
{
	private RoupaDTO roupa;
	private int qtdRoupa;
	private double valorTotalRoupa;
	
	public RoupasPedidoDTO() {
		super();
	}

	public RoupasPedidoDTO(RoupaDTO roupa, int qtdRoupa, double valorTotalRoupa) {
		super();
		this.roupa = roupa;
		this.qtdRoupa = qtdRoupa;
		this.valorTotalRoupa = valorTotalRoupa;
	}

	public RoupaDTO getRoupa() {
		return roupa;
	}

	public void setRoupa(RoupaDTO roupa) {
		this.roupa = roupa;
	}

	public int getQtdRoupa() {
		return qtdRoupa;
	}

	public void setQtdRoupa(int qtdRoupa) {
		this.qtdRoupa = qtdRoupa;
	}

	public double getValorTotalRoupa() {
		return valorTotalRoupa;
	}

	public void setValorTotalRoupa(double valorTotalRoupa) {
		this.valorTotalRoupa = valorTotalRoupa;
	}
}
