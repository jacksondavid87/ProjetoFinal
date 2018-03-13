package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import controller.SampleEntity;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_cli_codigo_seq", sequenceName = "cliente_cli_codigo_seq", allocationSize = 1, initialValue = 0)
public class Cliente implements Serializable, SampleEntity {

	private static final long serialVersionUID = 7106801829663849989L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_cli_codigo_seq")
	private long cli_codigo;
	
	@NotEmpty
	@Column(name = "cli_razao_social", nullable = false, length = 50)
	private String cli_razao_social;
	
	@NotEmpty
	@Column(name = "cli_nome", nullable = false, length = 50)
	private String cli_nome;
	
	@NotEmpty
	@Column(name = "cli_cpf_cnpj", nullable = false, length = 18)
	private String cli_cpf_cnpj;
	
	@NotEmpty
	@Column(name = "cli_fones", length = 11)
	private String cli_fones;
	
	@NotEmpty
	@Column(name = "cli_email", length = 30)
	private String cli_email;
	
	private String cli_cidade;
	
	private String cli_rua;
	
	private String cli_bairro;
	
	private int cli_numero;
	
	@OneToMany(mappedBy = "cliente")
	private List<Recarga> recargas;
	
	@NotEmpty
	@Column(nullable = false)
	private String cli_nome_contato;

	public long getCli_codigo() {
		return cli_codigo;
	}

	public void setCli_codigo(long cli_codigo) {
		this.cli_codigo = cli_codigo;
	}

	public String getCli_razao_social() {
		return cli_razao_social;
	}

	public void setCli_razao_social(String cli_razao_social) {
		this.cli_razao_social = cli_razao_social;
	}

	public String getCli_nome() {
		return cli_nome;
	}

	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}

	public String getCli_cpf_cnpj() {
		return cli_cpf_cnpj;
	}

	public void setCli_cpf_cnpj(String cli_cpf_cnpj) {
		this.cli_cpf_cnpj = cli_cpf_cnpj;
	}

	public String getCli_fones() {
		return cli_fones;
	}

	public void setCli_fones(String cli_fones) {
		this.cli_fones = cli_fones;
	}

	public String getCli_email() {
		return cli_email;
	}

	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}

	public String getCli_cidade() {
		return cli_cidade;
	}

	public void setCli_cidade(String cli_cidade) {
		this.cli_cidade = cli_cidade;
	}

	public String getCli_rua() {
		return cli_rua;
	}

	public void setCli_rua(String cli_rua) {
		this.cli_rua = cli_rua;
	}

	public String getCli_bairro() {
		return cli_bairro;
	}

	public void setCli_bairro(String cli_bairro) {
		this.cli_bairro = cli_bairro;
	}

	public int getCli_numero() {
		return cli_numero;
	}

	public void setCli_numero(int cli_numero) {
		this.cli_numero = cli_numero;
	}

	public String getCli_nome_contato() {
		return cli_nome_contato;
	}

	public void setCli_nome_contato(String cli_nome_contato) {
		this.cli_nome_contato = cli_nome_contato;
	}

	public List<Recarga> getRecargas() {
		return recargas;
	}

	public void setRecargas(List<Recarga> recargas) {
		this.recargas = recargas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_bairro == null) ? 0 : cli_bairro.hashCode());
		result = prime * result + ((cli_cidade == null) ? 0 : cli_cidade.hashCode());
		result = prime * result + (int) (cli_codigo ^ (cli_codigo >>> 32));
		result = prime * result + ((cli_nome_contato == null) ? 0 : cli_nome_contato.hashCode());
		result = prime * result + ((cli_cpf_cnpj == null) ? 0 : cli_cpf_cnpj.hashCode());
		result = prime * result + ((cli_email == null) ? 0 : cli_email.hashCode());
		result = prime * result + ((cli_fones == null) ? 0 : cli_fones.hashCode());
		result = prime * result + ((cli_nome == null) ? 0 : cli_nome.hashCode());
		result = prime * result + cli_numero;
		result = prime * result + ((cli_razao_social == null) ? 0 : cli_razao_social.hashCode());
		result = prime * result + ((cli_rua == null) ? 0 : cli_rua.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cli_bairro == null) {
			if (other.cli_bairro != null)
				return false;
		} else if (!cli_bairro.equals(other.cli_bairro))
			return false;
		if (cli_cidade == null) {
			if (other.cli_cidade != null)
				return false;
		} else if (!cli_cidade.equals(other.cli_cidade))
			return false;
		if (cli_codigo != other.cli_codigo)
			return false;
		if (cli_nome_contato == null) {
			if (other.cli_nome_contato != null)
				return false;
		} else if (!cli_nome_contato.equals(other.cli_nome_contato))
			return false;
		if (cli_cpf_cnpj == null) {
			if (other.cli_cpf_cnpj != null)
				return false;
		} else if (!cli_cpf_cnpj.equals(other.cli_cpf_cnpj))
			return false;
		if (cli_email == null) {
			if (other.cli_email != null)
				return false;
		} else if (!cli_email.equals(other.cli_email))
			return false;
		if (cli_fones == null) {
			if (other.cli_fones != null)
				return false;
		} else if (!cli_fones.equals(other.cli_fones))
			return false;
		if (cli_nome == null) {
			if (other.cli_nome != null)
				return false;
		} else if (!cli_nome.equals(other.cli_nome))
			return false;
		if (cli_numero != other.cli_numero)
			return false;
		if (cli_razao_social == null) {
			if (other.cli_razao_social != null)
				return false;
		} else if (!cli_razao_social.equals(other.cli_razao_social))
			return false;
		if (cli_rua == null) {
			if (other.cli_rua != null)
				return false;
		} else if (!cli_rua.equals(other.cli_rua))
			return false;
		return true;
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return cli_codigo;
	}

}
