package backend.lavanderia.usuario.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Criptografia 
{
	private static String salt = "123SALzinho321";
	
	public static String criptografarSenha(String senha)
	{
		String saltedSenha = senha + salt;
		
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Não foi possível gerar a Instância de MessageDigest!");
		}
		
		byte[] hash = digest.digest(saltedSenha.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		
		return encoded;
	}
}
