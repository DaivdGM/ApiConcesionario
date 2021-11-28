package es.cmc.prueba.ApiConcesionario.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coches")
public class Coche {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "bastidor", unique = true, nullable = false)
	private String bastidor;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "kms")
	private BigDecimal kms;
	
	@Column(name = "propulsion")
	private String propulsion;
	
	@Column(name = "fecha_vendido")
	private Date fechaVendido;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "precio_venta")
	private BigDecimal precioVenta;
	
	@Column(name = "vendedor")
	private String vendedor;
	
	public Coche() {
	}
	

	public Coche(Integer id, String bastidor, String marca, String modelo, BigDecimal kms, String propulsion) {
		super();
		this.id = id;
		this.bastidor = bastidor;
		this.marca = marca;
		this.modelo = modelo;
		this.kms = kms;
		this.propulsion = propulsion;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getKms() {
		return kms;
	}

	public void setKms(BigDecimal kms) {
		this.kms = kms;
	}

	public String getPropulsion() {
		return propulsion;
	}

	public void setPropulsion(String propulsion) {
		this.propulsion = propulsion;
	}
	

	public Date getFechaVendido() {
		return fechaVendido;
	}


	public void setFechaVendido(Date fechaVendido) {
		this.fechaVendido = fechaVendido;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}


	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}


	@Override
	public String toString() {
		return "Coche [id=" + id + ", bastidor=" + bastidor + ", marca=" + marca + ", modelo=" + modelo + ", kms=" + kms
				+ ", propulsion=" + propulsion + "]";
	}
	
	
	
	
}
