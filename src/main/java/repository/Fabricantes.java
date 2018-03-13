package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Fabricante;

public class Fabricantes implements Serializable {

	private static final long serialVersionUID = -4878926348280908914L;
	
	@Inject
	private EntityManager manager;
	
	public Fabricante porFab_codigo(Long fab_codigo) {
		return manager.find(Fabricante.class, fab_codigo);
	}
	
	public List<Fabricante> todas() {
		return manager.createQuery("from Fabricante", Fabricante.class).getResultList();
	}
	
	public Fabricante guardar(Fabricante fabricante) {
		return manager.merge(fabricante);
	}
	
	public void remover(Fabricante fabricante) {
		fabricante = porFab_codigo(fabricante.getFab_codigo());
		manager.remove(fabricante);
	}
	
	public List<Fabricante> listFab_codigo(Long fab_codigo) {
		return (List<Fabricante>) manager.find(Fabricante.class, fab_codigo);
	}

}
