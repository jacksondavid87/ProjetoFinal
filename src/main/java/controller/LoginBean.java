package controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {
	
	@Inject
	private Usuario usu;
	
	private String nomeUsuario;
	private String senha;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println(this.nomeUsuario+","+this.senha+",");
		//System.out.println(new Date());
		if (this.nomeUsuario.equals("jackson") && this.senha.equals("jackson")) {
			System.out.println("Entrou!!!");
			this.usu.setNome(nomeUsuario);
			//usuario.setNome(nomeUsuario);
			this.usu.setDataLogin(new Date());
			//usu.setNome(this.nomeUsuario);
			//usu.setDataLogin(new Date());
			System.out.println(usu.isLogado());
			return "/logado/GestaoRecargas?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		return null;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login.xhtml?faces-redirect=true";
	}
}