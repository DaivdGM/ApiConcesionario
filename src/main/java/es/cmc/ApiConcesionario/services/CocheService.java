package es.cmc.ApiConcesionario.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cmc.ApiConcesionario.dto.DTOVendedor;
import es.cmc.ApiConcesionario.repository.CocheRepository;
import es.cmc.prueba.ApiConcesionario.entities.Coche;

@Service
public class CocheService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired CocheRepository cocheRepository;
	
	public List<DTOVendedor> calculaNomina() {
		HashMap<String, BigDecimal> mapaVendedores = new HashMap<>();
		ArrayList<DTOVendedor> vendedores = new ArrayList<>();
		List<Coche> coches = cocheRepository.findAll();
		
		//Se suma el precio de los coches vendidos por cada vendedor
		if (!coches.isEmpty()) {
			coches.forEach(coche -> {
				BigDecimal precioGuardado = mapaVendedores.get(coche.getVendedor());
				if (precioGuardado != null && coche.getPrecioVenta() != null) {
					mapaVendedores.put(coche.getVendedor(), precioGuardado.add(coche.getPrecioVenta()));
				} else if (coche.getPrecioVenta() != null) {
					mapaVendedores.put(coche.getVendedor(), coche.getPrecioVenta());
				}
			});
		} else {
			logger.error("No existen coches vendidos");
			return Collections.emptyList();
		}
		
		//convertimos el HashMap en ArrayList
		mapaVendedores.entrySet().forEach(entry -> vendedores.add(new DTOVendedor(entry.getKey(), entry.getValue())));
		return vendedores;
	}
}
