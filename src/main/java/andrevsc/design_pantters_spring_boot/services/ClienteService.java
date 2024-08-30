package andrevsc.design_pantters_spring_boot.services;

import andrevsc.design_pantters_spring_boot.models.Cliente; 

public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);

}