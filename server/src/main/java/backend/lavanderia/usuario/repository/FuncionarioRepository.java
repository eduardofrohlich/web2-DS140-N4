package backend.lavanderia.usuario.repository;

import backend.lavanderia.usuario.entity.Endereco;
import backend.lavanderia.usuario.entity.Funcionario;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
	public Optional<Funcionario> findByCpf(@Param("cpf") String cpf);
	public Optional<Funcionario> findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
	public Long countByEndereco(@Param("endereco") Endereco endereco);
}