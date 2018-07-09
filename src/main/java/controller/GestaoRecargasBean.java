package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
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
	private Date data_inicio;
	private Date data_fim;

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
		todasRecargas = recargas.todas(null, null);
		System.out.println(todasRecargas.size());
		//RequestContext.getCurrentInstance().update(Arrays.asList("frm:recargas-table"));
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
	
	public void filtro() {
		System.out.println(getData_inicio());
		System.out.println(getData_fim());
		todasRecargas = recargas.todas(getData_inicio(), getData_fim());
		System.out.println(todasRecargas.size());
		//RequestContext.getCurrentInstance().update(Arrays.asList("frm:recargas-table"));

		
	}
	
	public void receber() {
		recargaSelecionada.setRec_pago("SIM");
		//System.out.println(recargaSelecionada.getRec_pago());
		cadastroRecarga.salvar(recargaSelecionada);
		consultar();
		recargaSelecionada = null;
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:recargas-table"));
		
		messages.info("Recarga Recebida!");
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

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	
}
