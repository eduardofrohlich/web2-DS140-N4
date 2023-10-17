package backend.lavanderia.pedido.directive;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import backend.lavanderia.pedido.dto.PedidoDTO;
import backend.lavanderia.pedido.entity.enums.PedidoStatus;
import backend.lavanderia.pedido.service.OrderStatus;
import backend.lavanderia.usuario.directive.ValidaUsuario;

// Essa diretiva se tornou obsoleta uma vez que o JSON ficou simples
public class ValidaPedido 
{
	public static void pedido(PedidoDTO pedido) throws RuntimeException
	{
		ValidaUsuario.usuario(pedido.getCliente());

		if(pedido.getRoupas().isEmpty())
			throw new RuntimeException("O pedido deve conter ao menos 1 roupa!");
		
		for(int i = 0; i < pedido.getRoupas().size(); i++)
			ValidaRoupa.roupa(pedido.getRoupas().get(i).getRoupa());
		
		if(pedido.getPrazoEntrega() < 0)
			throw new RuntimeException("O prazo de entrega deve ser positivo!");
		
		LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        pedido.setDataHora(dataHora.format(formato));
	}
	
	// A data e a hora é gerada no back, não precisa validar!
	/*
	private static void validaDataHora(String dataHora) throws RuntimeException
	{
		validaData(dataHora.substring(0, 10));
		validaHora(dataHora.substring(10));
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
	
	private static void validaHora(String hora) throws RuntimeException
	{
		char[] auxHora = hora.toCharArray();
		
		int h = 0, m = 0;
		
		if(auxHora[2] != ':')
			throw new RuntimeException("A hora deve estar no formato 00:00");
		
		try {
			h = ((auxHora[0] - '0') * 10) + (auxHora[1] - '0');
			m = ((auxHora[3] - '0') * 10) + (auxHora[4] - '0');
		}
		catch(NumberFormatException e) {
			throw new RuntimeException("A hora deve conter somente números no formato: 00:00");
		}
		
		if(h > 23)
			throw new RuntimeException("A hora deve ser menor que 24!");
		
		if(m > 59)
			throw new RuntimeException("O minuto deve ser menor que 60!");
	}
	*/
}
