package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import controller.SampleEntity;

@Entity
@Table(name = "recarga")
@SequenceGenerator(name = "recarga_rec_codigo_seq", sequenceName = "recarga_rec_codigo_seq", allocationSize = 1, initialValue = 0)
public class Recarga implements Serializable, SampleEntity {

	private static final long serialVersionUID = -4494034287537631060L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recarga_rec_codigo_seq")
	private long rec_codigo;
	
	@ManyToOne
	@JoinColumn(name = "pro_codigo")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "fab_codigo")
	private Fabricante fabricante;
	
	@NotEmpty
	private String rec_cartucho;
	
	@NotNull
	private int rec_quantidade;
	
	@NotNull
	private double rec_valor;
	
	@ManyToOne
	@JoinColumn(name = "cli_codigo")
	private Cliente cliente;
	
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	private Date rec_data;
	
	@NotEmpty
	private String rec_pago;

	public long getRec_codigo() {
		return rec_codigo;
	}


	public void setRec_codigo(long rec_codigo) {
		this.rec_codigo = rec_codigo;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


	public String getRec_cartucho() {
		return rec_cartucho;
	}


	public void setRec_cartucho(String rec_cartucho) {
		this.rec_cartucho = rec_cartucho;
	}


	public int getRec_quantidade() {
		return rec_quantidade;
	}


	public void setRec_quantidade(int rec_quantidade) {
		this.rec_quantidade = rec_quantidade;
	}


	public double getRec_valor() {
		return rec_valor;
	}


	public void setRec_valor(double rec_valor) {
		this.rec_valor = rec_valor;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Date getRec_data() {
		return rec_data;
	}


	public void setRec_data(Date rec_data) {
		this.rec_data = rec_data;
	}


	public String getRec_pago() {
		return rec_pago;
	}


	public void setRec_pago(String rec_pago) {
		this.rec_pago = rec_pago;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((rec_cartucho == null) ? 0 : rec_cartucho.hashCode());
		result = prime * result + (int) (rec_codigo ^ (rec_codigo >>> 32));
		result = prime * result + ((rec_data == null) ? 0 : rec_data.hashCode());
		result = prime * result + ((rec_pago == null) ? 0 : rec_pago.hashCode());
		result = prime * result + rec_quantidade;
		long temp;
		temp = Double.doubleToLongBits(rec_valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Recarga other = (Recarga) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (rec_cartucho == null) {
			if (other.rec_cartucho != null)
				return false;
		} else if (!rec_cartucho.equals(other.rec_cartucho))
			return false;
		if (rec_codigo != other.rec_codigo)
			return false;
		if (rec_data == null) {
			if (other.rec_data != null)
				return false;
		} else if (!rec_data.equals(other.rec_data))
			return false;
		if (rec_pago == null) {
			if (other.rec_pago != null)
				return false;
		} else if (!rec_pago.equals(other.rec_pago))
			return false;
		if (rec_quantidade != other.rec_quantidade)
			return false;
		if (Double.doubleToLongBits(rec_valor) != Double.doubleToLongBits(other.rec_valor))
			return false;
		return true;
	}




	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return rec_codigo;
	}

}
