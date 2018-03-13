package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import repository.Fabricantes;
import repository.Produtos;
import model.Fabricante;
import model.Produto;
import service.CadastroProdutoService;
import util.FacesMessages;

@Named
@ViewScoped
public class GestaoProdutosBean implements Serializable {

	private static final long serialVersionUID = -1684708105932957230L;
	
	@Inject
	private Produtos produtos;
	
	@Inject
	private Fabricantes fabricantes;
	
	@Inject
	private CadastroProdutoService cadastroProduto;
	
	@Inject
	private FacesMessages messages;
	
	private List<Produto> todosProdutos;
	private List<Fabricante> todosFabricantes;
	private Produto produtoEdicao = new Produto();
	private Produto produtoSelecionado;
	
	
	public void prepararNovoCadastro() {
		produtoEdicao = new Produto();
	}
	
	public void salvar() {
		System.out.println(produtoEdicao.getFabricante());
		cadastroProduto.salvar(produtoEdicao);
		consultar();

		messages.info("Produto salvo com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:produtos-table"));
	}
	
	public void excluir() {
		cadastroProduto.excluir(produtoSelecionado);
		produtoSelecionado = null;

		consultar();

		messages.info("Produto excluído com sucesso!");
	}
	
	public void consultar() {
		todosProdutos = produtos.todos();
		System.out.println(todosProdutos.size());

	}
	
	public void consultarFabricante() {
		todosFabricantes = fabricantes.todas();
		System.out.println(todosFabricantes.size());

	}

	public List<Fabricante> getTodosFabricantes() {
		return todosFabricantes;
	}

	public List<Produto> getTodosProdutos() {
		return todosProdutos;
	}

	public Produto getProdutoEdicao() {
		return produtoEdicao;
	}

	public void setProdutoEdicao(Produto produtoEdicao) {
		this.produtoEdicao = produtoEdicao;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	

}
