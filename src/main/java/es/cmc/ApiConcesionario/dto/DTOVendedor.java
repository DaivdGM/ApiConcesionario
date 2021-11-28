package es.cmc.ApiConcesionario.dto;

import java.math.BigDecimal;

public class DTOVendedor {
	private String nombre;
	
	private BigDecimal nomina;

	public DTOVendedor(String nombre, BigDecimal nomina) {
		super();
		this.nombre = nombre;
		this.nomina = nomina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getNomina() {
		return nomina;
	}

	public void setNomina(BigDecimal nomina) {
		this.nomina = nomina;
	}
	
	
}
