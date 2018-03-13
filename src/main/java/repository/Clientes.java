package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;

import model.Cliente;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 7386295110529447342L;
	
	@Inject
	private EntityManager manager;
	Criteria criteria = null;
	
	
	public Cliente porCli_codigo(Long cli_codigo) {
		return manager.find(Cliente.class, cli_codigo);
	}
	
	public List<Cliente> todos() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}
	
	public Cliente guardar(Cliente cliente) {
		return manager.merge(cliente);
	}
	
	public void remover(Cliente cliente) {
		cliente = porCli_codigo(cliente.getCli_codigo());
		manager.remove(cliente);
	}

}
