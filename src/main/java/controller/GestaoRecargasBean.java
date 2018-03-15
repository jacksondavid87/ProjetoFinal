package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import model.Cliente;
import model.Fabricante;
import model.Produto;
import model.Recarga;
import repository.Clientes;
import repository.Fabricantes;
import repository.Produtos;
import repository.Recargas;
import service.CadastroRecargaService;
import util.FacesMessages;

@Named
@SessionScoped
public class GestaoRecargasBean implements Serializable {

	private static final long serialVersionUID = 2695481771761785175L;
	
	@Inject
	private Recargas recargas;
	
	@Inject
	private Produtos produtos;
	
	@Inject
	private Fabricantes fabricantes;
	
	@Inject
	private Clientes clientes;
	
	@Inject
	private CadastroRecargaService cadastroRecarga;
	
	@Inject
	private FacesMessages messages;
	
	private List<Recarga> todasRecargas;
	private List<Produto> todosProdutos;
	private List<Fabricante> todosFabricantes;
	private List<Cliente> todosClientes;
	private Recarga recargaEdicao = new Recarga();
	private Recarga recargaSelecionada;
	
	public void prepararNovoCadastro() {
		recargaEdicao = new Recarga();
	}
	
	public void salvar() {
		cadastroRecarga.salvar(recargaEdicao);
		consultar();

		messages.info("Recarga salva com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:recargas-table"));
	}
	
	public void excluir() {
		cadastroRecarga.excluir(recargaSelecionada);
		recargaSelecionada = null;

		consultar();

		messages.info("Recarga excluída com sucesso!");
	}
	
	public void consultar() {
		todasRecargas = recargas.todas();
		System.out.println(todasRecargas.size());

	}
	
	public void consultarProduto() {
		System.out.println("Chegou!!!");
		System.out.println(recargaEdicao.getFabricante());
		//todosProdutos = produtos.todos();
		todosProdutos = produtos.todosPorFab(recargaEdicao.getFabricante().getId());
		//System.out.println(todosProdutos.size());

	}
	
	public void consultarFabricante() {
		todosFabricantes = fabricantes.todas();
		System.out.println(todosFabricantes.size());

	}
	
	public void consultarCliente() {
		todosClientes = clientes.todos();
		System.out.println(todosClientes.size());

	}

	public List<Recarga> getTodasRecargas() {
		return todasRecargas;
	}

	public List<Produto> getTodosProdutos() {
		return todosProdutos;
	}

	public List<Fabricante> getTodosFabricantes() {
		return todosFabricantes;
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}

	public Recarga getRecargaEdicao() {
		return recargaEdicao;
	}

	public void setRecargaEdicao(Recarga recargaEdicao) {
		this.recargaEdicao = recargaEdicao;
	}

	public Recarga getRecargaSelecionada() {
		return recargaSelecionada;
	}

	public void setRecargaSelecionada(Recarga recargaSelecionada) {
		this.recargaSelecionada = recargaSelecionada;
	}

	
}
