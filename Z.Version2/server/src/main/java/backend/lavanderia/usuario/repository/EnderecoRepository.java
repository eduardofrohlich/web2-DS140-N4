package backend.lavanderia.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import backend.lavanderia.usuario.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>
{
	public Optional<Endereco> findByCepAndNumero(@Param("cep") String cep, @Param("numero") Long numero);
}