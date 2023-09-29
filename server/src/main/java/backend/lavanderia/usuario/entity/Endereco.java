package backend.lavanderia.usuario.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name="Endereco")
public class Endereco implements Serializable
{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="endereco_idendereco_seq")
	@SequenceGenerator(name="endereco_idendereco_seq", allocationSize=1)
	@Column(name="idEndereco")
	private Long idEndereco;
	
	@Column(name="estado", length=2)
	private String estado;
	
	@Column(name="cidade", length=30)
	private String cidade;
	
	@Column(name="cep", length= 8)
	private String cep;
	
	@Column(name="rua", length=50)
	private String rua;
	
	@Column(name="numero")
	private Long numero;
	
	@Column(name="bairro", length=20)
	private String bairro;

	public Endereco() {
		super();
	}

	public Endereco(Long idEndereco, String estado, String cidade, String cep, String rua, Long numero, String bairro) {
		super();
		this.idEndereco = idEndereco;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, estado, idEndereco, numero, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(estado, other.estado)
				&& Objects.equals(idEndereco, other.idEndereco) && Objects.equals(numero, other.numero)
				&& Objects.equals(rua, other.rua);
	}
}