package daviclimaco.gerenciamentoClientesProdutos.controller;

import daviclimaco.gerenciamentoClientesProdutos.entity.Produto;
import daviclimaco.gerenciamentoClientesProdutos.services.ProdutoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoServices produtoServices;

    public ProdutoController(ProdutoServices produtoServices) {
        this.produtoServices = produtoServices;
    }

    @PostMapping("/{clienteId}")
    public ResponseEntity<Produto> salvar(
            @PathVariable Long clienteId,
            @RequestBody Produto produto
    ) {

        Produto requeste = produtoServices.salvar(clienteId, produto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {

        List<Produto> requeste = produtoServices.buscarTodos();

        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable Long id) {

        return produtoServices.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        produtoServices.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public Produto atualizar(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {

        return produtoServices.atualizar(id, produto);
    }
}