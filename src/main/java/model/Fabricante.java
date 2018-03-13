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
@Table(name = "fabricante")
@SequenceGenerator(name = "fabricante_fab_codigo_seq", sequenceName = "fabricante_fab_codigo_seq", allocationSize = 1, initialValue = 0)
public class Fabricante implements Serializable, SampleEntity {

	private static final long serialVersionUID = 401672802639889333L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fabricante_fab_codigo_seq")
	private Long fab_codigo;

	@NotEmpty
	@Column(name = "fab_nome", nullable = false, length = 80)
	private String nomeFabricante;

	@OneToMany(mappedBy = "fabricante")
	private List<Produto> produtos;
	
	@OneToMany(mappedBy = "fabricante")
	private List<Recarga> recargas;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getFab_codigo() {
		return fab_codigo;
	}

	public void setFab_codigo(Long fab_codigo) {
		this.fab_codigo = fab_codigo;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricate) {
		this.nomeFabricante = nomeFabricate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fab_codigo == null) ? 0 : fab_codigo.hashCode());
		result = prime * result + ((nomeFabricante == null) ? 0 : nomeFabricante.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
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
		Fabricante other = (Fabricante) obj;
		if (fab_codigo == null) {
			if (other.fab_codigo != null)
				return false;
		} else if (!fab_codigo.equals(other.fab_codigo))
			return false;
		if (nomeFabricante == null) {
			if (other.nomeFabricante != null)
				return false;
		} else if (!nomeFabricante.equals(other.nomeFabricante))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return fab_codigo;
	}

}
