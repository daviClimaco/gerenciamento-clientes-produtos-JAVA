package daviclimaco.gerenciamentoClientesProdutos.services;

import daviclimaco.gerenciamentoClientesProdutos.entity.Cliente;
import daviclimaco.gerenciamentoClientesProdutos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {

    private ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente atualizar(Long id, Cliente cliente){
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
}