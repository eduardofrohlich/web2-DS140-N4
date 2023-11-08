package backend.lavanderia.relatorio.dto;

import java.io.Serializable;

public class RelatorioClienteFielDTO implements Serializable{
	
	private static final long serialVersionUID = 754679730318252512L;
	
	private int count;
	private String nome;
	private double sum;
	
	public RelatorioClienteFielDTO() {
		super();
	}
	public RelatorioClienteFielDTO(String nome, int count, double sum) {
		super();
		this.count = count;
		this.nome = nome;
		this.sum = sum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}

