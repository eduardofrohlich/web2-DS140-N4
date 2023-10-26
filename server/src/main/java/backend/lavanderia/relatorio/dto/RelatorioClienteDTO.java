package backend.lavanderia.relatorio.dto;

import java.io.Serializable;

public class RelatorioClienteDTO implements Serializable{

	private static final long serialVersionUID = 6389936075778360766L;
	
	private String endereco;
	private String email;
	private String nome;
	private String cpf;
	private String telefone;
	
	public RelatorioClienteDTO() {
		super();
	}

	
	public RelatorioClienteDTO(String endereco, String email, String nome, String cpf, String telefone) {
		super();
		this.endereco = endereco;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
