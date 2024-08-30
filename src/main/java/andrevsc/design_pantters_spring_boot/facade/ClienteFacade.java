package andrevsc.design_pantters_spring_boot.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import andrevsc.design_pantters_spring_boot.models.Cliente;
import andrevsc.design_pantters_spring_boot.models.Endereco;
import andrevsc.design_pantters_spring_boot.services.ClienteService;
import andrevsc.design_pantters_spring_boot.services.ViaCepService;

@Component
public class ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ViaCepService viaCepService;

    public void cadastrarCliente(Cliente cliente) {
        // Consulta o endereço via CEP
        Endereco endereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
        cliente.setEndereco(endereco);

        // Salva o cliente no banco de dados
        clienteService.inserir(cliente);
    }

    public void atualizarCliente(Long id, Cliente cliente) {
        // Consulta o endereço via CEP
        Endereco endereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
        cliente.setEndereco(endereco);

        // Atualiza o cliente no banco de dados
        clienteService.atualizar(id, cliente);
    }

    public void deletarCliente(Long id) {
        // Deleta o cliente no banco de dados
        clienteService.deletar(id);
    }

    public Iterable<Cliente> buscarTodos() {
        // Busca todos os clientes no banco de dados
        return clienteService.buscarTodos();
    }

    public Cliente buscarPorId(Long id) {
        // Busca um cliente por ID no banco de dados
        return clienteService.buscarPorId(id);
    }

    
}
