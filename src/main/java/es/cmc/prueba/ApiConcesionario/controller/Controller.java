package es.cmc.prueba.ApiConcesionario.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cmc.ApiConcesionario.repository.CocheRepository;
import es.cmc.prueba.ApiConcesionario.entities.Coche;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	CocheRepository cocheRepository;
	
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
}
