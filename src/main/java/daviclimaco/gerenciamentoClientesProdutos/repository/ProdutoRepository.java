package daviclimaco.gerenciamentoClientesProdutos.repository;

import daviclimaco.gerenciamentoClientesProdutos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}