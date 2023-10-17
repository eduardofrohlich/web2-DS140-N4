package backend.lavanderia.usuario.directive;

import backend.lavanderia.usuario.dto.ClienteDTO;
import backend.lavanderia.usuario.dto.FuncionarioDTO;
import backend.lavanderia.usuario.entity.Cliente;

public class ValidaUsuario
{
	public static void usuario(ClienteDTO cliente) throws RuntimeException
	{
		
		if(cliente.getSenha().length() < 4)
			throw new RuntimeException("A senha deve conter 4 dígitos!");
		
		if(cliente.getEmail().length() > 50)
			throw new RuntimeException("O email deve conter menos de 50 caracteres!");
		
		if(cliente.getNome().length() > 100)
			throw new RuntimeException("O nome deve conter menos de 100 caracteres!");
		
		if(cliente.getCpf().length() != 11)
			throw new RuntimeException("O CPF deve conter 11 dígitos!");
		
		validaCpf(cliente.getCpf());
		
		if(cliente.getTelefone().length() < 8 || cliente.getTelefone().length() > 9)
			throw new RuntimeException("O telefone deve ter menos de 9 caracteres e mais de 8 caracteres!");
		
		try {
			int converteNumero = Integer.parseInt(cliente.getTelefone());
		}
		catch(NumberFormatException e) {
			throw new RuntimeException("O telefone deve conter somente números!");
		}
	}
	
	public static void usuario(FuncionarioDTO funcionario) throws RuntimeException
	{
		
		if(funcionario.getSenha().length() != 4)
			throw new RuntimeException("A senha deve conter 4 dígitos!");
		
		if(funcionario.getEmail().length() > 50)
			throw new RuntimeException("O email deve conter menos de 50 caracteres!");
		
		if(funcionario.getNome().length() > 100)
			throw new RuntimeException("O nome deve conter menos de 100 caracteres!");
		
		if(funcionario.getDataNascimento().length() != 10)
			throw new RuntimeException("A data deve estar no formato: 00/00/0000");
		
		validaData(funcionario.getDataNascimento());
		
		if(funcionario.getCpf().length() != 11)
			throw new RuntimeException("O CPF deve conter 11 dígitos!");
		
		validaCpf(funcionario.getCpf());
		
		if(funcionario.getTelefone().length() < 8 || funcionario.getTelefone().length() > 9)
			throw new RuntimeException("O telefone deve ter menos de 9 caracteres e mais de 7 caracteres!");
		
		try {
			int converteNumero = Integer.parseInt(funcionario.getTelefone());
		}
		catch(NumberFormatException e) {
			throw new RuntimeException("O telefone deve conter somente números!");
		}
	}
	
	private static void validaCpf(String cpf) throws RuntimeException
	{
		try {
			Long converteNumero = Long.valueOf(cpf);
		}
		catch(NumberFormatException e) {
			throw new RuntimeException("O CPF deve conter somente números!");
		}
		
		char[] auxCpf = cpf.toCharArray();
		
		int somaDigitos = (10 * (auxCpf[0] - '0')) + (9 * (auxCpf[1] - '0')) + (8 * (auxCpf[2] - '0')) + (7 * (auxCpf[3] - '0')) + (6 * (auxCpf[4] - '0')) + (5 * (auxCpf[5] - '0')) + (4 * (auxCpf[6] - '0')) + (3 * (auxCpf[7] - '0')) + (2 * (auxCpf[8] - '0'));
        int validaPrimeiroDigito = somaDigitos * 10 % 11;
		
		if(validaPrimeiroDigito == 10)
			validaPrimeiroDigito = 0;
		
		if(validaPrimeiroDigito != auxCpf[9] - '0')
			throw new RuntimeException("O CPF é inválido!");
		
		somaDigitos = (11 * (auxCpf[0] - '0')) + (10 * (auxCpf[1] - '0')) + (9 * (auxCpf[2] - '0')) + (8 * (auxCpf[3] - '0')) + (7 * (auxCpf[4] - '0')) + (6 * (auxCpf[5] - '0')) + (5 * (auxCpf[6] - '0')) + (4 * (auxCpf[7] - '0')) + (3 * (auxCpf[8] - '0')) + (2 * validaPrimeiroDigito);
		int validaSegundoDigito = somaDigitos * 10 % 11;
		
		if(validaSegundoDigito == 10)
			validaSegundoDigito = 0;
		
		if(validaSegundoDigito != auxCpf[10] - '0')
			throw new RuntimeException("O CPF é inválido!");
	}
	
	private static void validaData(String data) throws RuntimeException
	{
		char[] auxData = data.toCharArray();
		
		if(auxData[2] != '/' || auxData[5] != '/')
			throw new RuntimeException("A data deve estar no formato: 00/00/0000");
		
		Long converteNumero = 0L;
		
		try {
            auxData[2] = '0';
            auxData[5] = '0';
			converteNumero = Long.valueOf((String.valueOf(auxData)));
            
		}
		catch(NumberFormatException e)
		{
			throw new RuntimeException("A data deve conter somente números no formato: 00/00/0000");
		}

        int dia = ((auxData[0] - '0') * 10 ) + (auxData[1] - '0');
        int mes = ((auxData[3] - '0') * 10) + (auxData[4] - '0');
		
		if(dia > 31)
			throw new RuntimeException("O dia deve ser menor que 31!");
		
		if(mes > 12)
			throw new RuntimeException("O mês deve ser menor que 12!");
		
		if(auxData[6] - '0' < 2)
			throw new RuntimeException("O ano deve ser maior que 2000!");
	}
}