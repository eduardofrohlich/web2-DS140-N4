package backend.lavanderia.usuario.repository;

import backend.lavanderia.usuario.entity.Cliente;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
	public Optional<Cliente> findByCpf(@Param("cpf") String cpf);
	public Optional<Cliente> findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
	public Long countByEndereco(@Param("endereco") String endereco);
}