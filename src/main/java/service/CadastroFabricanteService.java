package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Fabricante;
import repository.Fabricantes;
import util.Transacional;

public class CadastroFabricanteService implements Serializable {

	private static final long serialVersionUID = 6200048094655546343L;
	
	@Inject
	private Fabricantes fabricantes;
	
	@Transacional
	public void salvar(Fabricante fabricante) {
		fabricantes.guardar(fabricante);
	}
	
	@Transacional
	public void excluir(Fabricante fabricante) {
		fabricantes.remover(fabricante);
	}

}
