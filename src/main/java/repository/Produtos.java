package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Fabricante;
import model.Produto;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 2286842432164578704L;

	@Inject
	private EntityManager manager;

	public Produto porPro_codigo(Long pro_codigo) {
		return manager.find(Produto.class, pro_codigo);
	}

	public List<Produto> todos() {
		return manager.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public void remover(Produto produto) {
		produto = porPro_codigo(produto.getPro_codigo());
		manager.remove(produto);
	}

	public List<Produto> todosPorFab(Long fab) {
		Fabricante fabricante = (Fabricante) manager.find(Fabricante.class, fab);
		System.out.println("Fabrcante: " + fabricante.getNomeFabricante());
		for (Produto produto : fabricante.getProdutos()) {
			System.out.println("Produto: " + produto.getPro_nome());
		}
		return fabricante.getProdutos();
	}

}
