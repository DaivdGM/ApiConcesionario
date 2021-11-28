package es.cmc.prueba.ApiConcesionario.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cmc.ApiConcesionario.dto.DTOVendedor;
import es.cmc.ApiConcesionario.repository.CocheRepository;
import es.cmc.ApiConcesionario.services.CocheService;
import es.cmc.prueba.ApiConcesionario.entities.Coche;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	CocheRepository cocheRepository;
	
	@Autowired
	CocheService cocheService;
	
	@PostMapping("/add")
	public void addCoche(@RequestBody Coche coche) {
		try {
			cocheRepository.save(coche);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/coches/{id}")
	public ResponseEntity<Coche> getCocheById (@PathVariable("id") Integer id) {
		Optional<Coche> coche = cocheRepository.findById(id);
		
		if (coche.isPresent()) {
			return new ResponseEntity<>(coche.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/coches")
	public ResponseEntity<List<Coche>> getAllCoches () {
		List <Coche> coches = cocheRepository.findAll();
		
		if (!coches.isEmpty()) {
			return new ResponseEntity<>(coches, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/nominas")
	public ResponseEntity<List<DTOVendedor>> getNominaVendedores () {
		List <DTOVendedor> vendedores = cocheService.calculaNomina();
		
		if (vendedores != null && !vendedores.isEmpty()) {
			return new ResponseEntity<>(vendedores, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/coches/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
		try {
			cocheRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
