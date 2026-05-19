package daviclimaco.gerenciamentoClientesProdutos.services;

import daviclimaco.gerenciamentoClientesProdutos.entity.Cliente;
import daviclimaco.gerenciamentoClientesProdutos.entity.Produto;
import daviclimaco.gerenciamentoClientesProdutos.repository.ClienteRepository;
import daviclimaco.gerenciamentoClientesProdutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServices {

    private ProdutoRepository produtoRepository;
    private ClienteRepository clienteRepository;

    public ProdutoServices(
            ProdutoRepository produtoRepository,
            ClienteRepository clienteRepository
    ) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Produto salvar(Long clienteId, Produto produto) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        produto.setCliente(cliente);

        return produtoRepository.save(produto);
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(Long id, Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }
}