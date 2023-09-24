package backend.lavanderia.pedido.service;

public class OrderStatus 
{
	public static String getStatusString(Long statusCode) throws RuntimeException
	{
		if(statusCode == 1L)
			return "ABERTO";
		
		else if(statusCode == 2L)
			return "REJEITADO";
		
		else if(statusCode == 3L)
			return "CANCELADO";
		
		else if(statusCode == 4L)
			return "RECOLHIDO";
		
		else if(statusCode == 5L)
			return "AGUARDANDO PAGAMENTO";
		
		else if(statusCode == 6L)
			return "PAGO";
		
		else if(statusCode == 7L)
			return "FINALIZADO";
		
		throw new RuntimeException("Não existe estado com esse valor!");
	}
	
	public static Long getStatusCode(String status) throws RuntimeException
	{
		if(status.equalsIgnoreCase("aberto"))
			return 1L;
		
		else if(status.equalsIgnoreCase("rejeitado"))
			return 2L;
		
		else if(status.equalsIgnoreCase("cancelado"))
			return 3L;
		
		else if(status.equalsIgnoreCase("recolhido"))
			return 4L;
		
		else if(status.equalsIgnoreCase("aguardando pagamento"))
			return 5L;
		
		else if(status.equalsIgnoreCase("pago"))
			return 6L;
		
		else if(status.equalsIgnoreCase("finalizado"))
			return 7L;
		
		throw new RuntimeException("Não existe estado com esse nome!");
	}
}
