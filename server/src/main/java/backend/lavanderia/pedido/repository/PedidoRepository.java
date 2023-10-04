package backend.lavanderia.pedido.repository;

import backend.lavanderia.pedido.entity.Pedido;

import org.springframework.data.jpa.repository.*;

public interface PedidoRepository extends JpaRepository<Pedido, Long>
{

}