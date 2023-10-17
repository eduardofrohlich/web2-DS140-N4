package backend.lavanderia.pedido.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name="Roupa")
public class Roupa implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRoupa;
	
	private String nomeRoupa;
	private Double valor;
	private Integer prazo;
	private String imagem;

	public Roupa() {
		super();
	}

	public Roupa(Long idRoupa, String nomeRoupa, Double valor, Integer prazo, String imagem) {
		super();
		this.idRoupa = idRoupa;
		this.nomeRoupa = nomeRoupa;
		this.valor = valor;
		this.prazo = prazo;
		this.imagem = imagem;
	}

	public Long getIdRoupa() {
		return idRoupa;
	}

	public void setIdRoupa(Long idRoupa) {
		this.idRoupa = idRoupa;
	}

	public String getNomeRoupa() {
		return nomeRoupa;
	}

	public void setNomeRoupa(String nomeRoupa) {
		this.nomeRoupa = nomeRoupa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRoupa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roupa other = (Roupa) obj;
		return Objects.equals(idRoupa, other.idRoupa);
	}

	
}
