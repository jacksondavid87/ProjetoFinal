package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Recarga;
import repository.Recargas;
import util.Transacional;

public class CadastroRecargaService implements Serializable {

	private static final long serialVersionUID = 5636127335364637301L;
	
	@Inject
	private Recargas recargas;
	
	@Transacional
	public void salvar(Recarga recarga) {
		recargas.guardar(recarga);
	}
	
	@Transacional
	public void excluir(Recarga recarga) {
		recargas.remover(recarga);
	}	

}
