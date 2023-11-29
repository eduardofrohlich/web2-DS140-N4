package backend.lavanderia.pedido.repository;

import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.pedido.entity.RoupasPedido;

import org.springframework.data.jpa.repository.*;

public interface RoupasPedidoRepository extends JpaRepository<RoupasPedido, Pedido>
{
	
}
