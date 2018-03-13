package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import model.Fabricante;
import repository.Fabricantes;
import service.CadastroFabricanteService;
import util.FacesMessages;

@Named
@ViewScoped
public class GestaoFabricantesBean implements Serializable {

	private static final long serialVersionUID = 3273994128035865433L;
	
	@Inject
	private Fabricantes fabricantes;
	
	@Inject
	private CadastroFabricanteService cadastroFabricante;
	
	@Inject
	private FacesMessages messages;
	
	private List<Fabricante> todosFabricantes;
	private Fabricante fabricanteEdicao = new Fabricante();
	private Fabricante fabricanteSelecionado;
	
	public void prepararNovoCadastro() {
		fabricanteEdicao = new Fabricante();
	}
	
	public void salvar() {
		cadastroFabricante.salvar(fabricanteEdicao);
		consultar();

		messages.info("Fabricante salvo com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:fabricantes-table"));
	}
	
	public void excluir() {
		cadastroFabricante.excluir(fabricanteSelecionado);
		fabricanteSelecionado = null;

		consultar();

		messages.info("Fabricante excluído com sucesso!");
	}
	
	public void consultar() {
		todosFabricantes = fabricantes.todas();
		System.out.println(todosFabricantes.size());

	}
	
	public List<Fabricante> getTodosFabricantes() {
		return todosFabricantes;
	}

	public Fabricante getFabricanteEdicao() {
		return fabricanteEdicao;
	}

	public void setFabricanteEdicao(Fabricante fabricanteEdicao) {
		this.fabricanteEdicao = fabricanteEdicao;
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	

}
