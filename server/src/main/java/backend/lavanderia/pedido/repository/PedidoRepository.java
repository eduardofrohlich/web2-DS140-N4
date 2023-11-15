package backend.lavanderia.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.lavanderia.pedido.entity.Pedido;
import backend.lavanderia.usuario.entity.Cliente;

public interface PedidoRepository extends JpaRepository<Pedido, Long>
{
    List<Pedido> findByCliente(@Param("cliente") Cliente cliente);
    List<Pedido> findByDataHoraContaining(String dataString);
}