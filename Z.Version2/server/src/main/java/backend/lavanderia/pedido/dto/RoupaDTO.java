package backend.lavanderia.pedido.dto;

import java.io.Serializable;

public class RoupaDTO implements Serializable
{
	private int idRoupa;
	private String nomeRoupa;
	private double valor;
	private int prazo;
	private String imagem;
	
	public RoupaDTO() {
		super();
	}

	public RoupaDTO(int idRoupa, String nomeRoupa, double valor, int prazo, String imagem) {
		super();
		this.idRoupa = idRoupa;
		this.nomeRoupa = nomeRoupa;
		this.valor = valor;
		this.prazo = prazo;
		this.imagem = imagem;
	}

	public int getIdRoupa() {
		return idRoupa;
	}

	public void setIdRoupa(int idRoupa) {
		this.idRoupa = idRoupa;
	}

	public String getNomeRoupa() {
		return nomeRoupa;
	}

	public void setNomeRoupa(String nomeRoupa) {
		this.nomeRoupa = nomeRoupa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}