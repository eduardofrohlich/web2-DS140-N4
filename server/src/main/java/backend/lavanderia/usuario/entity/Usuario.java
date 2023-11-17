package backend.lavanderia.usuario.entity;

import java.io.Serializable;
import java.util.Objects;

import backend.lavanderia.usuario.cargos.CargosUsuario;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String endereco;
	private String senha;
	private String email;
	private String nome;
	private String cpf;
	private String telefone;
	private Integer perfil;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String endereco, String senha, String email, String nome, String cpf,
			String telefone, CargosUsuario perfil) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		setPerfil(perfil);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
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

	public CargosUsuario getPerfil() {
		return CargosUsuario.valueOf(perfil);
	}

	public void setPerfil(CargosUsuario perfil) {
		if(perfil != null) {
			this.perfil = perfil.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
