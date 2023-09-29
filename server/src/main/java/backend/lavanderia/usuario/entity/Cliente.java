package backend.lavanderia.usuario.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name="Cliente")
public class Cliente implements Serializable
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_idcliente_seq")
	@SequenceGenerator(name="cliente_idcliente_seq", allocationSize=1)
	@Column(name="idCliente")
	private Long idCliente;
	
	@OneToOne //(cascade = CascadeType.ALL) <-- Sobreescreve a tabela endereço.
	@JoinColumn(name="FK_idEndereco", referencedColumnName="idEndereco")
	private Endereco endereco;
	
	@Column(name="senha")
	private Long senha;
	
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="cpf", length=11)
	private String cpf;
	
	@Column(name="telefone", length=9)
	private String telefone;

	public Cliente() {
		super();
	}

	public Cliente(Long idCliente, Endereco endereco, Long senha, String email, String nome, String cpf, String telefone) {
		super();
		this.idCliente = idCliente;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getSenha() {
		return senha;
	}

	public void setSenha(Long senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, endereco, idCliente, nome, senha, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone);
	}
}
