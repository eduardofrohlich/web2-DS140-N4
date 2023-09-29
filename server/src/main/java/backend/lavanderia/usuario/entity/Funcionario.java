package backend.lavanderia.usuario.entity;

import java.io.Serializable;
import backend.lavanderia.usuario.entity.Endereco;
import jakarta.persistence.*;


@Entity
@Table(name="Funcionario")
public class Funcionario implements Serializable
{

	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="funcionario_idfuncionario_seq")
	@SequenceGenerator(name="funcionario_idfuncionario_seq", allocationSize=1)
	private Long idFuncionario;
	
	@OneToOne //(cascade = CascadeType.ALL)
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
	
	@Column(name="dataNascimento", length=10)
	private String dataNascimento;

	public Funcionario() {
		super();
	}

	public Funcionario(Long idFuncionario, Endereco endereco, Long senha, String email, String nome, String cpf,
			String telefone, String dataNascimento) {
		super();
		this.idFuncionario = idFuncionario;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
