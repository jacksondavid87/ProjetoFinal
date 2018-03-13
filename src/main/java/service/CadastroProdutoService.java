package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Produto;
import repository.Produtos;
import util.Transacional;


public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 3415462833559483654L;
	
	@Inject
	private Produtos produtos;
	
	@Transacional
	public void salvar(Produto produto) {
		produtos.guardar(produto);
	}
	
	@Transacional
	public void excluir(Produto produto) {
		produtos.remover(produto);
	}
	

}
