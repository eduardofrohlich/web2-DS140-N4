package backend.lavanderia.pedido.repository;

import backend.lavanderia.pedido.entity.Roupa;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface RoupaRepository extends JpaRepository<Roupa, Long>
{
	Optional<Roupa> findByNomeRoupa(@Param("nomeRoupa") String nomeRoupa);
}