package backend.lavanderia.usuario.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable
{
	private static final long serialVersionUID = -6411715904609095531L;
	
	private int idCliente;
	private EnderecoDTO endereco;
	private int senha;
	private String email;
	private String nome;
	private String cpf;
	private String telefone;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(int idCliente, EnderecoDTO endereco, int senha, String email, String nome, String cpf, String telefone) {
		super();
		this.idCliente = idCliente;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
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
}