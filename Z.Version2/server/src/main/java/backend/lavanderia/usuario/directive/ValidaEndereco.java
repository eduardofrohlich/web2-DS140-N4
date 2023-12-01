package backend.lavanderia.usuario.directive;

import backend.lavanderia.usuario.dto.EnderecoDTO;

public class ValidaEndereco 
{
	public static void endereco(EnderecoDTO endereco) throws RuntimeException
	{
		if(endereco.getEstado().length() != 2)
			throw new RuntimeException("O estado deve conter 2 caracteres!");
		
		if(endereco.getCidade().length() > 30)
			throw new RuntimeException("A cidade deve conter menos de 30 caracteres");
	
		if(endereco.getRua().length() > 50)
			throw new RuntimeException("A rua deve conter menos de 50 caracteres");
		
		if(endereco.getBairro().length() > 20)
			throw new RuntimeException("O bairro deve conter menos de 20 caracteres");
		
		if(endereco.getCep().length() > 9)
			throw new RuntimeException("O CEP deve conter menos de 9 caracteres");
	}
}
