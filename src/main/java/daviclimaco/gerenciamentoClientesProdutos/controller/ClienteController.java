package daviclimaco.gerenciamentoClientesProdutos.controller;

import daviclimaco.gerenciamentoClientesProdutos.entity.Cliente;
import daviclimaco.gerenciamentoClientesProdutos.services.ClienteServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private ClienteServices clienteServices;

    public ClienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){

        Cliente requeste = clienteServices.salvar(cliente);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        clienteServices.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){

        List<Cliente> requeste = clienteServices.buscarTodos();

        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Cliente buscarPorId(@PathVariable Long id){

        return clienteServices.buscarClientePorId(id);
    }

    @PutMapping("{id}")
    public Cliente atualizar(
            @PathVariable Long id,
            @RequestBody Cliente cliente
    ){

        return clienteServices.atualizar(id, cliente);
    }
}