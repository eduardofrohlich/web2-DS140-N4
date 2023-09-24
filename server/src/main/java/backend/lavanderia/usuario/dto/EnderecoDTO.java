package backend.lavanderia.usuario.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable
{
	private int idEndereco;
	private String estado;
	private String cidade;
	private String cep;
	private String rua;
	private int numero;
	private String bairro;
	
	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(int idEndereco, String estado, String cidade, String cep, String rua, int numero, String bairro) {
		super();
		this.idEndereco = idEndereco;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}