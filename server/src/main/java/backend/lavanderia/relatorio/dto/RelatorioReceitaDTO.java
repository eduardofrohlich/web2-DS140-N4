package backend.lavanderia.relatorio.dto;

import java.io.Serializable;

public class RelatorioReceitaDTO implements Serializable{
	
	private static final long serialVersionUID = -8320953925874466306L;
	
	private String dia;
	private int quantidadePedidos;
	private double receita;
	
	public RelatorioReceitaDTO() {
		super();
	}
	
	public RelatorioReceitaDTO(String dia, int quantidadePedidos, double receita) {
		super();
		this.dia = dia;
		this.quantidadePedidos = quantidadePedidos;
		this.receita = receita;
	}
	
	public String getDia() {
		return dia;
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public int getQuantidadePedidos() {
		return quantidadePedidos;
	}
	
	public void setQuantidadePedidos(int quantidadePedidos) {
		this.quantidadePedidos = quantidadePedidos;
	}
	
	public double getReceita() {
		return receita;
	}
	
	public void setReceita(double receita) {
		this.receita = receita;
	}

}
