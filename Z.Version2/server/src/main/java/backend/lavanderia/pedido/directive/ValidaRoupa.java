package backend.lavanderia.pedido.directive;

import backend.lavanderia.pedido.dto.RoupaDTO;
import org.apache.commons.io.FilenameUtils;

public class ValidaRoupa 
{
	public static void roupa(RoupaDTO roupa) throws RuntimeException
	{
		if(roupa.getNomeRoupa().length() > 30)
			throw new RuntimeException("O nome da roupa deve ter menos de 30 caracteres!");
		
		if(roupa.getValor() < 0)
			throw new RuntimeException("O valor deve ser positivo!");
		
		if(roupa.getPrazo() < 0)
			throw new RuntimeException("O prazo deve ser positivo!");
		
		if(roupa.getImagem().length() < 4)
			roupa.setImagem("default.png");
		else
			validaExtensao(roupa.getImagem());
	}
	
	private static void validaExtensao(String imagem) throws RuntimeException
	{
		String[] extensoes = new String[]{"png", "jpg", "jpeg"};
		boolean achou = false;
		
		for(int i = 0; i < extensoes.length; i++)
			if(FilenameUtils.getExtension(imagem).equalsIgnoreCase(extensoes[i]))
			{
				achou = true;
				break;
			}
		
		if(!achou)
			throw new RuntimeException("A extensão da imagem é inválida!");
	}
}
