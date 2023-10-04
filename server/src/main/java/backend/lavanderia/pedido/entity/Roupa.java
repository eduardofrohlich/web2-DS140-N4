package backend.lavanderia.pedido.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name="Roupa")
public class Roupa implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roupa_idroupa_seq")
	@SequenceGenerator(name="roupa_idroupa_seq", allocationSize=1)
	private Long idRoupa;
	
	@Column(name="nomeRoupa")
	private String nomeRoupa;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="prazo")
	private Long prazo;
	
	@Column(name="imagem")
	private String imagem;

	public Roupa() {
		super();
	}

	public Roupa(Long idRoupa, String nomeRoupa, Double valor, Long prazo, String imagem) {
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

	public Long getPrazo() {
		return prazo;
	}

	public void setPrazo(Long prazo) {
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
		return Objects.hash(idRoupa, imagem, nomeRoupa, prazo, valor);
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
		return Objects.equals(idRoupa, other.idRoupa) && Objects.equals(imagem, other.imagem)
				&& Objects.equals(nomeRoupa, other.nomeRoupa) && Objects.equals(prazo, other.prazo)
				&& Objects.equals(valor, other.valor);
	}
}
