package backend.lavanderia.usuario.dto;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable
{
	private int idFuncionario;
	private EnderecoDTO endereco;
	private String senha;
	private String email;
	private String nome;
	private String cpf;
	private String telefone;
	private String dataNascimento;
	
	public FuncionarioDTO() {
		super();
	}

	public FuncionarioDTO(int idFuncionario, EnderecoDTO endereco, String senha, String email, String nome, String cpf, String telefone, String dataNascimento) {
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

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
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