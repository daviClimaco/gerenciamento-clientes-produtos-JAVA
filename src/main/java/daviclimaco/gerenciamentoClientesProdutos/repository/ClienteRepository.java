package daviclimaco.gerenciamentoClientesProdutos.repository;

import daviclimaco.gerenciamentoClientesProdutos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}