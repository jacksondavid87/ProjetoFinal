package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import controller.SampleEntity;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "produto_pro_codigo_seq", sequenceName = "produto_pro_codigo_seq", allocationSize = 1, initialValue = 0)
public class Produto implements Serializable, SampleEntity {

	private static final long serialVersionUID = 1020950800821773964L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_pro_codigo_seq")
	private long pro_codigo;
	
	@NotEmpty
	private String pro_nome;
	
	@NotNull
	private int pro_qtd;
	
	@NotNull
	private Double pro_valor_compra;
	
	@NotNull
	private Double pro_valor_venda;
	
	@NotEmpty
	private String pro_aplicacao;
	
	@ManyToOne
	@JoinColumn(name = "fab_codigo")
	private Fabricante fabricante;
	
	@OneToMany(mappedBy = "produto")
	private List<Recarga> recargas;

	public long getPro_codigo() {
		return pro_codigo;
	}

	public void setPro_codigo(long pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	public String getPro_nome() {
		return pro_nome;
	}

	public void setPro_nome(String pro_nome) {
		this.pro_nome = pro_nome;
	}

	public int getPro_qtd() {
		return pro_qtd;
	}

	public void setPro_qtd(int pro_qtd) {
		this.pro_qtd = pro_qtd;
	}

	public Double getPro_valor_compra() {
		return pro_valor_compra;
	}

	public void setPro_valor_compra(Double pro_valor_compra) {
		this.pro_valor_compra = pro_valor_compra;
	}

	public Double getPro_valor_venda() {
		return pro_valor_venda;
	}

	public void setPro_valor_venda(Double pro_valor_venda) {
		this.pro_valor_venda = pro_valor_venda;
	}

	public String getPro_aplicacao() {
		return pro_aplicacao;
	}

	public void setPro_aplicacao(String pro_aplicacao) {
		this.pro_aplicacao = pro_aplicacao;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
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
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((pro_aplicacao == null) ? 0 : pro_aplicacao.hashCode());
		result = prime * result + (int) (pro_codigo ^ (pro_codigo >>> 32));
		result = prime * result + ((pro_nome == null) ? 0 : pro_nome.hashCode());
		result = prime * result + pro_qtd;
		result = prime * result + ((pro_valor_compra == null) ? 0 : pro_valor_compra.hashCode());
		result = prime * result + ((pro_valor_venda == null) ? 0 : pro_valor_venda.hashCode());
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
		Produto other = (Produto) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (pro_aplicacao == null) {
			if (other.pro_aplicacao != null)
				return false;
		} else if (!pro_aplicacao.equals(other.pro_aplicacao))
			return false;
		if (pro_codigo != other.pro_codigo)
			return false;
		if (pro_nome == null) {
			if (other.pro_nome != null)
				return false;
		} else if (!pro_nome.equals(other.pro_nome))
			return false;
		if (pro_qtd != other.pro_qtd)
			return false;
		if (pro_valor_compra == null) {
			if (other.pro_valor_compra != null)
				return false;
		} else if (!pro_valor_compra.equals(other.pro_valor_compra))
			return false;
		if (pro_valor_venda == null) {
			if (other.pro_valor_venda != null)
				return false;
		} else if (!pro_valor_venda.equals(other.pro_valor_venda))
			return false;
		return true;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return pro_codigo;
	}

	
	
	
}
