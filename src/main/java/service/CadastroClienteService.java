package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Cliente;
import repository.Clientes;
import util.Transacional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = -3073264497065270826L;
	
	@Inject
	private Clientes clientes;
	
	@Transacional
	public void salvar(Cliente cliente) {
		clientes.guardar(cliente);
	}
	
	@Transacional
	public void excluir(Cliente cliente) {
		clientes.remover(cliente);
	}

	

}
