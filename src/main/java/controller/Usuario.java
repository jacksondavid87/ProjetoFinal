package controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Usuario implements Serializable {

	private static final long serialVersionUID = 2748837857727564816L;

	private String nome;
	private Date dataLogin;
	//private int logado = 0;

	public boolean isLogado() {
		return nome != null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataLogin() {
		return dataLogin;
	}

	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}

	/*public int getLogado() {
		return logado;
	}

	public void setLogado(int logado) {
		this.logado = logado;
	}*/

}
